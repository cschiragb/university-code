package video;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfRect;
import org.opencv.core.MatOfRect2d;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Rect2d;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.dnn.Dnn;
import org.opencv.dnn.Net;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.utils.Converters;
import org.opencv.video.KalmanFilter;
import org.opencv.videoio.VideoCapture;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * 
 * @author Chirag Bhatti (cxb937)
 * @version	22.08.2020
 * 
 * The MainController class defines specific behaviours and functions within the GUI
 * Here we initialise the Facetime Camera from the Macbook Pro and do the image 
 * processing on the feed.
 * The work is completed on a scheduled worker thread executing every 33ms providing 
 * results that could theoretically run to 30fps.
 * 
 */
public class MainController {
	@FXML
	private Button applicationButton;
	@FXML
	private ImageView faceFrame, leftEyeFrame, rightEyeFrame, watchFrame;
	@FXML
	private Circle gazeReticle;	
	@FXML
	private Circle focusReticle;
	
	/*
	 * Variables for the eye gaze estimation component
	 */
	private ScheduledExecutorService iTrackerTimer;
	private VideoCapture capture;
	private boolean cameraActive, initialised;
	private CascadeClassifier faceCascade, eyeCascade;
	private int absoluteFaceSize;
	private String iTrackerCaffePrototxt, iTrackerCaffeModel;
	private Mat measurement;
	private KalmanFilter filter 	= new KalmanFilter(4, 2, 0); 
	private Mat transitionMatrix 	= new Mat(4, 4, CvType.CV_32F, new Scalar(0));

	/*
	 * Variables for the YOLOv3 component
	 */
	private ScheduledExecutorService yoloV3Timer;
	private List<String> outlayerNames;
	private String yoloV3Weights, yoloV3Config, videoFile;
	private Net yoloV3Net;
	private VideoCapture videoToWatch;
	private Size yoloSize = new Size(320, 320);

	/**
	 * The method is called by the Main Class, at the start up 
	 * of the application and GUI to enable initialisations.
	 */
	protected void init() {
		/*
		 * Initialisation for the eye gaze estimation component
		 */
		this.capture 				= new VideoCapture(); 	
		this.faceCascade 			= new CascadeClassifier("Resources/OpenCV_Haar_Cascades/haarcascade_frontalface_default.xml");
		this.eyeCascade	 			= new CascadeClassifier("Resources/OpenCV_Haar_Cascades/haarcascade_eye.xml");
		this.iTrackerCaffePrototxt 	= "Resources/iTracker_NNs/Caffe_Original/itracker_deploy.prototxt";
		this.iTrackerCaffeModel 	= "Resources/iTracker_NNs/Caffe_Original/snapshots/itracker25x_iter_92000.caffemodel";

		float[] tM = 	{1, 0, 1, 0,
						 0, 1, 0, 1,
						 0, 0, 1, 0,
						 0, 0, 0, 1 };

		transitionMatrix.put(0, 0, tM);
		this.filter.set_transitionMatrix(this.transitionMatrix);

		this.measurement = new Mat(2, 1, CvType.CV_32F, new Scalar(0));
		this.measurement.setTo(new Scalar(0));
		this.initialised = false;

		/*
		 * Initialisation for the YOLOv3 component
		 */
		yoloV3Weights 	= "Resources/YOLOv3/yolov3-tiny.weights";
		yoloV3Config	= "Resources/YOLOv3/yolov3-tiny.cfg";
		videoFile		= "Resources/Media/Black_Ferrari.mp4";
		videoToWatch	= new VideoCapture(videoFile);

		yoloV3Net		= Dnn.readNetFromDarknet(yoloV3Config, yoloV3Weights);
		yoloV3Net.setPreferableBackend(Dnn.DNN_BACKEND_OPENCV);
		yoloV3Net.setPreferableTarget(Dnn.DNN_TARGET_OPENCL);
	}

