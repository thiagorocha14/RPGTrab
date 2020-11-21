package com.example.rpg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastrar extends AppCompatActivity {

    private EditText edtEmail,edtSenha,edtConfirm;
    private Button btnCad;
    final Animation animation = AnimationUtils.loadAnimation(Cadastrar.this,R.anim.bounce);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfirm  = findViewById(R.id.edtConfirm);
        btnCad = findViewById(R.id.btnCad);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animation);
                v.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (edtSenha.getText().toString().equals(edtConfirm.getText().toString())){
                            cadastrar(edtEmail.getText().toString(),edtSenha.getText().toString());
                        }else{
                            Toast.makeText(getBaseContext(), "As senhas não coincidem.", Toast.LENGTH_LONG).show();
                        }
                    }
                },50);
            }
        });
    }

    private void cadastrar(String email, String senha) {
        FirebaseAuth aut = FirebaseAuth.getInstance();
        aut.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Cadastrar.this,"Usuário cadastrado com sucesso.",Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    String respost = task.getException().toString();
                    Util.error(getBaseContext(), respost);
                }
            }
        });
    }
}
