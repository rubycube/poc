/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wh.whfindfile;

/**
 *
 * @author computer
 */
public class BrokenCode extends Exception {

    private String errorCode = null;

    BrokenCode(String errorCode) {
        this.errorCode = errorCode;
    }

    // Error Codes
    public enum ErrorCodes {

        MISSING_F("[Missing the value for -f!]"), MISSING_P("[Missing the value for -p!]"),
        MISSING_PARAMS("[Missing -f or <directory>!]"), INVALID_DIR("[Invaild directory!]"),
        EMPTY_DIR("[Empty directory!]"), EMPTY_RES("[No results found!]");

        private String code = null;

        /**
         * Constructor.
         */
        ErrorCodes(String code) {
            this.code = code;
        }

        /**
         * Returns the error code.
         *
         * @return
         */
        public String getCode() {
            return this.code;
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
