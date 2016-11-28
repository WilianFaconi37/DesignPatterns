/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.designpatterns;

import models.adapters.Message;

public class Alarm {
    private int hour;
    private int minutes;
    private int seconds;
    
    private Message message;

    public Alarm(int hour, int minutes, int seconds, Message message) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
        this.message = message;
    }
    
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    
}
