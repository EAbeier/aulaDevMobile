package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


    public void verificaDados(View view){
        EditText email = (EditText)findViewById(R.id.inEmail);
        EditText pass = (EditText)findViewById(R.id.inPass);
        String emailCompara = "admin@admin.com.br";
        String passCompara = "12345";
        if ((email.getText().toString().equals(emailCompara))
                &&((pass.getText().toString().equals(passCompara)))){
            startActivity(new Intent(getBaseContext(),catalogoFilmes.class));
            finish();
        }else{
            Toast.makeText(
                    loginActivity.this, "usuario ou senha incorreta",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void cadastra(View view){
        startActivity(new Intent(getBaseContext(),SignInActivity.class));
    }
}