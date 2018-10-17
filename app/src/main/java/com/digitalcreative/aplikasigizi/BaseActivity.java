package com.digitalcreative.aplikasigizi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.digitalcreative.aplikasigizi.Boundary.Mainmenu.HomeFragment;

public class BaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //Init
        descTheComponent();

        //Actions
//        title.setText("Aplikasi Gizi");
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);

        Fragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_base, fragment);
        fragmentTransaction.commit();
    }

    private void descTheComponent() {
        //Describe Component
        toolbar = findViewById(R.id.toolbars);
        title = findViewById(R.id.text_title);
    }
}
