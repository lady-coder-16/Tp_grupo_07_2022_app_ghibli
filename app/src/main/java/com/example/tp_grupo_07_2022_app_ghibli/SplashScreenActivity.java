package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashScreenActivity extends AppCompatActivity {

    private static final long tiempo_espera = 2000;

    //A: Instancio variable
    private ImageView imagen;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //A: utilizo la variable imagen
        imagen = findViewById(R.id.imagen);
        //A: de esta forma indico que que se muestre un gif como splashScreen
        String url= "https://i.pinimg.com/originals/44/a2/ae/44a2ae76121b664fe679d4ca6d48b867.gif";
        Uri urlparse = Uri.parse(url);
        Glide.with(getApplicationContext()).load(urlparse).into(imagen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // le indicamos de donde hasta donde carga
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                //le indicamos la intencion que tenemos
                startActivity(intent);
                //se finaliza la actividad donde nos encontramos
                finish();
            }
        }, tiempo_espera);


    }
}