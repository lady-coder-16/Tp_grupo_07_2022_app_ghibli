package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar menu_toolbar;

    CardView cardPeliculas, cardPersonajes, cardLugares, cardEspecies, cardVehiculos, cardInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu_toolbar);
        getSupportActionBar().setTitle("Menú principal");

        saludarUsuario();
        //hacemos la conexión de la variable local con la variable del archivo activity_main

    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.item_agregar){
            //realizar accion
            Intent intent = new Intent(MainActivity.this, AgregarActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void saludarUsuario() {
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String usuario = bundle.getString("usuario");

            Toast.makeText(MainActivity.this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();

            cardPeliculas = (CardView) findViewById(R.id.cvPeliculas);
            cardPersonajes = (CardView) findViewById(R.id.cvPersonajes);
            cardLugares = (CardView) findViewById(R.id.cvLugares);
            cardEspecies = (CardView) findViewById(R.id.cvEspecies);
            cardVehiculos = (CardView) findViewById(R.id.cvVehiculos);
            cardInfo = (CardView) findViewById(R.id.cvInfo);

            cardPeliculas.setOnClickListener(this);
            cardPersonajes.setOnClickListener(this);
            cardLugares.setOnClickListener(this);
            cardEspecies.setOnClickListener(this);
            cardVehiculos.setOnClickListener(this);
            cardInfo.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.cvPeliculas:
                i= new Intent(this,ListadoElementos.class);
                startActivity(i);
                break;

            case R.id.cvPersonajes:
                i= new Intent(this,ListadoElementos.class);
                startActivity(i);
                break;

            case R.id.cvLugares:
                i= new Intent(this,ListadoElementos.class);
                startActivity(i);
                break;

            case R.id.cvEspecies:
                i= new Intent(this,ListadoElementos.class);
                startActivity(i);
                break;

            case R.id.cvVehiculos:
                i= new Intent(this,ListadoElementos.class);
                startActivity(i);
                break;

            case R.id.cvInfo:
                i= new Intent(this,ListadoElementos.class);
                startActivity(i);
                break;
        }
    }
}