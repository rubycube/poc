/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.skypublisher.model;

import java.util.Date;

/**
 *
 * @author sabusreeraj
 */
public class Tile {

    private String label;
    private int position;
    private int clientId;
    private Date startDateTime;
    private Date endDateTime;

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Tile() {
    }

    public Tile(String label, int position, int clientId, Date startDateTime) {
        this.label = label;
        this.position = position;
        this.clientId = clientId;
        this.startDateTime = startDateTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
