package com.digitalcreative.aplikasigizi.Controller.Firebase;

import android.app.Application;
import android.content.Intent;

import com.digitalcreative.aplikasigizi.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AutoLogin_Firebase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null){
            Intent intent = new Intent(AutoLogin_Firebase.this, BaseActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
