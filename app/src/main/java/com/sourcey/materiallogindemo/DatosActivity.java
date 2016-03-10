package com.sourcey.materiallogindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by r.martinez on 10/03/2016.
 */
public class DatosActivity extends AppCompatActivity {
    private static final String TAG = "DatosActivity";

    @Bind(R.id.etEdad) EditText etEdad;
    @Bind(R.id.etPeso) EditText etPeso;
    @Bind(R.id.etAltura) EditText etAltura;
    @Bind(R.id.btNext) Button btNext;
    @Bind(R.id.rbMan)  RadioButton rbMan;
    @Bind(R.id.rbWoman)  RadioButton rbWoman;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        ButterKnife.bind(this);
        etEdad.setEnabled(true);
        btNext.setEnabled(false);
        etPeso.setEnabled(false);
        etAltura.setEnabled(false);
        rbWoman.setEnabled(false);
        rbMan.setEnabled(false);

        rbMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbWoman.setChecked(false);
            }
        });
        rbWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbMan.setChecked(false);
            }
        });

        if(etEdad.getText()!=null){
            etAltura.setEnabled(true);
            if(etAltura.getText()!=null){
                etPeso.setEnabled(true);
                if(etPeso.getText()!=null){
                    rbWoman.setEnabled(true);
                    rbMan.setEnabled(true);
                    if(rbMan.isChecked()|| rbWoman.isChecked()){
                        btNext.setEnabled(true);
                    }
                }
            }
        }
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}