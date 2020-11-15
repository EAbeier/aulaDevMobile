package com.example.meuapp.data.model;

import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Filme {
    private String titulo;
    private String caminhoPoster;
    private ImageView poster;
    public Filme(String titulo, String caminhoPoster) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ImageView getPoster() {
        return poster;
    }

    public void setPoster() {
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+caminhoPoster)
                .into(this.poster);
    }


    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
