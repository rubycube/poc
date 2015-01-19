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
   
    @RequestMapping(value = "/{client_id}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Result> saveTile(@PathVariable("client_id") int clientId,
            @RequestParam("label") String label, @RequestParam("position") int position,
            @RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fromDate) throws Exception {
        Tile tile = new Tile(label, 3, clientId, fromDate);
        tileValidatorService.validateTile(tile);
        publishTileService.saveTile(tile);
        Result result = new Result(ProjectConstants.SUCCESS);
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<Result> response = new ResponseEntity<>(result, status);
        return response;
    }

    @ExceptionHandler(BrokenCode.class)
    public ResponseEntity<ErrorResult> handleBrokenCode(BrokenCode ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResult result = new ErrorResult(ProjectConstants.ERROR, ex.getError());
        ResponseEntity<ErrorResult> response = new ResponseEntity<>(result, status);
        return response;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Result> heartBeat() throws Exception {
        Result result = new Result("Try PUT http://localhost:8080/skypublisher/admin/tile/<clientid>?label=<label>&position=<position>&start=<yyyy-MM-dd HH:mm:ss>");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<Result> response = new ResponseEntity<>(result, status);
        return response;
    }

    public void setTileValidatorService(ITileValidatorService tileValidatorService) {
        this.tileValidatorService = tileValidatorService;
    }

    public void setPublishTileService(IPublishTileService publishTileService) {
        this.publishTileService = publishTileService;
    }

}
