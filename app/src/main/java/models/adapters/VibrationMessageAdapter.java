/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.adapters;

import models.messages.VibrationMessage;

public class VibrationMessageAdapter extends VibrationMessage implements Message {

    public VibrationMessageAdapter(){}

    @Override
    public void displayMessage() {
        this.startVibration();
    }

}