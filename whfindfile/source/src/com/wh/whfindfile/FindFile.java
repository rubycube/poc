/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wh.whfindfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author computer
 */
public class FindFile implements IFindFile {

    @Override
    public List<String> searchDirectory(String searchDirectory, String fileName, String pattern, List<String> files) throws IOException {
        for (File fileObj : getEveryFilesAndDirectories(searchDirectory)) {
            if (fileObj.isDirectory()) {
                searchDirectory = fileObj.getAbsolutePath();
                searchDirectory(searchDirectory, fileName, pattern, files);
            } else if (fileObj.getName().matches(fileName)) {
                if (null == pattern) {
                    files.add(fileObj.getAbsolutePath());
                } else if (checkContent(fileObj.getAbsolutePath(), pattern)) {
                    files.add(fileObj.getAbsolutePath());
                }
            }
        }
        return files;
    }

    @Override
    public File[] getEveryFilesAndDirectories(String searchDirectory) {
        File file = new File(searchDirectory);
        return file.listFiles();
    }

    private static boolean checkContent(String fileName, String pattern) throws FileNotFoundException, IOException {
        FileInputStream fstream = new FileInputStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains(pattern)) {
                    return true;
                }
            }
        }
        return false;
    }

}
