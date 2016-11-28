/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.messages;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import models.designpatterns.Despertator;

public class ToastMessage {

    public void displayToastMessage(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Despertator.getInstance().getContext(),message,Toast.LENGTH_LONG).show();
            }
        });
    }
}
