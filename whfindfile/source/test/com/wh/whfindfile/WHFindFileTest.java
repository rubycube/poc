/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wh.whfindfile;

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
public class WHFindFileTest {

    public WHFindFileTest() {
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
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteMissingParams() throws Exception {
        String[] args = {"-p", "pattern"};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.MISSING_PARAMS.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteMissingF() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources/searchtest/empty";
        String[] args = {"-f", "-p", "pattern", path};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.MISSING_F.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteMissingP() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources/searchtest/empty";
        String[] args = {"-p", "-f", "data.txt", path};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.MISSING_P.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteInvalidDirectory() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources/sear";
        String[] args = {"-p", "mypackage", "-f", "data.txt", path};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.INVALID_DIR.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteEmptyDirectory() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources/searchtest/empty";
        String[] args = {"-p", "mypackage", "-f", "data.txt", path};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.EMPTY_DIR.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteEmptyResult() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources";
        String[] args = {"-p", "mypackage", "-f", "data1.txt", path};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.EMPTY_RES.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoExecute() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources";
        String[] args = {"-f", "data.txt", path};
        List<String> files = WHFindFile.doExecute(args);
        assertEquals(files.size(), 4);
    }

    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoExecuteWithPattern() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources";
        String[] args = {"-p", "mypackage", "-f", "data.txt", path};
        List<String> files = WHFindFile.doExecute(args);
        assertEquals(files.size(), 3);
    }
    
    /**
     * Test of main method, of class WHFindFile.
     *
     * @throws java.lang.Exception
     */
    @Test(expected = BrokenCode.class)
    public void testDoExecuteEmptyResultWithPattern() throws Exception {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path + "../../test/resources";
        String[] args = {"-p", "mypackage1", "-f", "data.txt", path};
        try {
            WHFindFile.doExecute(args);
        } catch (BrokenCode bcEx) {
            assertEquals(BrokenCode.ErrorCodes.EMPTY_RES.getCode(), bcEx.getErrorCode());
            throw bcEx;
        }
    }    

}
