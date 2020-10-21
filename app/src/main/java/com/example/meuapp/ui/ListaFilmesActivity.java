package com.example.meuapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meuapp.R;
import com.example.meuapp.data.model.Filme;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaFilmesActivity extends AppCompatActivity {



@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        RecyclerView rv1 = findViewById(R.id.rv_drama);
        RecyclerView rv2 = findViewById(R.id.rv_recomenda);
        RecyclerView rv3 = findViewById(R.id.rv_romance);
        RecyclerView.LayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        RecyclerView.LayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        rv1.setLayoutManager(linearLayoutManager1);
        rv2.setLayoutManager(linearLayoutManager2);
        rv3.setLayoutManager(linearLayoutManager3);

        List<Filme> movieList = new ArrayList<>();
        movieList.add(new Filme("EndGame", "Aveneger endgame is awesome movie"));
        movieList.add(new Filme("Infinity wars", "Aveneger infinity wars is super awesome movie"));

        rv1.setAdapter(new ListaFilmesAdapter(movieList));
        rv2.setAdapter(new ListaFilmesAdapter(movieList));
        rv3.setAdapter(new ListaFilmesAdapter(movieList));
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        public void retorna(View view){
                startActivity(new Intent(getBaseContext(),ListaFilmesActivity.class));
        }

    /*public void botaoClick(View view){
        Intent intent = new Intent( createPackageContext: this, activity_lista_filmes.class);
    }*/
}