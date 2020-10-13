package com.example.meuapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.meuapp.R;

public class ListaFilmesActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);
        RecyclerView rv1 = findViewById(R.id.rv_drama);
        RecyclerView rv2 = findViewById(R.id.rv_recomenda);
        RecyclerView rv3 = findViewById(R.id.rv_romance);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rv1.setLayoutManager(linearLayoutManager);
        rv2.setLayoutManager(linearLayoutManager);
        rv3.setLayoutManager(linearLayoutManager);


        rv1.setAdapter(new ListaFilmesAdapter());
        rv2.setAdapter(new ListaFilmesAdapter());
        rv3.setAdapter(new ListaFilmesAdapter());
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

    /*public void botaoClick(View view){
        Intent intent = new Intent( createPackageContext: this, activity_lista_filmes.class);
    }*/
}