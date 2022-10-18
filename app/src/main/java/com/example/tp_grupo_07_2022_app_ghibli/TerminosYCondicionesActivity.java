package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TerminosYCondicionesActivity extends AppCompatActivity {

    Button btnAceptarTerminos;
    Toolbar menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_ycondiciones);

        //menu
        menu_toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu_toolbar);
        getSupportActionBar().setTitle("Terminos y Condiciones");

        // Button

        btnAceptarTerminos = findViewById(R.id.btnAceptarTerminos);
        btnAceptarTerminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO", "Se aceptaron terminos y condiciones");
                Intent register_activity = new Intent(TerminosYCondicionesActivity.this, RegisterActivity.class);
                startActivity(register_activity);
            }
        });

    }
}