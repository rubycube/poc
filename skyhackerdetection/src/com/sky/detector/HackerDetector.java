/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.detector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sabusreeraj
 */
public interface HackerDetector {

    public static Map<String, ArrayList> ipMap = new HashMap<>();

    //returns ip address on hack detect else return null
    public String parseLine(String line);
}
