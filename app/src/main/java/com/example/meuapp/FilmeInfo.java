package com.example.meuapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.WindowManager;
        import android.widget.TextView;

        import com.example.meuapp.data.model.Filme;
        import com.example.meuapp.ui.ListaFilmesActivity;

public class FilmeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(getBaseContext(), ListaFilmesActivity.class));
                finish();
            }
        },5000);


    }
    public void setFilme(Filme filme){
        ((TextView)findViewById(R.id.id_nomefilme)).setText(filme.getTitulo());
    }

}