/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.adapters;

import models.messages.SoundMessage;

public class SoundMessageAdapter extends SoundMessage implements Message {
    
    private String audioPath = "";
    
    @Override
    public void displayMessage() {
        this.startSound();
    }
    
    public void setAudioPath(String audioPath){
        this.audioPath = audioPath;
    }
    
    public String getAudioPath(){
        return audioPath;
    }
}