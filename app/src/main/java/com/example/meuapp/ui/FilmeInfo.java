package com.example.meuapp.ui;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.drawable.Drawable;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Handler;
        import android.util.Log;
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
        import com.example.meuapp.ui.ListaFilmesActivity;
        import com.squareup.picasso.Picasso;

        import org.jetbrains.annotations.NotNull;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class FilmeInfo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Conecta();


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
                finish();
            }
        },5000);


    }
    public void setFilme(Filme filme){

        String titulo = filme.getTitulo();
        ((TextView)findViewById(R.id.id_nomefilme)).setText(titulo);
        ImageView poster = findViewById(R.id.poster_filme_info);
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+filme.getCaminhoPoster())
                .into(poster);
        String descricao = filme.getTitulo();
        ((TextView)findViewById(R.id.descricao_filme)).setText(descricao);
    }

    private void mostraErro(){
        Toast.makeText(this, "Falha na comunicaçao da api", Toast.LENGTH_SHORT)
                .show();
    }
    private void Conecta(){
        int idFilme = 0;
        Intent intent = getIntent();
        if(Intent.ACTION_VIEW.contains(intent.getAction())){
            Uri uri = intent.getData();
            String id = uri.getQueryParameter("id");
            idFilme = Integer.parseInt(id);
        }else{
            if(intent.getType().equals("aplication/json")){
                try{
                    JSONObject json = new JSONObject(intent.getExtras().getString("json"));
                    idFilme = json.getInt("id");
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }else{
                idFilme = this.getIntent().getIntExtra("idFilme", 497582);

            }
        }
        Conectaapi(idFilme);
    }
    private void Conectaapi(int idFilme) {
        String idstring = Integer.toString(idFilme);
        ApiService.getInstance()
                .Filme(idstring, "799a1f0649735842ab24e00e80ad2b30", "pt-BR")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(@NotNull Call<FilmesResult> call, @NotNull Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .responseToDomain(response.body().getResultados());
                            Filme filme = listaFilmes.get(0);
                            setFilme(filme);


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
}