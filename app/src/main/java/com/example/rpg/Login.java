package com.example.rpg;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity{
    private EditText edtEmail,edtSenha;
    private TextView txtNew,txtForget;
    private Button btnLogin;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final Animation animation = AnimationUtils.loadAnimation(Login.this,R.anim.bounce);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        txtNew = findViewById(R.id.txtNew);
        txtForget = findViewById(R.id.txtForget);
        btnLogin = findViewById(R.id.btnCad);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        login();
                    }
                },50);
            }
        });
        txtForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                if(email.isEmpty()){
                    Toast.makeText(Login.this,"Preencha o email para recuperar a senha",Toast.LENGTH_LONG).show();
                }else{
                    enviar(email);
                }
            }
        });
        txtNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Cadastrar.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void enviar(String email) {
        FirebaseAuth aut = FirebaseAuth.getInstance();
        aut.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Login.this)
                        .setTitle("Enviamos um link para o email digitado para redefinir a senha.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}});
                alert.show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String erro = e.toString();
                Util.error(getBaseContext(),erro);
            }
        });
    }

    private void login() {
        String email = edtEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(getBaseContext(), "Preencha os campos obrigatórios", Toast.LENGTH_LONG).show();
        } else {
            if (Util.statusNet(this)) {
                ConnectivityManager conexao = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                user = new User();
                user.setEmail(edtEmail.getText().toString().trim());
                user.setSenha(edtSenha.getText().toString().trim());
                verificar();
            } else {
                Toast.makeText(getBaseContext(), "Sem conexão com a internet", Toast.LENGTH_LONG).show();
            }
    }
 }

    private void verificar() {
        FirebaseAuth aut = FirebaseAuth.getInstance();
        aut.signInWithEmailAndPassword(user.getEmail(), user.getSenha())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(Login.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(Login.this, "Login efetuado com sucesso.",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            String resposta = task.getException().toString();
                            Util.error(getBaseContext(), resposta);
                        }
                    }
                });
    }
}

