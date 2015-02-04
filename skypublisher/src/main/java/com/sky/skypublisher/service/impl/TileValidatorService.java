/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service.impl;

import com.sky.skypublisher.service.ITileValidatorService;
import org.springframework.stereotype.Service;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.utils.ProjectConstants;

/**
 *
 * @author sabusreeraj
 */
@Service
public class TileValidatorService implements ITileValidatorService {

    @Override
    public boolean validateTile(Tile tile) throws BrokenCode {
        if (!validateLabel(tile.getLabel())) {
            throw new BrokenCode(ProjectConstants.ErrorCodes.INVALID_LABEL.getCode());
        } else if (!validatePosition(tile.getPosition())) {
            throw new BrokenCode(ProjectConstants.ErrorCodes.INVALID_POSITION.getCode());
        }
        return true;
    }

    //Null and allowed characters and number check for label
    private boolean validateLabel(String label) {
        return null != label && label.trim().matches("^[a-zA-Z0-9 ]{1,30}$");
    }

    //Position should be great than 0 and less than 9 check
    private boolean validatePosition(int position) {
        return position > 0 && position < 9;
    }
}
