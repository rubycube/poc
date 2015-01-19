/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.impl.BrokenCode;

/**
 *
 * @author sabusreeraj
 */
public interface ITileValidatorService {

    boolean validateTile(Tile tile) throws BrokenCode;
    
}
