/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service.impl;

import com.sky.skypublisher.dao.IPublishTileDao;
import com.sky.skypublisher.service.IPublishTileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.utils.ProjectConstants;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author sabusreeraj
 */
@Service
public class PublishTileService implements IPublishTileService {

    @Autowired
    private IPublishTileDao publishTileDao = null;

    @Override
    public boolean saveTile(Tile tile) throws BrokenCode {
        List<Tile> tiles = getTodaysTilesByClientAndPosition(tile);
        if (null == tiles || tiles.isEmpty()) {
            throw new BrokenCode(ProjectConstants.ErrorCodes.EMPTY_SCHEDULE.getCode());
        }
        if (tiles.size() > 1) {
            sortTiles(tiles);
        }
        if (checkPostTileExists(tiles, tile)) {
            throw new BrokenCode(ProjectConstants.ErrorCodes.EARLY_POSITION.getCode());
        }
        Tile lastTile = getLastTile(tiles, tile);
        setTileEndDate(lastTile, tile.getStartDateTime());
        setTileEndDate(tile, getEndDate());
        createOrUpdateTile(lastTile);
        createOrUpdateTile(tile);
        return true;
    }

    private Tile getLastTile(List<Tile> tiles, Tile tile) throws BrokenCode {
        Tile lastTile = null;
        for (Tile tileObj : tiles) {
            if (!tile.getStartDateTime().after(tileObj.getStartDateTime())) {
                throw new BrokenCode(ProjectConstants.ErrorCodes.POSITION_UNAVAILABLE.getCode());
            } else {
                lastTile = tileObj;
                break;
            }
        }
        return lastTile;
    }

    private void sortTiles(List<Tile> tiles) {
        Collections.sort(tiles, new Comparator<Tile>() {
            @Override
            public int compare(Tile t1, Tile t2) {
                return t1.getStartDateTime().compareTo(t2.getStartDateTime());
            }
        });
    }

    private Date getEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2100, Calendar.JANUARY, 1, 0, 0, 0);
        cal.setTimeZone(TimeZone.getTimeZone(ProjectConstants.DEFAULT_TIMEZONE));
        return cal.getTime();
    }

    private boolean createOrUpdateTile(Tile tile) throws BrokenCode {
        return publishTileDao.createOrUpdateTile(tile);
    }

    private List<Tile> getTodaysTilesByClientAndPosition(Tile tile) throws BrokenCode {
        return publishTileDao.getTodaysTilesByClientAndPosition(tile.getClientId(), tile.getPosition());
    }

    private boolean checkPostTileExists(List<Tile> tiles, Tile tile) {
        return tile.getStartDateTime().before(tiles.get(0).getStartDateTime());
    }

    private void setTileEndDate(Tile tile, Date tileEndDate) {
        tile.setEndDateTime(tileEndDate);
    }

    public void setPublishTileDao(IPublishTileDao publishTileDao) {
        this.publishTileDao = publishTileDao;
    }
}
