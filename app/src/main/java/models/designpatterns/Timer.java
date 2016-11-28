/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.designpatterns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.observers.TimerObserver;

public class Timer implements Runnable,Serializable {

    private Date date;

    protected ArrayList<TimerObserver> observers;
    protected Timer timer;

    public Timer() {
        observers = new ArrayList<TimerObserver>();
        date = new Date();
    }

    public void attach(TimerObserver observer) {
        observers.add(observer);
    }

    public void detach(int indice) {
        observers.remove(indice);
    }

    public void setState(Timer timer) {
        notifyObservers();
    }

    private void notifyObservers() {
        for (TimerObserver observer : observers) {
            observer.update(getDate());
        }
    }

    public Timer getState() {
        return timer;
    }

    public void run() {
        while (true) {

            date = new Date();
            notifyObservers();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Date getDate(){
        return this.date;
    }
}
