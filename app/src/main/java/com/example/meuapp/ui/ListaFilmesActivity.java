package com.example.meuapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.meuapp.R;
import com.example.meuapp.data.connection.ApiService;
import com.example.meuapp.data.connection.response.FilmesResult;
import com.example.meuapp.data.mapper.FilmeMapper;
import com.example.meuapp.data.model.Filme;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {
        private RecyclerView rv1;
        private RecyclerView rv2;
        private RecyclerView rv3;
        private ListaFilmesAdapter FilmeAdapter = new ListaFilmesAdapter();

@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraAdapter();

        obtemFilmes();





        /*List<Filme> movieList = new ArrayList<>();
        movieList.add(new Filme("EndGame", "Aveneger endgame is awesome movie"));
        movieList.add(new Filme("Infinity wars", "Aveneger infinity wars is super awesome movie"));*/


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        public void retorna(View view){
                startActivity(new Intent(getBaseContext(),ListaFilmesActivity.class));
        }

    /*public void botaoClick(View view){
        Intent intent = new Intent( createPackageContext: this, activity_lista_filmes.class);
    }*/
        public void configuraAdapter(){
                rv1 = findViewById(R.id.rv_drama);
                rv2 = findViewById(R.id.rv_recomenda);
                rv3 = findViewById(R.id.rv_romance);
                FilmeAdapter = new ListaFilmesAdapter();
                RecyclerView.LayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
                RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
                RecyclerView.LayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
                rv1.setLayoutManager(linearLayoutManager1);
                rv2.setLayoutManager(linearLayoutManager2);
                rv3.setLayoutManager(linearLayoutManager3);
                rv1.setAdapter(FilmeAdapter);
                rv2.setAdapter(FilmeAdapter);
                rv3.setAdapter(FilmeAdapter);
        }
        private void obtemFilmes(){
                ApiService.getInstance()
                        .FilmesPoulares("799a1f0649735842ab24e00e80ad2b30")
                        .enqueue(new Callback<FilmesResult>() {
                                @Override
                                public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                                        if(response.isSuccessful()){
                                                final List<Filme> listaFilmes = FilmeMapper
                                                        .responseToDomain(response.body().getResultados());

                                                FilmeAdapter.setFilmes(listaFilmes);
                                        }
                                        else{
                                                mostraErro();
                                        }
                                }

                                @Override
                                public void onFailure(Call<FilmesResult> call, Throwable t) {
                                        mostraErro();
                                }
                        });
        }
        private void mostraErro(){
                Toast.makeText(this, "Falha na comunicaçao da api", Toast.LENGTH_SHORT)
                        .show();
        }
}