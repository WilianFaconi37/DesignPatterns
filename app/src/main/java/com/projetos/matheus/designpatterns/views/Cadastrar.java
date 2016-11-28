package com.projetos.matheus.designpatterns.views;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.projetos.matheus.designpatterns.R;

import models.adapters.SoundMessageAdapter;
import models.adapters.ToastMessageAdapter;
import models.adapters.VibrationMessageAdapter;
import models.designpatterns.Alarm;
import models.designpatterns.Despertator;

public class Cadastrar extends AppCompatActivity {


    private Button btnCancelar;
    private Button btnSalvar;

    private TextView txtMensagem;

    private EditText edtMensagem;

    private RadioGroup rbTipo;
        private RadioButton rbMensagem;
        private RadioButton rbSom;
        private RadioButton rbVibrar;

    private TimePicker tpRelogio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btnCancelar = (Button)findViewById(R.id.btnCancelar);
        btnSalvar = (Button)findViewById(R.id.btnSalvar);

        txtMensagem = (TextView)findViewById(R.id.txtMensagem);
        edtMensagem = (EditText)findViewById(R.id.edtMensagem);

        rbTipo = (RadioGroup)findViewById(R.id.rbTipo);
            rbMensagem = (RadioButton)findViewById(R.id.rbMensagem);
                rbMensagem.setChecked(true);

            rbSom = (RadioButton)findViewById(R.id.rbSom);
            rbVibrar = (RadioButton)findViewById(R.id.rbVibrar);

        tpRelogio = (TimePicker)findViewById(R.id.tpRelogio);
    }

    public void checked(View view){
        if(rbMensagem.isChecked()){
            txtMensagem.setVisibility(View.VISIBLE);
            edtMensagem.setVisibility(View.VISIBLE);
        }else{
            txtMensagem.setVisibility(View.INVISIBLE);
            edtMensagem.setVisibility(View.INVISIBLE);
        }
    }

    public void cancelar(View view){

        Toast.makeText(this,"OPERAÇÃO CANCELADA!",Toast.LENGTH_SHORT).show();
        Intent it  = new Intent(getApplicationContext(), TelaAlarme.class);
        startActivityForResult(it, 1);
        //fechando a activity
        finish();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void salvar(View view){

        if(rbMensagem.isChecked()){
            Despertator.getInstance().addAlarm(new Alarm(tpRelogio.getHour(), tpRelogio.getMinute(), 00, new ToastMessageAdapter(edtMensagem.getText().toString())));
        }else{
            if(rbSom.isChecked()){
                Despertator.getInstance().addAlarm(new Alarm(tpRelogio.getHour(), tpRelogio.getMinute(), 00, new SoundMessageAdapter()));
            }else{
                Despertator.getInstance().addAlarm(new Alarm(tpRelogio.getHour(), tpRelogio.getMinute(), 00, new VibrationMessageAdapter()));
            }
        }

        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(it, 1);
        Toast.makeText(this,"ALARME SALVO!",Toast.LENGTH_SHORT).show();

        //fechando a activity
        finish();

    }

}
