package com.sourcey.materiallogindemo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DatosActivity extends AppCompatActivity {
    private static final String TAG = "DatosActivity";

    @Bind(R.id.etEdad)
    EditText etEdad;
    @Bind(R.id.etPeso)
    EditText etPeso;
    @Bind(R.id.etAltura)
    EditText etAltura;
    @Bind(R.id.btNext)
    Button btNext;
    @Bind(R.id.rbMan)
    RadioButton rbMan;
    @Bind(R.id.rbWoman)
    RadioButton rbWoman;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        ButterKnife.bind(this);

        btNext.setEnabled(false);
        etPeso.setEnabled(false);
        etAltura.setEnabled(false);
        rbMan.setEnabled(false);
        rbWoman.setEnabled(false);

        etEdad.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                etPeso.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        etPeso.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                etAltura.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        etAltura.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                rbWoman.setEnabled(true);
                rbMan.setEnabled(true);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

       /* etEdad.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                etPeso.setEnabled(true);
                return false;
            }
        });*/

       /* etPeso.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                etAltura.setEnabled(true);
                return false;
            }
        });

        etAltura.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                rbWoman.setEnabled(true);
                rbMan.setEnabled(true);
                return false;
            }
        });*/

        rbMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbWoman.setChecked(false);
                btNext.setEnabled(true);
            }
        });


        rbWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbMan.setChecked(false);
                btNext.setEnabled(true);

            }
        });


        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppActivity.class);
                startActivity(intent);
            }
        });
    }
}