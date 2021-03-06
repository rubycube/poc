/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.controller;

import com.sky.skypublisher.model.ErrorResult;
import com.sky.skypublisher.model.Result;
import com.sky.skypublisher.service.IPublishTileService;
import com.sky.skypublisher.service.ITileValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.impl.BrokenCode;
import com.sky.skypublisher.utils.ProjectConstants;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sabusreeraj
 */
@Controller
@RequestMapping("/tile")
public class PublisherController {

    @Autowired
    private ITileValidatorService tileValidatorService = null;

    @Autowired
    private IPublishTileService publishTileService = null;

    //http://localhost:8080/skypublisher/admin/tile/<clientid>?label=<label>&position=<position>&start=<yyyy-MM-dd HH:mm:ss>
    @RequestMapping(value = "/{client_id}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Result> saveTile(@PathVariable("client_id") int clientId,
            @RequestParam("label") String label, @RequestParam("position") int position,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fromDate) throws Exception {
        Tile tile = new Tile(label, 3, clientId, fromDate);
        //Validate the input
        tileValidatorService.validateTile(tile);
        //Save the tile
        publishTileService.saveTile(tile);
        return new ResponseEntity<>(new Result(ProjectConstants.SUCCESS), HttpStatus.OK);
    }

    // Exception handling of errors thrown from service layer
    @ExceptionHandler(BrokenCode.class)
    public ResponseEntity<ErrorResult> handleBrokenCode(BrokenCode ex) {
        ErrorResult result = new ErrorResult(ProjectConstants.ERROR, ex.getError());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    //Heartbeat check default GET method
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Result> heartBeat() throws Exception {
        Result result = new Result("Try PUT http://localhost:8080/skypublisher/admin/tile/<clientid>?label=<label>&position=<position>&start=<yyyy-MM-dd HH:mm:ss>");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public void setTileValidatorService(ITileValidatorService tileValidatorService) {
        this.tileValidatorService = tileValidatorService;
    }

    public void setPublishTileService(IPublishTileService publishTileService) {
        this.publishTileService = publishTileService;
    }

}
