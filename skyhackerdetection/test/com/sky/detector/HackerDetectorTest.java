/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.detector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author computer
 */
public class HackerDetectorTest {

    public HackerDetectorTest() {
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
     * Test of parseLine method, of class HackerDetector.
     */
    @Test
    public void testParseLine() {
        String line = null;
        HackerDetector instance = new HackerDetectorImpl();
        String expResult = null;
        String result = instance.parseLine(line);
        assertEquals(expResult, result);
    }

    public class HackerDetectorImpl implements HackerDetector {

        @Override
        public String parseLine(String line) {
            return null;
        }
    }

}
