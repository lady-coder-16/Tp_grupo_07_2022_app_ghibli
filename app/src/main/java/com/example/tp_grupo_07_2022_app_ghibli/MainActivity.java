package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar;
        CardView cardPeliculas, cardPersonajes, cardLugares, cardEspecies, cardVehiculos, cardInfo;

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar); //debe ir antes que los getSupport
        getSupportActionBar().setTitle("Menú principal");
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        saludarUsuario();
        //hacemos la conexión de la variable local con la variable del archivo activity_main


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){

            case R.id.buscar:
                Toast.makeText(this,"Buscar",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.filtro:
                Toast.makeText(this,"Filtro",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_settings:
                Toast.makeText(this,"Ajustes",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.about_us:
                Toast.makeText(this,"Sobre Nosotras",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.salir:
                Toast.makeText(this,"Cerrando Sesión...",Toast.LENGTH_SHORT).show();
                return true;


            default: return super.onOptionsItemSelected(item);
        }

    }

    private void saludarUsuario() {
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String usuario = bundle.getString("usuario");

            Toast.makeText(MainActivity.this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();


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