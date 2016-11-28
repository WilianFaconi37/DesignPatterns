/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.messages;

import android.app.Activity;
import android.os.Vibrator;

import models.designpatterns.Despertator;

public class VibrationMessage{

    public void startVibration() {
        Vibrator rr = (Vibrator) Despertator.getInstance().getContext().getSystemService(Activity.VIBRATOR_SERVICE);
        long milliseconds = 5000;//'5000' é o tempo em milissegundos
        rr.vibrate(milliseconds);
    }
    
}
