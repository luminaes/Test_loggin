package com.example.test_loggin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_loggin.data.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText user, pass;
    Button btnIngresar, btnRegistrar;
    daoUsuarios dao;
    //Button btoReg; //declaro el boton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.editTextTextPersonName);
        pass=(EditText)findViewById(R.id.editTextTextPassword);
        btnIngresar=(Button)findViewById(R.id.Ingresar);
        btnRegistrar=(Button)findViewById(R.id.ButtonReg);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuarios(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Ingresar:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if (u.equals("")&& p.equals("")){
                    Toast.makeText(this,"Campos Vacios",Toast.LENGTH_LONG).show();
                }else if (dao.login(u, p) == 1){ //revisar validacion
                    Usuario ux= dao.getUsuario(u,p);
                    Toast.makeText(this,"LOGIN Exitoso",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(MainActivity.this,Menu.class);
                   i2.putExtra("id", ux.getId()); //paso ID del usuario logueado
                    startActivity(i2);
                }

                break;
            case R.id.ButtonReg:
                Intent i=new Intent(MainActivity.this,Registrarse.class);
                startActivity(i);
                break;
        }
    }
}