/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.adapters;

import models.messages.ToastMessage;

public class ToastMessageAdapter extends ToastMessage implements Message {
    
    private String message = "";
    
    public ToastMessageAdapter(){}
    public ToastMessageAdapter(String message){
        this.message = message;
    }
    
    @Override
    public void displayMessage() {
        this.displayToastMessage(this.message);
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
}