/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wh.whfindfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author computer
 */
public interface IFindFile {

    File[] getEveryFilesAndDirectories(String searchDirectory);

    List<String> searchDirectory(String searchDirectory, String fileName, String pattern, List<String> files) throws IOException;

}
