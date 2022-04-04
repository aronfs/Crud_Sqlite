package com.example.crud_sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorCliente extends RecyclerView.Adapter<AdaptadorCliente.ViewHolderDatos> {


    ArrayList<Cliente> ListaCliente;

    public AdaptadorCliente(ArrayList<Cliente> listaCliente) {
        ListaCliente = listaCliente;
    }

    @NonNull
    @Override
    public AdaptadorCliente.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_cliente, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCliente.ViewHolderDatos holder, int position) {
       holder.txtCedula.setText(ListaCliente.get(position).getCedula());
       holder.txtNombre.setText(ListaCliente.get(position).getNombre());
       holder.txtApellido.setText(ListaCliente.get(position).getApellidos());
       holder.txtCorreo.setText(ListaCliente.get(position).getCorreo_electronico());
       holder.txtEdad.setText(String.valueOf(ListaCliente.get(position).getEdad()));
       holder.txtTelefono.setText(ListaCliente.get(position).getTelefono());
       holder.txtDireccion.setText(ListaCliente.get(position).getDireccion());
    }

    @Override
    public int getItemCount() {
        return ListaCliente.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView txtCedula,txtNombre, txtApellido, txtCorreo, txtEdad, txtTelefono, txtDireccion;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtCedula = itemView.findViewById(R.id.txtCedula);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtApellido = itemView.findViewById(R.id.txtApellido);
            txtCorreo = itemView.findViewById(R.id.txtCorreo);
           txtEdad = itemView.findViewById(R.id.textEdad);
            txtTelefono = itemView.findViewById(R.id.txtTelefono);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);

        }
    }



}
