/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.detector;

/**
 *
 * @author sabusreeraj
 */
public class SkyHackerDetection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            String ip = new HackerDetectorImpl().parseLine(args[0].trim());
            if (null != ip) {
                System.out.println("Hacker detected: " + ip);
            }
        }
    }

}
