/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.detector;

import java.util.ArrayList;
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
public class HackerDetectorImplTest {

    HackerDetectorImpl instance = new HackerDetectorImpl();
    ArrayList<Long> logTimeArrayList;

    public HackerDetectorImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        logTimeArrayList = new ArrayList<>();
        HackerDetector.ipMap.put("80.238.9.179", logTimeArrayList);
    }

    @After
    public void tearDown() {
        logTimeArrayList = null;
    }

    /**
     * Test of parseLine method, of class HackerDetectorImpl.
     */
    @Test
    public void testParseSuccessAs1stOccurance() {
        String line = "80.238.9.179,133612947,SIGNIN_SUCCESS,Dave.Branning";
        String expResult = null;
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseFailureAs4thOccurance() {
        putSomeHackedLinesForThisIP("80.238.9.179", 3);
        String line = "80.238.9.179,133612951,SIGNIN_FAILURE,Dave.Branning";
        String expResult = null;
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseFailureAs5thOccurance() {
        putSomeHackedLinesForThisIP("80.238.9.179", 4);
        String line = "80.238.9.179,133612952,SIGNIN_FAILURE,Dave.Branning";
        String expResult = "80.238.9.179";
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseFailureAs5thOccuranceAfter5thMinute() {
        putSomeHackedLinesForThisIP("80.238.9.179", 4);
        String line = "80.238.9.179,133912952,SIGNIN_FAILURE,Dave.Branning";
        String expResult = null;
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseSuccessAs5thOccurance() {
        putSomeHackedLinesForThisIP("80.238.9.179", 4);
        String line = "80.238.9.179,133912952,SIGNIN_SUCCESS,Dave.Branning";
        String expResult = null;
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseFailureAs5thOccuranceButNewIP() {
        putSomeHackedLinesForThisIP("80.238.9.179", 4);
        String line = "80.238.9.178,133912952,SIGNIN_SUCCESS,Dave.Branning";
        String expResult = null;
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    private void putSomeHackedLinesForThisIP(String ip, int noOfLines) {
        long logTime = Long.valueOf("133612947");
        for (int i = 1; i <= noOfLines; i++) {
            logTimeArrayList.add(logTime + i);
        }
    }

}
