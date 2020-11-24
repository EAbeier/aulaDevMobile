package com.example.meuapp.data.connection.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "title")
    private final String tituloFilme;
    @Json(name="id")
    private final String idFilme;

    public FilmeResponse(String caminhoPoster, String tituloFilme, String idFilme) {
        this.caminhoPoster = caminhoPoster;
        this.tituloFilme = tituloFilme;
        this.idFilme = idFilme;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }
    public String getIdFilme(){return idFilme;}
}