	@FXML
	/**
	 * This method is called when the button on the 
	 * GUI is pressed to activate the application.
	 */
	protected void startApplication() {
		if (!this.cameraActive) { 			
			this.capture.open(0); 			

			if (this.capture.isOpened()) { 					
				this.cameraActive = true; 	

				Runnable frameGrabber = new Runnable() { 		// Grab and process frames from webcam using a separate thread
					@Override
					public void run() { 								
						Mat frame = grabFrame(); 						
						Image frameToShow = Utilities.mat2Image(frame); 
						updateImageView(faceFrame, frameToShow); 		
					}
				};

				Runnable yoloFrameGrabber = new Runnable() {
					@Override
					public void run() {
						Mat yoloFrame = grabYoloFrame();
						Image yoloFrameToShow = Utilities.mat2Image(yoloFrame);
						updateImageView(watchFrame, yoloFrameToShow);
					}
				};

				this.iTrackerTimer = Executors.newSingleThreadScheduledExecutor(); 					
				this.iTrackerTimer.scheduleAtFixedRate(
						frameGrabber,
						0, 
						33, 
						TimeUnit.MILLISECONDS); 									// Execute webcam frame and grab and process every 33ms => 30fps
				this.applicationButton.setText("Stop the Application"); 			// Update our application button text

				this.yoloV3Timer = Executors.newSingleThreadScheduledExecutor(); 					
				this.yoloV3Timer.scheduleAtFixedRate(
						yoloFrameGrabber,
						0, 
						33, 
						TimeUnit.MILLISECONDS); 									// Execute webcam frame and grab and process every 33ms => 30fps
				
			} else 
				System.err.println("Failed to open the camera");

		} else { 	// if the camera is already active														
			this.cameraActive = false; 									
			this.applicationButton.setText("Start the Application"); 	
			this.stopAcquisition(); 									
		}
	}

	/**
	 * Method to get a frame from the built-in Facetime 
	 * webcam and return the processed frame.
	 * @return processed frame as Mat
	 */
	private Mat grabFrame() {
		Mat frame = new Mat();
		if (this.capture.isOpened()) { 				// Check if the capture is open
			try {
				this.capture.read(frame);			

				if (!frame.empty())  				
					this.detectAndDisplay(frame); 	// Do face and eye detection and infer eye gaze coordinate

			} catch (Exception e) {
				System.err.println("Exception during the image elaboration: " + e); 
			}
		}
		return frame;
	}

