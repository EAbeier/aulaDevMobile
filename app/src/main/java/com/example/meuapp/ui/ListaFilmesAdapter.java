package com.example.meuapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.R;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {
    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.txtTituloFilme.setText("filme exemplo");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder{

       private TextView txtTituloFilme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTituloFilme = itemView.findViewById(R.id.txt_Titulo_Filme);

            txtTituloFilme.setText("exemplo");
        }
    }
}
