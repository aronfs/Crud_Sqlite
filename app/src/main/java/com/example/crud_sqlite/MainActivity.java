package com.example.crud_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCrearBase, btnCrearCliente, btnListadoPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Crear_Base();
        Crear_ClienteBoton();
        Listar();
    }


    public void Crear_Base(){
        btnCrearBase = findViewById(R.id.btnCrearBase);

        btnCrearBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this, "baseCliente", null, 1);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db!=null){
                    Toast.makeText(MainActivity.this, "Base Cliente Creada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error al Crear Base Cliente", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void Listar(){
        btnListadoPersona = findViewById(R.id.btnListadoClienteMenu);
        btnListadoPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Listado_Cliente.class);
                startActivity(intent);
            }
        });
    }

    public void Crear_ClienteBoton(){
        btnCrearCliente = findViewById(R.id.btnCrearClienteMenu);
        btnCrearCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Crear_Cliente.class);
                startActivity(intent);
            }
        });
    }

}