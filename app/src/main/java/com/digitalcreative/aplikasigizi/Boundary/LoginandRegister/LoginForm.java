package com.digitalcreative.aplikasigizi.Boundary.LoginandRegister;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.digitalcreative.aplikasigizi.BaseActivity;
import com.digitalcreative.aplikasigizi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginForm extends Fragment {
    FirebaseAuth firebaseAuth;
    EditText email, pass;

    public LoginForm() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_form, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        email = view.findViewById(R.id.username);
        pass = view.findViewById(R.id.password);

            //Button Register
            final Button btn_registrasi =  view.findViewById(R.id.btn_register);
            btn_registrasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, new RegisterForm())
                            .addToBackStack(null).commit();
                }
            });

            //Button Login
            final Button btn_login = view.findViewById(R.id.btn_login);
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkemail_instance();
                }
            });
        return  view;
    }

    private void checkemail_instance() {
        String getemail = email.getText().toString();
        String getpass = pass.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(getemail, getpass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //success login
                    Log.d(TAG, "signInWithEmail:success");
                    Intent in = new Intent(getActivity(), BaseActivity.class);
                    startActivity(in);
                    clearfield();
                } else {
                    //fail for login
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(getActivity(), "Login Gagal - Silahkan Coba Lagi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearfield() {
        email.setText("");
        pass.setText("");
    }

}
