/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.controller;

import com.sky.skypublisher.model.ErrorResult;
import com.sky.skypublisher.model.Result;
import com.sky.skypublisher.model.Tile;
import com.sky.skypublisher.service.IPublishTileService;
import com.sky.skypublisher.service.ITileValidatorService;
import com.sky.skypublisher.service.impl.BrokenCode;
import com.sky.skypublisher.utils.ProjectConstants;
import java.util.Calendar;
import org.jmock.Expectations;
import static org.jmock.Expectations.any;
import static org.jmock.Expectations.returnValue;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author sabusreeraj
 */
public class PublisherControllerTest {

    private Mockery mockery = new Mockery();
    private ITileValidatorService tileValidatorServiceMock = null;
    private IPublishTileService publishTileServiceMock = null;
    private PublisherController publisherController = null;

    public PublisherControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        publisherController = new PublisherController();
        tileValidatorServiceMock = mockery.mock(ITileValidatorService.class);
        publishTileServiceMock = mockery.mock(IPublishTileService.class);
        publisherController.setTileValidatorService(tileValidatorServiceMock);
        publisherController.setPublishTileService(publishTileServiceMock);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveTile method, of class PublisherController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveTile() throws Exception {
        mockery.checking(new Expectations() {
            {
                exactly(1).of(tileValidatorServiceMock).validateTile(with(any(Tile.class)));
                will(returnValue(true));
                exactly(1).of(publishTileServiceMock).saveTile(with(any(Tile.class)));
                will(returnValue(true));
            }
        });
        ResponseEntity<Result> result = publisherController.saveTile(1, "label", 5, Calendar.getInstance().getTime());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(ProjectConstants.SUCCESS, result.getBody().getCode());
    }

    /**
     * Test of handleBrokenCode method, of class PublisherController.
     */
    @Test
    public void testHandleBrokenCode() {
        BrokenCode ex = new BrokenCode();
        PublisherController instance = new PublisherController();
        ResponseEntity<ErrorResult> result = instance.handleBrokenCode(ex);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
    
        /**
     * Test of handleBrokenCode method, of class PublisherController.
     * @throws java.lang.Exception
     */
    @Test
    public void testHeartBeat() throws Exception {
        PublisherController instance = new PublisherController();
        ResponseEntity<Result> result = instance.heartBeat();
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}
