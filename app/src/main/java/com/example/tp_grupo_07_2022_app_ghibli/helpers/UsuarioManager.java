package com.example.tp_grupo_07_2022_app_ghibli.helpers;

import android.content.Context;

import com.example.tp_grupo_07_2022_app_ghibli.entity.Usuario;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class UsuarioManager {

    private static UsuarioManager instanciaUsuarioManager;
    Dao<Usuario, Integer> dao;

    public UsuarioManager(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, HelperDB.class);
        try {
            dao = helper.getDao(Usuario.class);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static UsuarioManager getInstanciaUsuarioManager(Context context) {
        if (instanciaUsuarioManager == null) {
            instanciaUsuarioManager = new UsuarioManager(context);
        }
        return instanciaUsuarioManager;
    }

    public static void setInstanciaUsuarioManager(UsuarioManager instanciaUsuarioManager) {
        UsuarioManager.instanciaUsuarioManager = instanciaUsuarioManager;
    }

    public List<Usuario> getUsuarios() throws Exception {
        return dao.queryForAll();
    }

    public void saveUsuario(Usuario usuario) throws Exception {
        dao.create(usuario);
    }

}
