package com.example.test_loggin.data;


import androidx.room.Entity;

@Entity(tableName = "Usuarios")
public class Usuario {
    int Id;
    String Usuario, Password, Nombre, Correo;

    public Usuario() {
    }

    public Usuario(String usuario, String password, String nombre,String correo) {
        Usuario = usuario;
        Password = password;
        Nombre = nombre;
        Correo = correo;

    }

    public boolean isNull(){
        return !Nombre.equals("") || !Usuario.equals("") || !Correo.equals("") || !Password.equals("");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Correo='" + Correo + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }


    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
