package com.example.rpg.Logins;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;

import com.example.rpg.MainActivity;
import com.example.rpg.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseAuth aut = FirebaseAuth.getInstance();
                FirebaseUser user = aut.getCurrentUser();
                if(user == null){
                    startActivity(new Intent(getBaseContext(),Login.class));
                    finish();
                }else{
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                    finish();
                }
            }
        },3000);
    }
}
