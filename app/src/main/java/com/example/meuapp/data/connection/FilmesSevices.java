package com.example.meuapp.data.connection;


import com.example.meuapp.data.connection.response.FilmesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesSevices {
    @GET("movie/popular")
    Call<FilmesResult> FilmesPoulares(@Query("api_key") String chaveApi);
}
