/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.utils;

/**
 *
 * @author sabusreeraj
 */
public class ProjectConstants {

    public static final String SUCCESS = "SUCESS";
    public static final String ERROR = "ERROR";
    public static final String DEFAULT_TIMEZONE = "UTC";

    // Error Codes
    public enum ErrorCodes {

        INVALID_LABEL("[INVALID_LABEL]"), INVALID_POSITION("[INVALID_POSITION]"),
        EMPTY_SCHEDULE("[EMPTY_SCHEDULE]"), POSITION_UNAVAILABLE("[POSITION_UNAVAILABLE]"),
        EARLY_POSITION("[EARLY_POSITION]"), UNKOWN_ERROR("[UNKOWN_ERROR]");

        private String code = null;

        /**
         * Constructor.
         */
        ErrorCodes(String code) {
            this.code = code;
        }

        /**
         * Returns the error code.
         * @return 
         */
        public String getCode() {
            return this.code;
        }
    }

}
