package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etnota1, etnota2;
    Button btnCalcular;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludarUsuario();
        //hacemos la conección de la variable local con la variable del archivo activity_main
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