package com.example.crud_sqlite;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Crear_Cliente extends AppCompatActivity {


    EditText txtCedula, txtNombre, txtApellido, txtDireccion, txtTelefono, txtCorreo_Electronico, txtFecha;
    Button btnCrearCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);
        CrearCliente();
    }

    public void CrearCliente(){
        btnCrearCliente = findViewById(R.id.btnCrearClienteRegistro);
        txtCedula = findViewById(R.id.editTextCedula);
        txtNombre = findViewById(R.id.editTextNombre);
        txtApellido = findViewById(R.id.editTextApellido);
        txtDireccion = findViewById(R.id.editTextDireccion);
        txtTelefono = findViewById(R.id.editTextTelefono);
        txtFecha = findViewById(R.id.editTextFechaNacimiento);
        txtCorreo_Electronico = findViewById(R.id.editTextCorreo);


        btnCrearCliente.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Cliente clienteActual = new Cliente();
                clienteActual.setCedula(txtCedula.getText().toString());
                clienteActual.setNombre(txtNombre.getText().toString());
                clienteActual.setApellidos(txtApellido.getText().toString());
                clienteActual.setDireccion(txtDireccion.getText().toString());
                clienteActual.setTelefono(txtTelefono.getText().toString());
                clienteActual.setEdad(CalcularFecha(txtFecha.getText().toString()));
                clienteActual.setCorreo_electronico(txtCorreo_Electronico.getText().toString());
                clienteActual.Crear_Cliente(Crear_Cliente.this);
                Toast.makeText(Crear_Cliente.this, "Cliente_Creado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Crear_Cliente.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public int CalcularFecha(String fechaNacimiento){
        int edad;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        edad = periodo.getYears();

        return edad;
    }




}