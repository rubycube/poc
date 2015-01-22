/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wh.whfindfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author computer
 */
public class WHFindFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<String> files = doExecute(args);
            for (String file : files) {
                System.out.println(file);
            }
        } catch (BrokenCode bcEx) {
            //Mask the exception do nothing!
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     * @return
     * @throws java.io.IOException
     * @throws com.wh.whfindfile.BrokenCode
     */
    public static List<String> doExecute(String[] args) throws BrokenCode, IOException {
        try {
            String rootDirectory = null;
            String fileName = null;
            String pattern = null;
            String arg = null;
            for (int i = 0; i < args.length; i++) {
                arg = args[i];
                switch (arg) {
                    case "-f":
                        if (args.length > i + 1 && isValidFileName(args[i + 1])) {
                            fileName = args[i + 1];
                            i++;
                        } else {
                            throw new BrokenCode(BrokenCode.ErrorCodes.MISSING_F.getCode());
                        }
                        break;
                    case "-p":
                        if (args.length > i + 1 && isValidPattern(args[i + 1])) {
                            pattern = args[i + 1];
                            i++;
                        } else {
                            throw new BrokenCode(BrokenCode.ErrorCodes.MISSING_P.getCode());
                        }
                        break;
                    default:
                        rootDirectory = arg;
                        break;
                }
            }
            List<String> files = new ArrayList<>();
            files = doFind(fileName, rootDirectory, pattern, files);
            if (files.isEmpty()) {
                throw new BrokenCode(BrokenCode.ErrorCodes.EMPTY_RES.getCode());
            } else {
                return files;
            }
        } catch (BrokenCode bcEx) {
            System.out.println(bcEx.getErrorCode());
            throw bcEx;
        }
    }

    private static List<String> doFind(String fileName, String rootDirectory, String pattern, List<String> files) throws IOException, BrokenCode {
        if (null == fileName || null == rootDirectory) {
            System.out.println("Usage1: search.bat -f \"pom.xml\" directory");
            System.out.println("Usage2: search.bat -f \"pom.xml\" -p \"mypackage.name\" directory");
            throw new BrokenCode(BrokenCode.ErrorCodes.MISSING_PARAMS.getCode());
        } else {
            FindFile findFile = new FindFile();
            File[] filesInDir = findFile.getEveryFilesAndDirectories(rootDirectory);
            if (null == filesInDir) {
                throw new BrokenCode(BrokenCode.ErrorCodes.INVALID_DIR.getCode());
            } else if (filesInDir.length == 0) {
                throw new BrokenCode(BrokenCode.ErrorCodes.EMPTY_DIR.getCode());
            } else {
                return findFile.searchDirectory(rootDirectory, fileName, pattern, files);
            }
        }
    }

    private static boolean isValidFileName(String fileName) {
        return !fileName.startsWith("-");
    }

    private static boolean isValidPattern(String pattern) {
        return !pattern.startsWith("-");
    }

}
