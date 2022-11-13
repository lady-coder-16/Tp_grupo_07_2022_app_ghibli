package com.example.tp_grupo_07_2022_app_ghibli;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import com.example.tp_grupo_07_2022_app_ghibli.util.Utils;

public class NotificationMessage extends Application {

    public void onCreate(){
        super.onCreate();

        createRememberUserNotificationChannel();
    }

    private void createRememberUserNotificationChannel(){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(Utils.FIRST_CHANNEL_ID, Utils.FIRST_CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(Utils.FIRST_CHANNEL_DESC);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
