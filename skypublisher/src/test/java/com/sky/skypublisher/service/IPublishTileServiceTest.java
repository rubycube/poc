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
public class IPublishTileServiceTest {

    public IPublishTileServiceTest() {
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
     * Test of saveTile method, of class IPublishTileService.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveTileFalse() throws Exception {
        IPublishTileService instance = new IPublishTileServiceImpl();
        assertEquals(false, instance.saveTile(null));
    }

    /**
     * Test of saveTile method, of class IPublishTileService.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveTileTrue() throws Exception {
        IPublishTileService instance = new IPublishTileServiceImpl();
        assertEquals(true, instance.saveTile(new Tile()));
    }

    public class IPublishTileServiceImpl implements IPublishTileService {

        @Override
        public boolean saveTile(Tile tile) throws BrokenCode {
            return null != tile;
        }
    }

}
