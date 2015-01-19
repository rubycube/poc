/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.controller;

import com.sky.skypublisher.utils.ProjectConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author sabusreeraj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testSpringXMLConfig.xml"})
@WebAppConfiguration
public class PublishControllerMvcTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    public PublishControllerMvcTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void saveTileSuccess() throws Exception {
        String startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        mockMvc.perform(put("/tile/1?label=label&position=4&start=" + startDateTime + "")
                .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.code", is(ProjectConstants.SUCCESS)));
    }

    @Test
    public void saveTileEarlyTilePosition() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -10);
        String startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
        mockMvc.perform(put("/tile/1?label=label&position=4&start=" + startDateTime + "")
                .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.code", is(ProjectConstants.ERROR)));
    }

    @Test
    public void checkHeartBeat() throws Exception {
        mockMvc.perform(get("/tile")
                .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    //Return an empty array from PublishTileDao.getTilesByClientAndPosition() to test this.
    @Ignore
    public void saveTileError() throws Exception {
        mockMvc.perform(put("/tile/1?label='label'&position='4'&start='2018'")
                .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.code", is(ProjectConstants.ERROR)));
    }

}
