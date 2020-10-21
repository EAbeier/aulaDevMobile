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

    protected Filme(Parcel in) {
        titulo = in.readString();
        descricao = in.readString();
    }

    public static final Creator<Filme> CREATOR = new Creator<Filme>() {
        @Override
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

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
        parcel.writeString(titulo);
        parcel.writeString(descricao);
    }
}
