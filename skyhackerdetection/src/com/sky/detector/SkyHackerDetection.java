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
        HackerDetectorImpl hackerDetector = new HackerDetectorImpl();
        String[] logLineArray = {
            "80.238.9.179,123612947,SIGNIN_FAILURE,Dave.Branning",
            "80.238.9.179,133612947,SIGNIN_FAILURE,Dave.Branning",
            "80.238.9.179,133612947,SIGNIN_FAILURE,Dave.Branning",
            "80.238.9.179,133612947,SIGNIN_SUCCESS,Dave.Branning",
            "80.238.9.179,133612947,SIGNIN_FAILURE,Dave.Branning",
            "80.238.9.179,133612947,SIGNIN_FAILURE,Dave.Branning",
            "80.238.9.179,133612947,SIGNIN_FAILURE,Dave.Branning"};
        String ip;
        for (String logLine : logLineArray) {
            if (null != logLine) {
                ip = hackerDetector.parseLine(logLine);
                if (null != ip) {
                    System.out.println("Hacker detected: " + ip);
                }
            }
        }
    }

}
