package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp_grupo_07_2022_app_ghibli.entity.Usuario;
import com.example.tp_grupo_07_2022_app_ghibli.helpers.UsuarioManager;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsuarioRegistro, etPasswordRegistro;
    Button btnRegistrarNuevoUsuario, btnVolver;
    Toolbar menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        menu_toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu_toolbar);
        getSupportActionBar().setTitle("Registro de usuario");

        etUsuarioRegistro = findViewById(R.id.etUsuarioRegistro);
        etPasswordRegistro = findViewById(R.id.etPasswordRegistro);

        btnRegistrarNuevoUsuario = findViewById(R.id.btnRegistrarNuevoUsuario);
        btnRegistrarNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO", "Se apretó el botón registrarse");
                String usuarioRegistro = etUsuarioRegistro.getText().toString();
                String passwordRegistro = etPasswordRegistro.getText().toString();

                Usuario usuario = new Usuario();

                usuario.setId((int)(Math.random()*900000+1));
                usuario.setUsername(etUsuarioRegistro.getText().toString());
                usuario.setPassword(etPasswordRegistro.getText().toString());
                try{
                    UsuarioManager.getInstanciaUsuarioManager(RegisterActivity.this).saveUsuario(usuario);
                    Toast.makeText(RegisterActivity.this,"SE GUARDO EN LA BD", Toast.LENGTH_LONG).show();
                }catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RegisterActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO", "Se apretó el botón volver");
                Intent login_activity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(login_activity);
            }
        });

    }
}

/*if(usuarioRegistro.isEmpty() || passwordRegistro.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
                } else{
                    Intent login_activity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(login_activity);
                }*/