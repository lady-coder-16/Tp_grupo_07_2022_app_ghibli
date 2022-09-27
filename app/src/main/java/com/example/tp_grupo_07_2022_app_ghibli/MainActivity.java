package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etnota1, etnota2;
    Button btnCalcular;
    TextView tvResultado;
    Toolbar menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu_toolbar);
        getSupportActionBar().setTitle("Menú principal");

        saludarUsuario();
        //hacemos la conexión de la variable local con la variable del archivo activity_main
        etnota1 = findViewById(R.id.etnota1);
        etnota2 = findViewById(R.id.etnota2);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Se apreto el botón de calcular", Toast.LENGTH_SHORT).show();

                int nota1 = Integer.valueOf(etnota1.getText().toString());
                int nota2 = Integer.valueOf(etnota2.getText().toString());

                calcular(nota1, nota2);
            }
        });


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
        }
    }

    private void calcular(int nota1, int nota2) {
        int promedio = (nota1 + nota2) / 2;
        tvResultado.setText("Resultado: " + promedio);
    }
}