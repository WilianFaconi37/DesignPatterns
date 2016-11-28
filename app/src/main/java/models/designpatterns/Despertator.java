/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.designpatterns;

import android.content.Context;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.observers.TimerObserver;

public final class Despertator implements TimerObserver, Serializable {

    private static final Despertator INSTANCE = new Despertator();

    private List<Alarm> alarms;
    private static Timer timer;

    private static Context context;

    public static Despertator getInstance(){
        return INSTANCE;
    }

    private Despertator(){
        alarms = new ArrayList<Alarm>();
        timer = new Timer();
        
        //Adiciona esta instância na lista de 'observadores' de Timer
        timer.attach(this);
        
        new Thread(timer).start();
    }
    
    @Override
    public void update(Date response) {
        Date date = response;
        
        for(Alarm alarm : alarms){
            if(alarm.getSeconds() == date.getSeconds()
                    && alarm.getHour() == date.getHours()
                    && alarm.getMinutes() == date.getMinutes()){

                alarm.getMessage().displayMessage();
            }
        }
    }

    public List<Alarm> getAlarms(){
        return this.alarms;
    }

    public Timer getTimer(){
        return this.timer;
    }

    public void addAlarm(Alarm alarm){
        this.alarms.add(alarm);
    }

    public void removeAlarm(Alarm alarm){
        this.alarms.remove(alarm);
    }

    public void setContext(Context context){
        this.context = context;
    }
    public Context getContext(){
        return this.context;
    }
}
