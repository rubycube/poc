/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wh.whfindfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author computer
 */
public class FindFileTest {

    public FindFileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of searchDirectory method, of class FindFile.
     */
    @Test
    public void testSearchDirectory() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources";
        String searchDirectory = path;
        String fileName = "data.txt";
        String pattern = "mypackage";
        FindFile instance = new FindFile();
        List<String> files = new ArrayList<>();
        files = instance.searchDirectory(searchDirectory, fileName, pattern, files);
        assertEquals(files.size(), 3);
    }

    /**
     * Test of getEveryFilesAndDirectories method, of class FindFile.
     */
    @Test
    public void testGetEveryFilesAndDirectories() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        File file = new File(path + "../../test/resources");
        File[] expFiles = file.listFiles();
        String searchDirectory = path + "../../test/resources";
        FindFile instance = new FindFile();
        File[] result = instance.getEveryFilesAndDirectories(searchDirectory);
        assertEquals(expFiles.length, result.length);
    }

}
