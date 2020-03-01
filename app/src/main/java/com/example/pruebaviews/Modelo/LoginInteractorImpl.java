package com.example.pruebaviews.Modelo;
import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInterator {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPassworError();
                    return;
                }
                listener.onSuccess();
           }
       },1000);
    }
}
