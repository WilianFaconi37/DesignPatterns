package com.projetos.matheus.designpatterns.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.projetos.matheus.designpatterns.R;
import java.util.Date;
import java.util.List;

import models.designpatterns.Alarm;
import models.designpatterns.Despertator;
import models.observers.TimerObserver;



public class MainActivity extends AppCompatActivity implements TimerObserver{

    Despertator despertador;
    Alarm alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //List<Alarm> alarms = ();



        /* start application */
        despertador = Despertator.getInstance();
        despertador.setContext(MainActivity.this);
        despertador.getTimer().attach(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addAlarm);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it  = new Intent(getApplicationContext(), Cadastrar.class);
                startActivityForResult(it, 1);
            }
        });

        lista();
        //métodos
        //   ArrayAdapter<Alarm> alarmAdapter = new ArrayAdapter<Alarm>(this,android.R.layout.simple_list_item_1,Despertator.getInstance() );
        //listView.setAdapter(alarmAdapter);
    }


    public void lista(){
        int i;

        for(i=0; i<2; i++){

            ListView listaHorario = (ListView) findViewById(R.id.lista);

            ArrayAdapter<Alarm> adapter = new ArrayAdapter<Alarm>(this,
                android.R.layout.simple_list_item_1,Despertator.getInstance().getAlarms());
           listaHorario.setAdapter(adapter);

        }


    }





    @Override
    public void update(final Date date) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView timeDisplay = (TextView) findViewById(R.id.timeDisplay);
                timeDisplay.setText(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
            }
        });
    }



}
