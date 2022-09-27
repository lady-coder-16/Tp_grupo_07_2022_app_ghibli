package com.example.tp_grupo_07_2022_app_ghibli.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "usuario")
public class Usuario {

    @DatabaseField(id = true)
    private int id;

    @DatabaseField(columnName = "username")
    private String username;


    @DatabaseField(columnDefinition = "password")
    private String password;

    public Usuario(){}

    public Usuario(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
