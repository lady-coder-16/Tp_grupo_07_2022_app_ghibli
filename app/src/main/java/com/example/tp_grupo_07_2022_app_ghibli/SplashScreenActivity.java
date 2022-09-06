package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    private static final long tiempo_espera = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // le indicamos de donde hasta donde carga
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                //le indicamos la intencion que tenemos
                startActivity(intent);
                //se finaliza la actividad donde nos enconrtamos
                finish();
            }
        }, tiempo_espera);
    }
}