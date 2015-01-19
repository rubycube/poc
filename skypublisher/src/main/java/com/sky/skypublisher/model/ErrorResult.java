/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.model;

/**
 *
 * @author sabusreeraj
 */
public class ErrorResult extends Result{
    
    String error;
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public ErrorResult(String code, String error) {
        this.code = code;
        this.error = error;
    }
    
}
