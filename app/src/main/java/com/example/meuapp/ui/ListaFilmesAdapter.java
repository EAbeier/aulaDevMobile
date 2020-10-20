package com.example.meuapp.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.R;
import com.example.meuapp.data.model.Filme;
import com.example.meuapp.databinding.ItemFilmeBinding;

import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.FilmeViewHolder>{
    private List<Filme> filmeList;
    public ListaFilmesAdapter(List<Filme> filmeList){
        this.filmeList = filmeList;
    }
    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFilmeBinding itemBinding = ItemFilmeBinding.inflate(layoutInflater, parent, false);
        return new FilmeViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Filme filme = filmeList.get(position);
        holder.bind(filme);
    }

    @Override
    public int getItemCount() {
        return filmeList != null ? filmeList.size():0;
    }

    class FilmeViewHolder extends RecyclerView.ViewHolder{
        private ItemFilmeBinding binding;

        public FilmeViewHolder(ItemFilmeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Filme filme){
            binding.setTela(filme);
            binding.executePendingBindings();
        }
    }
}
