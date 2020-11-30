package com.example.meuapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.R;
import com.example.meuapp.data.model.Filme;
import com.example.meuapp.databinding.ItemFilmeBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.FilmeViewHolder>{
    private List<Filme> filmes;


    public ListaFilmesAdapter() {
        this.filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme,parent,false);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFilmeBinding itemBinding = ItemFilmeBinding.inflate(layoutInflater, parent, false);
        return new FilmeViewHolder(itemBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.bind(filme);
    }

    @Override
    public int getItemCount() {
        return filmes != null ? filmes.size():0;
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder{
        //private  ImageView poster;
        /*private  TextView txtTituloFilme;*/
        private ItemFilmeBinding binding;

        public FilmeViewHolder(ItemFilmeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
        public void bind(Filme filme){
            binding.txtTituloFilme.setText(filme.getTitulo());
            binding.txtId.setText(filme.getIdFilme());
            ImageView poster = this.binding.getRoot().findViewById(R.id.poster_filme);
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+filme.getCaminhoPoster())
                    .into(poster);
        }

    }


    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
        notifyDataSetChanged();
    }


}
