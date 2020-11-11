package com.example.meuapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {
    private ListaFilmesAdapter FilmeAdapter = new ListaFilmesAdapter();
    private ListaFilmesAdapter FilmeAdapter1 = new ListaFilmesAdapter();
    private ListaFilmesAdapter FilmeAdapter2 = new ListaFilmesAdapter();


@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);


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
            RecyclerView rv1 = findViewById(R.id.rv_drama);
            RecyclerView rv2 = findViewById(R.id.rv_recomenda);
            RecyclerView rv3 = findViewById(R.id.rv_romance);
                RecyclerView.LayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
                RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
                RecyclerView.LayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
                rv1.setLayoutManager(linearLayoutManager1);
                rv2.setLayoutManager(linearLayoutManager2);
                rv3.setLayoutManager(linearLayoutManager3);
                rv1.setAdapter(FilmeAdapter);
                rv2.setAdapter(FilmeAdapter1);
                rv3.setAdapter(FilmeAdapter2);
        }
        private void obtemFilmes(){
                ApiService.getInstance()
                        .FilmesPoulares("799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                        .enqueue(new Callback<FilmesResult>() {
                                @Override
                                public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                                        if(response.isSuccessful()){
                                                final List<Filme> listaFilmes = FilmeMapper
                                                        .responseToDomain(response.body().getResultados());
                                                FilmeAdapter1.setFilmes(listaFilmes);
                                                FilmeAdapter2.setFilmes(listaFilmes);
                                                FilmeAdapter.setFilmes(listaFilmes);

                                                configuraAdapter();
                                        }
                                        else{
                                                mostraErro();
                                        }
                                }

                                @Override
                                public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                                        mostraErro();
                                }
                        });
        }
        private void mostraErro(){
                Toast.makeText(this, "Falha na comunicaçao da api", Toast.LENGTH_SHORT)
                        .show();
        }
}