package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etPassword, etUsuarioRegistro, etPasswordRegistro;
    Button btnIniciarSesion, btnRegistrarse;
    CheckBox cbRecordarUsuario;
    Toolbar menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        menu_toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu_toolbar);
        getSupportActionBar().setTitle("Login");

        // EditText
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        etUsuarioRegistro = findViewById(R.id.etUsuarioRegistro);
        etPasswordRegistro = findViewById(R.id.etPasswordRegistro);

        // CheckBox
        cbRecordarUsuario = findViewById(R.id.cbRecordarUsuario);
// comentario para pushear
        // Button
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TODO", "Se apreto el boton iniciar sesion");
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                if(usuario.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
                } else{
                    Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main_activity);
                }
            }
        });

        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO", "Se apreto el boton registrarse");
                Intent register_activity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register_activity);
            }
        });


    }
}