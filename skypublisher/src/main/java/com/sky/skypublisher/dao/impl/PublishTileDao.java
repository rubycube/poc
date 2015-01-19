/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.dao.impl;

import com.sky.skypublisher.dao.IPublishTileDao;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.impl.BrokenCode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sabusreeraj
 */
@Repository
public class PublishTileDao implements IPublishTileDao {

    @Override
    public List<Tile> getTodaysTilesByClientAndPosition(int clientId, int position) throws BrokenCode {
        return getTiles(3);
        //return new ArrayList<>();
    }

    @Override
    public boolean createOrUpdateTile(Tile tile) throws BrokenCode {
        return true;
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
