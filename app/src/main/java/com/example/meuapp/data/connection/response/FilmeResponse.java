package com.example.meuapp.data.connection.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "title")
    private final String tituloFilme;

    public FilmeResponse(String caminhoPoster, String tituloFilme) {
        this.caminhoPoster = caminhoPoster;
        this.tituloFilme = tituloFilme;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }
}
