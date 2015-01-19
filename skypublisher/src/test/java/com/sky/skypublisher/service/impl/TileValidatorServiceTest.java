/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service.impl;

import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.utils.ProjectConstants;
import java.util.Arrays;
import java.util.Date;
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
public class TileValidatorServiceTest {

    public TileValidatorServiceTest() {
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
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test
    public void testValidateTileLabel() throws BrokenCode {
        Tile tile = new Tile("label", 2, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        assertTrue(instance.validateTile(tile));
    }

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test
    public void testValidateTileMinMaxLabelSize() throws BrokenCode {
        Tile tile = new Tile("l", 2, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        assertTrue(instance.validateTile(tile));
        char[] chars = new char[30];
        Arrays.fill(chars, 'l');
        tile.setLabel(new String(chars));
        assertTrue(instance.validateTile(tile));
    }

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testValidateTileNullLabel() throws BrokenCode {
        Tile tile = new Tile(null, 2, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        try {
            instance.validateTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.INVALID_LABEL.getCode(), ex.getError());
            throw new BrokenCode();
        }
    }

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testValidateTileEmptyLabel() throws BrokenCode {
        Tile tile = new Tile(" ", 2, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        try {
            instance.validateTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.INVALID_LABEL.getCode(), ex.getError());
            throw new BrokenCode();
        }
    }
    
    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testValidateTileInvalidLabel() throws BrokenCode {
        Tile tile = new Tile("label*£l2345", 2, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        try {
            instance.validateTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.INVALID_LABEL.getCode(), ex.getError());
            throw new BrokenCode();
        }
    }    

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testValidateTileExtraLabelSize() throws BrokenCode {
        char[] chars = new char[31];
        Arrays.fill(chars, 'a');
        String label = new String(chars);
        Tile tile = new Tile(label, 2, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        try {
            instance.validateTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.INVALID_LABEL.getCode(), ex.getError());
            throw new BrokenCode();
        }
    }

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test
    public void testValidateTilePosition() throws BrokenCode {
        Tile tile = new Tile("label", 5, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        assertTrue(instance.validateTile(tile));
        tile.setPosition(1);
        assertTrue(instance.validateTile(tile));
        tile.setPosition(8);
        assertTrue(instance.validateTile(tile));
    }

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testValidateTileMinPosition() throws BrokenCode {
        Tile tile = new Tile("label", 0, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        try {
            instance.validateTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.INVALID_POSITION.getCode(), ex.getError());
            throw new BrokenCode();
        }
    }

    /**
     * Test of validateTile method, of class TileValidatorService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testValidateTileMaxPosition() throws BrokenCode {
        Tile tile = new Tile("label", 9, 1, new Date());
        TileValidatorService instance = new TileValidatorService();
        try {
            instance.validateTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.INVALID_POSITION.getCode(), ex.getError());
            throw new BrokenCode();
        }
    }

}
