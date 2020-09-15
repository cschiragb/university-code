package image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Mat;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 * 
 * @author Chirag Bhatti (cxb937)
 * @version 09.08.2020
 * 
 * A class of static helper methods to carry out useful operations, for running a JavaFX Application that uses the OpenCV Library.
 */
public final class Utilities {

	/**
	 * Static method to convert OpenCV MAT image to corresponding image that can be shown in JavaFX Application
	 * @param frame of type Mat from OpenCV
	 * @return Image (JavaFX)
	 */
	public static Image mat2Image(Mat frame) {
		try {
			return SwingFXUtils.toFXImage(matToBufferedImage(frame), null);
		} catch (Exception e) {
			System.err.println("Cannot convert the Mat object: " + e);
			return null;
		}
	}
	
	/**
	 * Helper method for the mat2Image method above.
	 * Converted OpenCV Mat Image to a Java BufferedImage
	 * @param original
	 * @return
	 */
	private static BufferedImage matToBufferedImage(Mat original) {
		BufferedImage image = null;
		int width = original.width(), height = original.height(), channels = original.channels();
		byte[] sourcePixels = new byte[width * height * channels];
		original.get(0, 0, sourcePixels);
		
		if (original.channels() > 1)
			image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		else
			image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);
		
		return image;
	}
	
	/**
	 * A generic method for putting an element running on a non-JavaFX thread on the JavaFX thread, in order to properly update the GUI
	 * @param <T>
	 * @param property
	 * @param value
	 */
	public static <T> void onFXThread(final ObjectProperty<T> property, final T value) {
		Platform.runLater(() -> {
			property.set(value);
		});
	}
}
