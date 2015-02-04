/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service;

import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.impl.BrokenCode;
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
public class ITileValidatorServiceTest {

    public ITileValidatorServiceTest() {
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
     * Test of validateTile method, of class ITileValidatorService.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateTileFalse() throws Exception {
        ITileValidatorService instance = new ITileValidatorServiceImpl();
        assertEquals(false, instance.validateTile(null));
    }

    /**
     * Test of validateTile method, of class ITileValidatorService.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateTileTrue() throws Exception {
        ITileValidatorService instance = new ITileValidatorServiceImpl();
        assertEquals(true, instance.validateTile(new Tile()));
    }

    public class ITileValidatorServiceImpl implements ITileValidatorService {

        @Override
        public boolean validateTile(Tile tile) throws BrokenCode {
            return null != tile;
        }
    }

}
