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
import models.designpatterns.Alarm;
import models.designpatterns.Despertator;
import models.observers.TimerObserver;



public class MainActivity extends AppCompatActivity implements TimerObserver{

    Despertator despertador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




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

        ListView listView = (ListView) findViewById(R.id.lvAlarms);
        ArrayAdapter<Alarm> alarmAdapter = new ArrayAdapter<Alarm>(this,android.R.layout.simple_list_item_1,Despertator.getInstance() );
        listView.setAdapter(alarmAdapter);


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