	private Mat grabYoloFrame() {

		Mat frame 			= new Mat();
		boolean status 		= videoToWatch.read(frame);
		List<Mat> result 	= new ArrayList<>();

		Imgproc.resize(frame, frame, new Size(262, 465));
		
		if (status) {
			
			Mat yoloBlob = Dnn.blobFromImage(
					frame, 
					0.00392, 
					yoloSize, 
					new Scalar(0), 
					true, 
					false);
			
			this.yoloV3Net.setInput(yoloBlob);
			this.yoloV3Net.forward(result, outlayerNames);

			float confidenceThreshold 	= 0.6f;					// Confidence threshold for the bounding box 				
			List<Integer> classIds 		= new ArrayList<>();
			List<Float>   confidences 	= new ArrayList<>();
			List<Rect2d>  rects2d 		= new ArrayList<>();

			for (int i = 0; i < result.size(); ++i) {	
				
				Mat level = result.get(i);						// Assessed each result Mat for possible bounding boxes
				
				for (int j = 0; j < level.rows(); ++j) {
					
					/*
					 * Each row has a possible detection
					 * In order, the first 4 numbers give box
					 * centerX, centerY, width and height
					 * followed by N-4 class probabilities
					 */
					Mat row 				= level.row(j);
					Mat scores 				= row.colRange(5, level.cols());	// Scores are all found after first 4 numbers
					Core.MinMaxLocResult mm = Core.minMaxLoc(scores); 			// Find the global min and max on scores Mat
					float confidence 		= (float) mm.maxVal;				// Set the confidence to the max found
					Point classIdPoint 		= mm.maxLoc;						// Set a point to where max is found

					if (confidence > confidenceThreshold) {

						/*
						 * We apply scaling for drawing bound boxes 
						 * by multiplying by the relevant frame dimension
						 */
						int centerX = (int)(row.get(0,0)[0] * frame.cols()); 	
						int centerY = (int)(row.get(0,1)[0] * frame.rows());
						int width   = (int)(row.get(0,2)[0] * frame.cols());
						int height  = (int)(row.get(0,3)[0] * frame.rows());
						int left    = centerX - width  / 2;
						int top     = centerY - height / 2;

						classIds.add((int)classIdPoint.x);
						confidences.add((float)confidence);
						rects2d.add(new Rect2d(left, top, width, height));
					}
				}
			}

			float nmsThreshold = 0.5f;		// Non max suppression threshold

			if (confidences.size() > 0) {	// Provided we have detections with associated confidences to process
				
				MatOfFloat matConfidences 	= new MatOfFloat(Converters.vector_float_to_Mat(confidences));
				Rect2d[] rects2dArray 		= rects2d.toArray(new Rect2d[0]);
				MatOfRect2d boxes 			= new MatOfRect2d(rects2dArray);
				MatOfInt indices 			= new MatOfInt();
				
				/*
				 * Perform Non Max Suppression to help 
				 * ensure there is one box per detection
				 */
				Dnn.NMSBoxes(
						boxes, 
						matConfidences, 
						confidenceThreshold, 
						nmsThreshold, 
						indices); 

				int [] ind = indices.toArray();
				
				TreeMap<Double, Rect2d> possibleBoxes = new TreeMap<>();

				for (int i = 0; i < ind.length; ++i) {
					
					int idx 	= ind[i];
					Rect2d box 	= rects2dArray[idx];
					
					double xmin = box.tl().x;
					double xmax = box.br().x;
					
					double ymin = box.tl().y;
					double ymax = box.br().y;
						
					double xLoss = Math.pow(this.gazeReticle.getCenterX() - (xmin + box.width/2), 2);
					double yLoss = Math.pow(this.gazeReticle.getCenterY() - (ymin + box.height/2), 2);
					double L2Loss = xLoss + yLoss;
					possibleBoxes.put(L2Loss, box);
					
//					}
					

					}
				
				if (possibleBoxes.size() > 0) {
					Rect2d boxToShow = possibleBoxes.get(possibleBoxes.firstKey());
					
					this.focusReticle.setCenterX(boxToShow.tl().x + boxToShow.width/2);
					this.focusReticle.setCenterY(boxToShow.tl().y + boxToShow.height/2 + 55);
				}
			}
		}
		return frame;
	}

	/**
	 * Method to take in frame from webcam, detect eyes and faces, infer 
	 * eye gaze estimation point on screen and update GUI accordingly. 
	 * @param frame from webcam
	 */
	private void detectAndDisplay(Mat frame) {
		MatOfRect faces = new MatOfRect();
		MatOfRect eyes 	= new MatOfRect();
		Mat grayFrame 	= new Mat();

		Mat faceRoI, faceRoIResized;
		Mat faceBinaryMask, faceBinaryMaskResized;
		Mat eyeRRoI, eyeRRoIResized;
		Mat eyeLRoI, eyeLRoIResized;

		double[] xcoord, ycoord;

		Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);	// Convert image to gray scale as this improves the HAAR face detection
		Imgproc.equalizeHist(grayFrame, grayFrame);

		if (this.absoluteFaceSize == 0) {
			int height = grayFrame.rows();

			if (Math.round(height * 0.2f) > 0) {					// Compute minimum face size (20% of the frame height)
				this.absoluteFaceSize = Math.round(height * 0.2f); 	
			}
		}

		/*
		 * Detect faces in from grayframe version 
		 * of webcam frame. The face size must 20% 
		 * of the overall frame size to be detected.
		 */
		this.faceCascade.detectMultiScale(
				grayFrame, 
				faces, 
				1.1, 
				2, 
				0 | Objdetect.CASCADE_SCALE_IMAGE, 
				new Size(this.absoluteFaceSize, this.absoluteFaceSize), 
				new Size());

		Rect[] facesArray = faces.toArray();

