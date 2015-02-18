/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.detector;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sabusreeraj
 */
public class HackerDetectorImpl implements HackerDetector {

    @Override
    public String parseLine(String line) {
        if (null != line) {
            String[] splitLine = line.split(",");
            String ip = splitLine[0];
            long logTime, startTime, lTime;
            String signinStatus;
            Iterator<Long> iter;
            ArrayList<Long> logTimeArrayList;
            if (null != ip) {
                logTime = Long.valueOf(splitLine[1]);
                signinStatus = splitLine[2];
                if (signinStatus.compareToIgnoreCase("SIGNIN_FAILURE") == 0) {
                    logTimeArrayList = ipMap.get(ip);
                    if (null != logTimeArrayList) {
                        startTime = logTime - 300000;
                        for (iter = logTimeArrayList.iterator(); iter.hasNext();) {
                            lTime = iter.next();
                            if (lTime < startTime) {
                                iter.remove();
                            }
                        }
                        logTimeArrayList.add(logTime);
                        if (logTimeArrayList.size() >= 5) {
                            ipMap.put(ip, logTimeArrayList);
                            return ip;
                        }
                    } else {
                        logTimeArrayList = new ArrayList<>();
                        logTimeArrayList.add(logTime);
                    }
                    ipMap.put(ip, logTimeArrayList);
                }
            }
        }
        return null;
    }
}
