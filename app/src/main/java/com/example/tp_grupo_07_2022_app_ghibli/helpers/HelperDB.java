package com.example.tp_grupo_07_2022_app_ghibli.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_grupo_07_2022_app_ghibli.entity.Usuario;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class HelperDB extends OrmLiteSqliteOpenHelper {

    public HelperDB(Context context) {
        super(context, Constants.NOMBRE_BASE_DATOS,null, Constants.VERSION_BASE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Usuario.class);
        }catch (java.sql.SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }
}
