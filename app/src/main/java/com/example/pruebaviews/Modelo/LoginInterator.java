package com.example.pruebaviews.Modelo;

public interface LoginInterator {
    interface OnLoginFinishedListener{
        void onUsernameError();
        void onPassworError();
        void onSuccess();

    }
    void login(String username, String password, OnLoginFinishedListener listener);
}
