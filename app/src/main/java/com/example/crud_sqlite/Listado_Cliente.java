package com.example.crud_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Listado_Cliente extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Cliente> listCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_cliente);
        //Listado();
        listCliente = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewCliente);
        recyclerView.setLayoutManager(new LinearLayoutManager(Listado_Cliente.this));
        ConsultarLista();
        AdaptadorCliente lista = new AdaptadorCliente(listCliente);
        recyclerView.setAdapter(lista);
    }

    public void Listado(){
        //DbHelper dbHelper = new DbHelper(Listado_Cliente.this, "baseCliente", null,1);

    }


    public void ConsultarLista(){
        Cliente cliente = new Cliente();
        listCliente = cliente.lista_clientes(Listado_Cliente.this);
    }
}
