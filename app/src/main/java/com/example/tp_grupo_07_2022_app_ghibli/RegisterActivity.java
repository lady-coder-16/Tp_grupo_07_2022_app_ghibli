package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsuarioRegistro, etPasswordRegistro;
    Button btnRegistrarNuevoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsuarioRegistro = findViewById(R.id.etUsuarioRegistro);
        etPasswordRegistro = findViewById(R.id.etPasswordRegistro);

        btnRegistrarNuevoUsuario = findViewById(R.id.btnRegistrarNuevoUsuario);
        btnRegistrarNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO", "Se apreto el boton registrarse");
                String usuarioRegistro = etUsuarioRegistro.getText().toString();
                String passwordRegistro = etPasswordRegistro.getText().toString();

                if(usuarioRegistro.isEmpty() || passwordRegistro.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
                } else{
                    Intent login_activity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(login_activity);
                }
            }
        });

    }
}