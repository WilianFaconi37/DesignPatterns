/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.observers;

import java.io.Serializable;
import java.util.Date;

public interface TimerObserver extends Serializable {
    
    public void update(Date date);

}
