package com.example.meuapp.data.model;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Filme{
    public String titulo;
    public String caminhoPoster;


    public Filme(String titulo, String caminhoPoster) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
