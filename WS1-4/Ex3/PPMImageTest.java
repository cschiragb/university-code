import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PPMImageTest {
    private PPMImage test1, test2, test3, test4;

    @Before
    public void setUp() {
        // test1 = new PPMImage("MyTest1.ppm");
        test1 = new PPMImage("MyTest1.ppm");
    	test2 = new PPMImage("MyTest2.ppm");
        test3 = new PPMImage("MyTest3.ppm");
        test4 = new PPMImage("MyTest4.ppm");

    }

	
    @Test // a colour image of a google logo in low resolution
    public void test1() {

        short[][] expected = { {249, 230, 253},
				  			   {230, 198, 235},
				  			   {247, 220, 248} };

        short[][] actual = test1.makeGrey("MyTest1.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test1a() {
        test1.makeGrey("MyTest1.pgm");
        PGMImage expected = new PGMImage("MyTest1-expected.pgm") ;
        PGMImage actual =   new PGMImage("MyTest1.pgm");
        assertTrue(actual.equals(expected));
    }


    @Test // a single pixel
    public void test2() {

        short[][] expected = { { 110 } };

        short[][] actual = test2.makeGrey("MyTest2.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2a() {
        test2.makeGrey("MyTest2.pgm");
        PGMImage expected = new PGMImage("MyTest2-expected.pgm") ;
        PGMImage actual =   new PGMImage("MyTest2.pgm");
        assertTrue(actual.equals(expected));
    }
	
    @Test // a small column of pixels
    public void test3() {

        short[][] expected = { {40},
				  			   {140},
				  			   {190} };

        short[][] actual = test3.makeGrey("MyTest3.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3a() {
        test3.makeGrey("MyTest3.pgm");
        PGMImage expected = new PGMImage("MyTest3-expected.pgm") ;
        PGMImage actual =   new PGMImage("MyTest3.pgm");
        assertTrue(actual.equals(expected));
    }
	
    @Test // a small row of pixels
    public void test4() {

        short[][] expected = {{240, 195, 180}};

        short[][] actual = test4.makeGrey("MyTest4.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4a() {
        test4.makeGrey("MyTest4.pgm");
        PGMImage expected = new PGMImage("MyTest4-expected.pgm") ;
        PGMImage actual =   new PGMImage("MyTest4.pgm");
        assertTrue(actual.equals(expected));
    }

}
