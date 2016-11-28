/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.messages;

import android.content.Intent;
import com.projetos.matheus.designpatterns.views.TelaAlarme;

import models.designpatterns.Despertator;

public class SoundMessage{

    public void startSound() {
        //redireciona para a Activity TelaAlarme
        Intent intent = new Intent(Despertator.getInstance().getContext(), TelaAlarme.class);
        Despertator.getInstance().getContext().startActivity(intent);
    }
    
}
