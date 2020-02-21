package com.example.pruebaviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pruebaviews.Controlador.LoginControlador;
import com.example.pruebaviews.Controlador.LoginControladorImpl;
import com.example.pruebaviews.Modelo.LoginInteractorImpl;
import com.example.pruebaviews.Vista.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private ProgressBar progressBar;
    private EditText usuario;
    private EditText password;
    private LoginControlador controlador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        usuario = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        findViewById(R.id.btnIngresar).setOnClickListener(this);

        controlador = new LoginControladorImpl(this,new LoginInteractorImpl());
    }
    @Override
    protected void onDestroy(){
        controlador.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        controlador.validateCreadentials(usuario.getText().toString(),password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        usuario.setError("Error de Usuario");
    }

    @Override
    public void setPasswordError() {
        password.setError("Error de Password");
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"Ingreso",Toast.LENGTH_SHORT).show();
    }
}
