/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.service.impl;

import com.sky.skypublisher.utils.ProjectConstants;

/**
 *
 * @author sabusreeraj
 */
public class BrokenCode extends Exception {

    private String error = ProjectConstants.ErrorCodes.UNKOWN_ERROR.getCode();
    private Exception exception = null;

    public BrokenCode(){
    }
    
    public BrokenCode(String error) {
        this.error = error;
    }

    public BrokenCode(String error, Exception exception) {
        this.error = error;
        this.exception = exception;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
