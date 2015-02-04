/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service.impl;

import com.sky.skypublisher.dao.IPublishTileDao;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.utils.ProjectConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jmock.Expectations;
import static org.jmock.Expectations.any;
import static org.jmock.Expectations.returnValue;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sabusreeraj
 */
public class PublishTileServiceTest {

    private final Mockery mockery = new Mockery();
    private IPublishTileDao publishTileDaoMock = null;
    private PublishTileService publishTileService = null;
    private final Date fixedDateTime = getFixedDate();

    @Before
    public void setUp() {
        publishTileService = new PublishTileService();
        publishTileDaoMock = mockery.mock(IPublishTileDao.class);
        publishTileService.setPublishTileDao(publishTileDaoMock);
    }

    @After
    public void tearDown() {
        //mockery.assertIsSatisfied();
    }

    /**
     * Test of saveTile method, of class PublishTileService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test
    public void testSaveTile() throws BrokenCode {
        mockery.checking(new Expectations() {
            {
                exactly(1).of(publishTileDaoMock).getTodaysTilesByClientAndPosition(with(any(Integer.class)), with(any(Integer.class)));
                will(returnValue(getTiles(2)));
                exactly(2).of(publishTileDaoMock).createOrUpdateTile(with(any(Tile.class)));
                will(returnValue(true));
            }
        });

        Tile tile = new Tile("label", 2, 1, Calendar.getInstance().getTime());
        assertTrue(publishTileService.saveTile(tile));
    }

    /**
     * Test of saveTile method, of class PublishTileService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testSaveTileEmptySchedule() throws BrokenCode {
        mockery.checking(new Expectations() {
            {
                exactly(1).of(publishTileDaoMock).getTodaysTilesByClientAndPosition(with(any(Integer.class)), with(any(Integer.class)));
                will(returnValue(new ArrayList<>()));
            }
        });

        Tile tile = new Tile("label", 2, 1, Calendar.getInstance().getTime());
        try {
            publishTileService.saveTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.EMPTY_SCHEDULE.getCode(), ex.getError());
            throw ex;
        }
    }

    /**
     * Test of saveTile method, of class PublishTileService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testSaveTileEarlyPosition() throws BrokenCode {
        mockery.checking(new Expectations() {
            {
                exactly(1).of(publishTileDaoMock).getTodaysTilesByClientAndPosition(with(any(Integer.class)), with(any(Integer.class)));
                will(returnValue(getTiles(2)));
            }
        });
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -30);
        Tile tile = new Tile("label", 2, 1, cal.getTime());
        try {
            publishTileService.saveTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.EARLY_POSITION.getCode(), ex.getError());
            throw ex;
        }
    }

    /**
     * Test of saveTile method, of class PublishTileService.
     *
     * @throws com.sky.skypublisher.service.impl.BrokenCode
     */
    @Test(expected = BrokenCode.class)
    public void testSaveTilePositionUnavailable() throws BrokenCode {
        mockery.checking(new Expectations() {
            {
                exactly(1).of(publishTileDaoMock).getTodaysTilesByClientAndPosition(with(any(Integer.class)), with(any(Integer.class)));
                will(returnValue(getFixedDateTiles(2)));
            }
        });
        Tile tile = new Tile("label", 2, 1, fixedDateTime);
        try {
            publishTileService.saveTile(tile);
        } catch (BrokenCode ex) {
            assertEquals(ProjectConstants.ErrorCodes.POSITION_UNAVAILABLE.getCode(), ex.getError());
            throw ex;
        }
    }

    private Date getFixedDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.JANUARY, 18, 0, 0, 0);
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        return cal.getTime();
    }

    private List<Tile> getFixedDateTiles(int n) {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Tile tile = new Tile();
            tile.setLabel(String.valueOf(i));
            tile.setPosition(i);
            tile.setStartDateTime(fixedDateTime);
            tiles.add(tile);
        }
        return tiles;
    }

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
