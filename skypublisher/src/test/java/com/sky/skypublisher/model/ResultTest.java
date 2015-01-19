/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.model;

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
public class ResultTest {

    public ResultTest() {
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
     * Test of getCode method, of class Result.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        String code = "SUCESS";
        Result instance = new Result(code);
        String result = instance.getCode();
        assertEquals(code, result);
    }

    /**
     * Test of setCode method, of class Result.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "SUCESS";
        Result instance = new Result();
        instance.setCode(code);
        assertEquals(code, instance.getCode());
    }

}
