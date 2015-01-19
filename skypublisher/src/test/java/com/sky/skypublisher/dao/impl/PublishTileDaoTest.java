/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.dao.impl;

import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.impl.BrokenCode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
public class PublishTileDaoTest {

    public PublishTileDaoTest() {
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
     * Test of getTiles method, of class PublishTileDao.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test
    public void testGetTiles() throws BrokenCode {
        int clientId = 0;
        int position = 0;
        PublishTileDao instance = new PublishTileDao();
        List<Tile> expResult = getTiles(3);
        List<Tile> result = instance.getTodaysTilesByClientAndPosition(clientId, position);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of createOrUpdateTile method, of class PublishTileDao.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test
    public void testCreateOrUpdateTile() throws BrokenCode {
        Tile tile = null;
        PublishTileDao instance = new PublishTileDao();
        boolean expResult = true;
        boolean result = instance.createOrUpdateTile(tile);
        assertEquals(expResult, result);
    }

    // A list of hard coded tiles as there is no DB!
    private List<Tile> getTiles(int n) {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MINUTE, -i);
            Tile tile = new Tile();
            tile.setLabel(String.valueOf(i));
            tile.setPosition(i);
            tile.setStartDateTime(cal.getTime());
            tiles.add(tile);
        }
        return tiles;
    }

}
