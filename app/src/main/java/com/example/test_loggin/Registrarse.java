package com.example.test_loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity implements View.OnClickListener{
EditText us, pas, nom, cor;
Button reg, can; //registrar y cancelar
    daoUsuarios dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        us=(EditText)findViewById(R.id.Reguser);
        nom=(EditText)findViewById(R.id.RegNombre);
        cor=(EditText)findViewById(R.id.RegCorreo);
        pas=(EditText)findViewById(R.id.RegPassword);
        reg=(Button)findViewById(R.id.btnReg);
        can=(Button)findViewById(R.id.btnRegCancel);
        can.setOnClickListener(this);
        reg.setOnClickListener(this);
        dao= new daoUsuarios(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReg:
                Usuario u= new Usuario();
                u.setUsuario(us.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setCorreo(cor.getText().toString());
                u.setPassword(pas.getText().toString());

                if (!u.isNull()){
                    Toast.makeText(this, "Error Campos incompletos",Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u))
                {
                    Toast.makeText(this, "Registro exitoso",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Usuario ya registrado",Toast.LENGTH_LONG).show();
                }

            break;
            case R.id.btnRegCancel:
                Intent i=new Intent(Registrarse.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}