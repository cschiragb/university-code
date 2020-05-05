import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class StudentTest {
	
	public static final double TOLERANCE = 0.0001;
	
	// testing getters 
	@Test
	public void test1() {
        int[] mariosMarks = {50,50,50,50,50,50,50,50,50,50,50,50,50,50};
        Student mario = new Student("9191919", mariosMarks);
        
        String expectedRegistrationNumber = "9191919";
        int[] expectedMarks = {50,50,50,50,50,50,50,50,50,50,50,50,50,50};
        
        String actualRegistrationNumber = mario.getRegistrationNumber();
        int[] actualMarks = mario.getMarks();
        
        assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
        assertTrue(Arrays.equals(expectedMarks, actualMarks));     
	}
	
	// testing getters with an assignment mark updated in the setter
	@Test
	public void test2() {
        int[] mariasMarks = {50,50,50,50,50,50,50,50,50,50,50,50,50,50};
        Student maria = new Student("10101010", mariasMarks);
        
        maria.setAssignmentMark(13, 100);
        String expectedRegistrationNumber = "10101010";
        int[] expectedMarks = {50,50,50,50,50,50,50,50,50,50,50,50,100,50};
        
        String actualRegistrationNumber = maria.getRegistrationNumber();
        int[] actualMarks = maria.getMarks();
        
        assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
        assertTrue(Arrays.equals(expectedMarks, actualMarks));     
	}     
		
	// testing totalMark and passed
	@Test
	public void test4() {
		int[] philsMarks = {77,90,81,67,78,91,100,58,62,64,67,75,91,65}; // student with enough marks to pass
        Student phil = new Student("1111110", philsMarks);

        int[] josephsMarks = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,90}; // student who was only assessed on the exam
        Student joseph = new Student("1111111", josephsMarks);
        
        int[] tobiasMarks = {50,60,-1,60,65,70,55,66,60,73,65,45,68,54}; // student with mixture of marks and one discounted assessment
        Student tobias = new Student("1111112", tobiasMarks);

        int[] franceskasMarks = {50,30,40,55,25,13,20,51,90,8,7,11,99,20}; // student without enough marks to pass
        Student franceska = new Student("1111113", franceskasMarks);
        
        double expectedTotalMarkPhil = 69.6;
        double expectedTotalMarkJoseph = 90;
        double expectedTotalMarkTobias = 56.3;
        double expectedTotalMarkFranceska = 30.9;
     
        double actualTotalMarkPhil = phil.totalMark();
        double actualTotalMarkJoseph = joseph.totalMark();
        double actualTotalMarkTobias = tobias.totalMark();
        double actualTotalMarkFranceska = franceska.totalMark();
        
        assertEquals(expectedTotalMarkPhil, actualTotalMarkPhil, TOLERANCE);
        assertEquals(expectedTotalMarkJoseph, actualTotalMarkJoseph, TOLERANCE);
        assertEquals(expectedTotalMarkTobias, actualTotalMarkTobias, TOLERANCE);
        assertEquals(expectedTotalMarkFranceska, actualTotalMarkFranceska, TOLERANCE);
        
        assertTrue(phil.passed());
        assertTrue(joseph.passed());
        assertTrue(tobias.passed());
        assertFalse(franceska.passed());
	}
	
	// testing insufficient marks
	@Test
	public void test5() {
		
        int[] louisesMarks = {58,61,58,73,91,84,25,38,75,50,69,72,55,-1}; // student who missed the exam
        Student louise = new Student("1111114", louisesMarks);
        
        double expectedTotalMark = -1;
        
        double actualTotalMark = louise.totalMark();
        
       assertEquals(expectedTotalMark, actualTotalMark, TOLERANCE);
		
	}
	
	@Test
	public void test6() {
		
        int[] eddysMarks = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; // student who was struck off
        Student eddy = new Student("1111114", eddysMarks);
        
        double expectedTotalMark = -1;
        
        double actualTotalMark = eddy.totalMark();
        
       assertEquals(expectedTotalMark, actualTotalMark, TOLERANCE);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test7() {
		
        int[] eddysMarks = {72,38,-1,65,68,73,69,67,64,55,98,100,50,-1}; //student who missed the exam and one assessment
        Student eddy = new Student("1111114", eddysMarks);
        
        // exception should be thrown
        eddy.passed();
        
		
	}
	
}
