package com.example.crud_sqlite;

public class Base {


    //Constantes Tabla Cliente
    public static final String TABLA_CLIENTE=" cliente ";
    public static final String CEDULA="cedula ";
    public static final String NOMBRE="nombre ";
    public static final String APELLIDO="apellido ";
    public static final String DIRECCION="direccion ";
    public static final String TELEFONO="telefono ";
    public static final String CORREO_ELECTRONICO="correo_electronico ";
    public static final String EDAD="edad ";
    //public static final String FOTO="foto";

    public static final String CREAR_TABLA_CLIENTE="CREATE TABLE "+TABLA_CLIENTE+" (" +
            " "+CEDULA+" TEXT PRIMARY KEY, "+ NOMBRE+ " TEXT, "+APELLIDO+" TEXT, "+DIRECCION+" TEXT, "+TELEFONO+"TEXT,"+CORREO_ELECTRONICO+"TEXT, "+EDAD+" INT)";

}
