/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.dao;

import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.impl.BrokenCode;
import java.util.List;

/**
 *
 * @author sabusreeraj
 */
public interface IPublishTileDao {

    List<Tile> getTodaysTilesByClientAndPosition(int clientId, int position) throws BrokenCode;
    
    boolean createOrUpdateTile(Tile tile) throws BrokenCode;
    
}
