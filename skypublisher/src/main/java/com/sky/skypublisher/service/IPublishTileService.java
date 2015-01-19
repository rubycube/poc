/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service;

import com.sky.skypublisher.service.impl.BrokenCode;
import com.sky.skypublisher.model.Tile;

/**
 *
 * @author sabusreeraj
 */
public interface IPublishTileService {

    boolean saveTile(Tile tile) throws BrokenCode;
    
}
