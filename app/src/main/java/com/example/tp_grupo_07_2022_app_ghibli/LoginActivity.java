package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etPassword;
    Button btnIniciarSesion, btnRegistrarse;
    CheckBox cbRecordarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // EditText
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);

        // CheckBox
        cbRecordarUsuario = findViewById(R.id.cbRecordarUsuario);

        // Button
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TODO", "Se apreto el boton iniciar sesion");
            }
        });

        btnRegistrarse = findViewById(R.id.btnRegistrarse);


    }
}