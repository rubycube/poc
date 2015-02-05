/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almearrayseek;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sabusreeraj
 */
public class AlmeArraySeekTest {

    public AlmeArraySeekTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class AlmeArraySeek.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AlmeArraySeek.main(args);
    }

    /**
     * Test of arraySearch method, of class AlmeArraySeek.
     */
    @Test
    public void testArraySearchArray1Null() {
        int[] array1 = null;
        int[] array2 = {1, 2};
        boolean result = AlmeArraySeek.validateArray(array1, array2);
        assertEquals(false, result);
    }

    /**
     * Test of arraySearch method, of class AlmeArraySeek.
     */
    @Test
    public void testArraySearchArray2Null() {
        int[] array1 = {1, 2};
        int[] array2 = null;
        boolean result = AlmeArraySeek.validateArray(array1, array2);
        assertEquals(false, result);
    }

    /**
     * Test of arraySearch method, of class AlmeArraySeek.
     */
    @Test
    public void testArraySearchArray2Big() {
        int[] array1 = {1, 2};
        int[] array2 = {1, 2, 3};
        boolean result = AlmeArraySeek.validateArray(array1, array2);
        assertEquals(false, result);
    }

    /**
     * Test of search method, of class AlmeArraySeek.
     */
    @Test
    public void testSearchPosition0() {
        int[] array1 = {1, 2};
        int[] array2 = {1};
        int result = AlmeArraySeek.search(array1, array2);
        assertEquals(0, result);
    }

    /**
     * Test of search method, of class AlmeArraySeek.
     */
    @Test
    public void testSearch() {
        int[] array1 = {1};
        int[] array2 = {1};
        int result = AlmeArraySeek.search(array1, array2);
        assertEquals(0, result);
    }

    /**
     * Test of search method, of class AlmeArraySeek.
     */
    @Test
    public void testSearchPosition1() {
        int[] array1 = {1, 2};
        int[] array2 = {2};
        int result = AlmeArraySeek.search(array1, array2);
        assertEquals(1, result);
    }

    /**
     * Test of search method, of class AlmeArraySeek.
     */
    @Test
    public void testSearchPosition2() {
        int[] array1 = {2, 3, 4, 5};
        int[] array2 = {4, 5};
        int result = AlmeArraySeek.search(array1, array2);
        assertEquals(2, result);
    }

    /**
     * Test of search method, of class AlmeArraySeek.
     */
    @Test
    public void testSearchPosition3() {
        int[] array1 = {1, 2, 3, 4, 5, 4};
        int[] array2 = {4};
        int result = AlmeArraySeek.search(array1, array2);
        assertEquals(3, result);
    }

    /**
     * Test of search method, of class AlmeArraySeek.
     */
    @Test
    public void testSearchNoPosition() {
        int[] array1 = {1, 2, 3, 4, 5, 4};
        int[] array2 = {4, 5, 6};
        int result = AlmeArraySeek.search(array1, array2);
        assertEquals(-1, result);
    }

}
