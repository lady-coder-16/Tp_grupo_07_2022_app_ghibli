package com.example.tp_grupo_07_2022_app_ghibli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp_grupo_07_2022_app_ghibli.util.Utils;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etPassword, etUsuarioRegistro, etPasswordRegistro;
    Button btnIniciarSesion, btnRegistrarse;
    CheckBox cbRecordarUsuario;
    Toolbar menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //menu
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

        //continuacion con shared preferences
        SharedPreferences sp = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = sp.getString("remember", "");
        if(checkbox.equals("true")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else if (checkbox.equals("false")){
            Toast.makeText(this, "Tendrá que registrarse", Toast.LENGTH_SHORT).show();
        }
        //--------------------

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
                    if(cbRecordarUsuario.isChecked()){
                        createRememberUserNotificationChannel();
                    }
                    Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                    main_activity.putExtra("usuario", usuario);
                    startActivity(main_activity);
                    finish();
                }
            }
        });
        //shared preference
        cbRecordarUsuario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){

                    SharedPreferences sp=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("recordar", "true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"Te recordaremos", Toast.LENGTH_SHORT).show();


                }else if(!compoundButton.isChecked()){

                    SharedPreferences sp=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("recordar", "false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"No te recordaremos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TODO", "Se apreto el boton registrarse");
                Intent terminos_activity = new Intent(LoginActivity.this, TerminosYCondicionesActivity.class);
                startActivity(terminos_activity);
            }
        });

    }

    //Declaracion de crear la notificacion
    private void createRememberUserNotificationChannel(){
        createRememberUserNotification();
    }

    private void createRememberUserNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Utils.FIRST_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setContentTitle(Utils.FIRST_NOTIFICATION_TITLE)
                .setContentText(Utils.FIRST_NOTIFICATION_DESC)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLights(Color.CYAN, 1000, 1000)
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(Utils.FIRST_NOTIFICATION_ID,builder.build());
    }
}