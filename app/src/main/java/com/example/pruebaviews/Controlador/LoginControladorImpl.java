package com.example.pruebaviews.Controlador;

import com.example.pruebaviews.MainActivity;
import com.example.pruebaviews.Modelo.LoginInteractorImpl;
import com.example.pruebaviews.Modelo.LoginInterator;
import com.example.pruebaviews.Vista.LoginView;



public class LoginControladorImpl implements  LoginControlador, LoginInterator.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInterator loginInterator;

    public LoginControladorImpl(MainActivity loginView, LoginInteractorImpl loginInterator) {
        this.loginView = (LoginView) loginView;
        this.loginInterator = loginInterator;
    }

    @Override
    public void validateCreadentials(String username, String password) {
        if(loginView!=null){
            loginView.showProgress();
        }
        loginInterator.login(username,password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;

    }

    @Override
    public void onUsernameError() {
        if(loginView!=null){
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPassworError() {
        if(loginView!=null){
            loginView.setPasswordError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if(loginView!=null){
            loginView.navigateToHome();
            loginView.hideProgress();
        }
    }
}
