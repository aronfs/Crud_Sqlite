package com.example.crud_sqlite;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class Cliente {

    private String Cedula;
    private String Nombre;
    private String Apellidos;
    private String Direccion;
    private String Telefono;
    private String Correo_electronico;
    private int Edad;
    ArrayList<Cliente>list;


    public void Crear_Cliente(Context context){
        DbHelper dbHelper = new DbHelper(context, "baseCliente", null, 1);
        String nsql = "INSERT INTO "+Base.TABLA_CLIENTE+" ("+Base.CEDULA+","+Base.NOMBRE+","+Base.APELLIDO+","+Base.DIRECCION+","+Base.TELEFONO+","+Base.CORREO_ELECTRONICO+","+Base.EDAD+") " +
                " VALUES ('"+getCedula()+"','"+getNombre()+"','"+getApellidos()+"','"+getDireccion()+"','"+getTelefono()+"','"+getCorreo_electronico()+"',"+getEdad()+");";
        dbHelper.noQuery(nsql);
        dbHelper.close();

    }

    public ArrayList<Cliente> lista_clientes(Context context){
        DbHelper dbHelper = new DbHelper(context, "baseCliente", null, 1);
        String sql = "SELECT * FROM "+Base.TABLA_CLIENTE+";";
         list = new ArrayList<Cliente>();
        Cursor cursor = dbHelper.query(sql);
       // dbHelper.close();
        while (cursor.moveToNext()){
            Cliente clienteActual = new Cliente();
            clienteActual.setCedula("Cedula: "+cursor.getString(0));
            clienteActual.setNombre("Nombre: "+cursor.getString(1));
            clienteActual.setApellidos("Apellido: "+cursor.getString(2));
            clienteActual.setDireccion("Direccion: "+cursor.getString(3));
            clienteActual.setTelefono("Telefono: "+cursor.getString(4));
            clienteActual.setCorreo_electronico("Corre: "+cursor.getString(5));
            clienteActual.setEdad(cursor.getInt(6));
            list.add(clienteActual);
            dbHelper.close();
        }

        return list;

    }

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellidos, String direccion, String telefono, String correo_electronico, int edad) {
        Cedula = cedula;
        Nombre = nombre;
        Apellidos = apellidos;
        Direccion = direccion;
        Telefono = telefono;
        Correo_electronico = correo_electronico;
        Edad = edad;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo_electronico() {
        return Correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        Correo_electronico = correo_electronico;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
