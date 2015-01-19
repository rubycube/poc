/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.utils;

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
public class ProjectConstantsTest {
    
    public ProjectConstantsTest() {
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
    
    @Test
    public void testFieldsNotNull() throws Exception {
        assertNotNull(ProjectConstants.ErrorCodes.INVALID_LABEL);
        assertNotNull(ProjectConstants.ErrorCodes.INVALID_POSITION);
        assertNotNull(ProjectConstants.ErrorCodes.EMPTY_SCHEDULE);
        assertNotNull(ProjectConstants.ErrorCodes.POSITION_UNAVAILABLE);
        assertNotNull(ProjectConstants.ErrorCodes.EARLY_POSITION);
        assertNotNull(ProjectConstants.ErrorCodes.UNKOWN_ERROR);
        assertNotNull(ProjectConstants.SUCCESS);
        assertNotNull(ProjectConstants.ERROR);
        assertNotNull(ProjectConstants.DEFAULT_TIMEZONE);
    }
}
