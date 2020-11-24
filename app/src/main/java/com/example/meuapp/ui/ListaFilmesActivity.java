package com.example.meuapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.R;
import com.example.meuapp.data.connection.ApiService;
import com.example.meuapp.data.connection.response.FilmesResult;
import com.example.meuapp.data.mapper.FilmeMapper;
import com.example.meuapp.data.model.Filme;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {
    private ListaFilmesAdapter FilmeAdapter1 = new ListaFilmesAdapter();
    private ListaFilmesAdapter FilmeAdapter2 = new ListaFilmesAdapter();
    private ListaFilmesAdapter FilmeAdapter3 = new ListaFilmesAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);


        obtemFilmes();

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void retorna(View view) {
        startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
    }

    public void configuraAdapter() {
        RecyclerView rv1 = findViewById(R.id.rv_populares);
        RecyclerView rv2 = findViewById(R.id.rv_reproduzindo);
        RecyclerView rv3 = findViewById(R.id.rv_bem_avaliados);
        RecyclerView.LayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(linearLayoutManager1);
        rv2.setLayoutManager(linearLayoutManager2);
        rv3.setLayoutManager(linearLayoutManager3);
        rv1.setAdapter(FilmeAdapter1);
        rv2.setAdapter(FilmeAdapter2);
        rv3.setAdapter(FilmeAdapter3);
    }

    private void obtemFilmes() {
        ApiService.getInstance()
                .FilmesPopulares( "799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());
                            FilmeAdapter1.setFilmes(listaFilmes);;

                            configuraAdapter();
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
        ApiService.getInstance()
                .FilmesReproduzidos( "799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());

                            FilmeAdapter2.setFilmes(listaFilmes);

                            configuraAdapter();
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });
        ApiService.getInstance()
                .FilmesBemAvaliados("799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());

                            FilmeAdapter3.setFilmes(listaFilmes);

                            configuraAdapter();
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<FilmesResult> call, Throwable t) {
                        mostraErro();
                    }
                });

    }

    private void mostraErro() {
        Toast.makeText(this, "Falha na comunicaçao da api", Toast.LENGTH_SHORT)
                .show();
    }

    public void Share(View view) {
        String id;

        //TextView tv = (TextView) view.findViewById(R.id.tv_ml);
        //tv.getText().toString();
        TextView idText = ((View) view.getParent()).findViewById(R.id.txt_id);
        id = idText.getText().toString();

        System.out.println(id);
        String mensagem = "Se liga nesse filme http://filmes.uniritter.edu.br/filme?id="+id+"&de=Emerson";
        enviarWhatsApp(mensagem);


    }

    public void enviarWhatsApp(String mensagem) {
        PackageManager pm = getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = mensagem;

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(waIntent);

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp não instalado", Toast.LENGTH_SHORT).show();
        }
    }
}


