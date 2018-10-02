package com.digitalcreative.aplikasigizi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.digitalcreative.aplikasigizi.Boundary.LoginandRegister.LoginForm;

public class LogReg_Base extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg__base);
        Fragment fragment = new LoginForm();
        FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.container, fragment);
                fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}
