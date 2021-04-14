package com.example.test_loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test_loggin.data.Usuario;

public class Menu extends AppCompatActivity {
    int id=0;
    Usuario u;
    daoUsuarios dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        dao= new daoUsuarios(this);
        u=dao.getUsuarioById(id);
        
    }
}