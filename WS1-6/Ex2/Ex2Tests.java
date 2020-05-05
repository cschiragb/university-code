import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Ex2Tests {

	public static final double TOLERANCE = 0.00001;

	private Measurable invoice1, invoice2, invoice3, invoice4, invoice5;
	private Measurable patient1, patient2, patient3, patient4, patient5;

	@Before
	public void setUp() {
		invoice1 = new Invoice("42359615", "14-95-63", 6075.70);
		invoice2 = new Invoice("2952513", "98-02-11", 2061.77);
		invoice3 = new Invoice("7472534", "18-8-88", 7956.39);
		invoice4 = new Invoice("075678", "61-12-41", 9536.50);
		invoice5 = new Invoice("665448450755", "100-10-138", 7522.45);

		patient1 = new Patient("John", 54, 93.35);
		patient2 = new Patient("Jack", 24, 81.94);
		patient3 = new Patient("Mary", 44, 73.52);
		patient4 = new Patient("Kate", 57, 58.07);
		patient5 = new Patient("Chris", 39, 97.9);
	}

	// testing max on a list of invoices
	@Test
	public void test1() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);
		invoiceList.add(invoice4);
		invoiceList.add(invoice5);

		double expectedMax = 9536.50;
		double actualMax = Statistics.maximum(invoiceList);

		assertEquals(expectedMax, actualMax, TOLERANCE);

	}

	// testing max on a list of patients
	@Test
	public void test2() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);

		double expectedMax = 97.9;
		double actualMax = Statistics.maximum(patientList);

		assertEquals(expectedMax, actualMax, TOLERANCE);
	}

	// testing average on a list of invoices
	@Test
	public void test3() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);
		invoiceList.add(invoice4);
		invoiceList.add(invoice5);

		double expectedAvg = 6630.562;
		double actualAvg = Statistics.average(invoiceList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}

	// testing average on a list of patients
	@Test
	public void test4() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);

		double expectedAvg = 80.956;
		double actualAvg = Statistics.average(patientList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}

	// testing standard deviation on a list of invoices
	@Test
	public void test5() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);
		invoiceList.add(invoice4);
		invoiceList.add(invoice5);

		double expectedStd = 2836.34853;
		double actualStd = Statistics.standardDeviation(invoiceList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}

	// testing standard deviation on a list of patients
	@Test
	public void test6() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);
		patientList.add(patient4);
		patientList.add(patient5);

		double expectedStd = 15.9745244;
		double actualStd = Statistics.standardDeviation(patientList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}

	// testing statistics on a list with one invoice
	@Test
	public void test7() {
		Measurable invoice6 = new Invoice("56421541", "25-56-54", 0);
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice6);
		double expectedMax = 0;
		double actualMax = Statistics.maximum(invoiceList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 0;
		double actualAvg = Statistics.average(invoiceList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = Double.NaN;
		double actualStd = Statistics.standardDeviation(invoiceList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
	}

	// testing statistics on a list with one patient
	@Test
	public void test8() {
		Measurable patient6 = new Patient("Kevin", 24, 55);
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient6);

		double expectedMax = 55;
		double actualMax = Statistics.maximum(patientList);

		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 55;
		double actualAvg = Statistics.average(patientList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = Double.NaN;
		double actualStd = Statistics.standardDeviation(patientList);
		assertEquals(expectedStd, actualStd, TOLERANCE);	
	}

	// testing statistics on a list of invoices
	@Test
	public void test9() {
		Measurable invoice6 = new Invoice("56421541", "25-52-34", 1000.10);
		Measurable invoice7 = new Invoice("0556552", "35-23-14", 1000.10);
		Measurable invoice8 = new Invoice("5876542", "45-14-44", 1000.10);
		Measurable invoice9 = new Invoice("2357964", "56-32-24", 1000.10);

		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice6);
		invoiceList.add(invoice7);
		invoiceList.add(invoice8);
		invoiceList.add(invoice9);

		double expectedMax = 1000.10;
		double actualMax = Statistics.maximum(invoiceList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 1000.10;
		double actualAvg = Statistics.average(invoiceList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = 0;
		double actualStd = Statistics.standardDeviation(invoiceList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
	}
	
	// testing statistics on a list of patients
	@Test
	public void test10() {
		
		Measurable patient6 = new Patient("John", 54, 66.20);
		Measurable patient7 = new Patient("Jack", 24, 71.43);
		Measurable patient8 = new Patient("Mary", 44, 62.6);
		Measurable patient9 = new Patient("Kate", 57, 30.0);
		Measurable patient10 = new Patient("Chris", 39, 28.34);
		
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient6);
		patientList.add(patient7);
		patientList.add(patient8);
		patientList.add(patient9);
		patientList.add(patient10);

		double expectedMax = 71.43;
		double actualMax = Statistics.maximum(patientList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 51.714;
		double actualAvg = Statistics.average(patientList);
		
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = 20.8261345;
		double actualStd = Statistics.standardDeviation(patientList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
		
	}	
	
	// testing exception produced on statistics when a negative value is found for an invoice amount
	@Test(expected = IllegalArgumentException.class)
	public void test11() {
		Measurable invoice10 = new Invoice("2984398", "56-32-24", -1000.10);
		Measurable invoice11 = new Invoice("2156854", "98-45-31", 2000.10);
		
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice10);
		invoiceList.add(invoice11);
		
		Statistics.average(invoiceList);
		
	}
	
	// testing exception produced on statistics when a negative value is found for an invoice amount
	@Test(expected = IllegalArgumentException.class)
	public void test12() {
		Measurable patient11 = new Patient("Batman", 50, -50);
		Measurable patient12 = new Patient("Robinhood", 35, 70);
			
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient11);
		patientList.add(patient12);
			
		Statistics.average(patientList);
		
	}
	
}