		if (facesArray.length == 1) {							// Ensure there is only 1 face detected
			faceRoI 		= new Mat(frame, facesArray[0]);	// Extract just the face region of interest
			faceRoIResized 	= new Mat();										
			Imgproc.resize(faceRoI, faceRoIResized, new Size(224, 224));	

			faceBinaryMask 	= Mat.zeros(frame.rows(), frame.cols(), CvType.CV_8U); 	// Make the face binary mask initialised with zeros
			faceBinaryMask.submat(facesArray[0]).setTo(new Scalar(1.0));			// Set ones in the binary mask where the face rectangle is located w.r.t. to the whole webcam frame

			faceBinaryMaskResized = new Mat();
			faceBinaryMaskResized = faceBinaryMask.reshape(0, 1);					// Flatten the face binary mask to one row and many columns

			/*
			 * Detect the eyes within the face 
			 * region of interest. This is more 
			 * robust to misdetections compared 
			 * to using the whole frame from the 
			 * webcam
			 */
			this.eyeCascade.detectMultiScale(
					faceRoI, 
					eyes);

			Rect[] eyeArray = eyes.toArray();

			if (eyeArray.length == 2) { 	// Ensure there are 2 eyes detected

				/*
				 * We can't be sure which eyes are left and 
				 * right so we use the x coordinates of the 
				 * rectangles to work this out
				 */
				if (eyeArray[0].x < eyeArray[1].x) {
					eyeRRoI = new Mat(faceRoI, eyeArray[0]);
					eyeLRoI = new Mat(faceRoI, eyeArray[1]);
				} else {
					eyeRRoI = new Mat(faceRoI, eyeArray[1]);
					eyeLRoI = new Mat(faceRoI, eyeArray[0]);
				}

				/*
				 * Update the GUI with the detected eye images
				 */
				Image leftEyeFrameToShow 	= Utilities.mat2Image(eyeLRoI); 	
				Image rightEyeFrameToShow 	= Utilities.mat2Image(eyeRRoI); 	
				updateImageView(leftEyeFrame, leftEyeFrameToShow); 			
				updateImageView(rightEyeFrame, rightEyeFrameToShow); 		

				eyeRRoIResized = new Mat();
				eyeLRoIResized = new Mat();
				Imgproc.resize(eyeRRoI, eyeRRoIResized, new Size(224, 224));
				Imgproc.resize(eyeLRoI, eyeLRoIResized, new Size(224, 224));

				Net iTracker = Dnn.readNetFromCaffe(iTrackerCaffePrototxt, iTrackerCaffeModel);	// Read in the iTracker CNN Model

				/*
				 * Prepares inputs for the iTracker CNN. 
				 * Includes mean image subtraction and crop 
				 * from centre.
				 */
				Size standardSize 	= new Size(224, 224);

				Mat image_face	= Dnn.blobFromImage(
						faceRoI, 				
						(1.0), 	
						standardSize,		
						new Scalar(100.9692, 112.3287,  148.3662),  
						false, 	
						true);

				Mat image_left	= Dnn.blobFromImage(
						eyeLRoIResized, 		
						(1.0), 	
						standardSize, 		
						new Scalar(97.5155,  105.8145,  141.6497), 	
						false, 	
						true);

				Mat image_right = Dnn.blobFromImage(
						eyeRRoIResized, 		
						(1.0), 	
						standardSize, 		
						new Scalar(93.2592,  102.0831,  135.0456), 	
						false, 	
						true);

				Mat facegrid 	= Dnn.blobFromImage(
						faceBinaryMaskResized, 	
						(1.0), 	
						new Size(1, 625), 	
						new Scalar(0, 0), false);

				iTracker.setInput(image_face, 	"image_face");
				iTracker.setInput(facegrid, 	"facegrid");
				iTracker.setInput(image_left, 	"image_left");
				iTracker.setInput(image_right, 	"image_right");

				Mat predictedGazeCoordinates = iTracker.forward();
				xcoord = predictedGazeCoordinates.get(0, 0);
				ycoord = predictedGazeCoordinates.get(0, 1);

				/*
				 * If the Kalman Filter has not been intialised / used yet,
				 * we initialise it for better behaviour at the start.
				 */
				if (!initialised) {	
					filter.get_statePre().put(0, 0, xcoord);
					filter.get_statePre().put(1, 0, ycoord);
					filter.get_statePre().put(2, 0, 0.0);
					filter.get_statePre().put(3, 0, 0.0);

					Mat measurementMatrix 	= Mat.eye(
							filter.get_measurementMatrix().rows(), 
							filter.get_measurementMatrix().cols(), 
							CvType.CV_32F);

					filter.set_measurementMatrix(measurementMatrix);

					Mat processNoiseCov 	= Mat.eye(
							filter.get_processNoiseCov().rows(), 
							filter.get_processNoiseCov().cols(), 
							CvType.CV_32F);

					Mat newProcessNoiseCov 	= new Mat();
					Core.multiply(processNoiseCov, new Scalar(1e-1), newProcessNoiseCov);
					filter.set_processNoiseCov(newProcessNoiseCov);

					Mat measNoiseCov 		= Mat.eye(
							filter.get_measurementNoiseCov().rows(), 
							filter.get_measurementNoiseCov().cols(), 
							CvType.CV_32F);

					Mat newMeasNoiseCov 	= new Mat();
					Core.multiply(measNoiseCov, new Scalar(1e-1), newMeasNoiseCov);
					filter.set_measurementNoiseCov(newMeasNoiseCov);

					Mat errorCovPost 		= Mat.eye(
							filter.get_errorCovPost().rows(), 
							filter.get_errorCovPost().cols(), 
							CvType.CV_32F);

					Mat newErrorCovPost 	= new Mat();
					Core.multiply(errorCovPost, new Scalar(0.1), newErrorCovPost);
					filter.set_errorCovPost(newErrorCovPost);

					this.initialised = true;

				} else {
					filter.predict(); 
					this.measurement.put(0, 0, xcoord);
					this.measurement.put(1, 0, ycoord);
					Mat estimated = filter.correct(measurement);
					xcoord = estimated.get(0, 0);
					ycoord = estimated.get(1, 0);
				}

				/*
				 * Determine the current position of the eye gaze reticle on the screen
				 */
				double currentCentreX = this.gazeReticle.getCenterX();
				double currentCentreY = this.gazeReticle.getCenterY();
				
				/*
				 * Calculate the new position of the eye gaze reticle on the screen.
				 * For X axis, as camera is in centre of gaze pane, take the offset 131,
				 * take the estimate which is in cm from the camera, convert this to inches,
				 * and multiply by the pixels per inch (ppi) to get the pixel coordinate
				 * Likewise for y but without the offset. However as y axis is +ve in JavaFX
				 * down the screen but is -ve for the model, we need to flip our result by 
				 * multiplying by -1.
				 */
				double newCentreX = (131.0 + (xcoord[0] * 0.39370079 * 113.49));
				double newCentreY = (ycoord[0] * -1 * 0.39370079 * 113.49); 
				
				this.gazeReticle.setCenterX(newCentreX);
				this.gazeReticle.setCenterY(newCentreY);
			}
		}
	}

	/**
	 * 
	 */
	private void stopAcquisition() {
		if (this.iTrackerTimer!=null && !this.iTrackerTimer.isShutdown()) {
			try {
				this.iTrackerTimer.shutdown();
				this.iTrackerTimer.awaitTermination(33, TimeUnit.MILLISECONDS);
				this.yoloV3Timer.shutdown();
				this.yoloV3Timer.awaitTermination(33, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				System.err.println("Exception in stopping the frame capture, trying to release the camera now... " + e);
			}
		}

		if (this.capture.isOpened()) 
			this.capture.release();
	}

	/**
	 * 
	 * @param view
	 * @param image
	 */
	private void updateImageView(ImageView view, Image image) {
		Utilities.onFXThread(view.imageProperty(), image);
	}

	/**
	 * 
	 */
	protected void setClosed() {
		this.stopAcquisition();
	}


}
