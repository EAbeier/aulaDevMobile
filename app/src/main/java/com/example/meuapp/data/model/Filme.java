package com.example.meuapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Filme implements Parcelable {
    private String titulo;
    private String descricao;

    public Filme(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
