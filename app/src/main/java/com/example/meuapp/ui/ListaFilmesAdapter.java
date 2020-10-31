package com.example.meuapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme,parent,false);
        return new FilmeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        holder.bind(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return filmes != null ? filmes.size():0;
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder{
        private  ImageView imagePoster;
        private  TextView txtTituloFilme;

        public FilmeViewHolder(View itemView) {
            super(itemView);
            txtTituloFilme = itemView.findViewById(R.id.txt_titulo_filme);
            imagePoster= itemView.findViewById(R.id.poster_filme);

        }
        public void bind(Filme filme){
            txtTituloFilme.setText(filme.getTitulo());
            Picasso.get().load("https://image.tmdb.org/t/p/w342/"+filme.getCaminhoPoster())
                    .into(this.imagePoster);
        }
    }

    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
        notifyDataSetChanged();
    }
}
