package com.example.rpg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMagias extends AppCompatActivity {

    private ListView listmagia;
    private String Magias;
    private Button btnAbjur,btnAdiv,btnConv,btnEncan,btnEvoc,btnIlusao,btnNecro,btnTrans;
    private TextView txtMagias,btnMagias;
    final Integer[] cont = {0};
    Ficha ficha;
    Uri uri;
    String url  = "";
    private static final int SELECT_IMAGE = 1;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_magias);
        final String[][] lvmagias = {new String[50]};
        final Integer[] quantidade = new Integer[1];
        Magias = new String();
        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        txtMagias = findViewById(R.id.txtMagias);
        listmagia = (ListView) findViewById(R.id.listmagias);
        btnMagias = findViewById(R.id.btnMagias);
        btnAbjur = findViewById(R.id.btnAbjur); btnAdiv = findViewById(R.id.btnAdiv);btnConv = findViewById(R.id.btnConv);btnEncan = findViewById(R.id.btnEncan);btnEvoc = findViewById(R.id.btnEvoc);btnIlusao = findViewById(R.id.btnIlusao);btnNecro = findViewById(R.id.btnNecro);btnTrans = findViewById(R.id.btnTrans);
        final String[][] abjur1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] adiv1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] conv1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] encan1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] evoc1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] ilusao1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] necro1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] trans1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] magi1 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] magi2 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] magi3 = {new String[50],new String[50],new String[50],new String[50]};
        final String[][] finalLvmagias = {new String[50]};
        final String classe = ficha.getClasse();
        final Integer nivel = Integer.valueOf(ficha.getNivel());
        if (classe.equals("Druida")||classe.equals("Bardo")){
            quantidade[0] = 2+(nivel/2);
            txtMagias.setText("Como você escolheu "+classe+" você tem que escolher 3 escolas de Magias!");
            listmagia.setVisibility(View.INVISIBLE);
            btnMagias.setVisibility(View.INVISIBLE);
            {
                btnAbjur.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                abjur1[0] = getResources().getStringArray(R.array.arc1abjur);
                                abjur1[1] = getResources().getStringArray(R.array.arc2abjur);
                                abjur1[2] = getResources().getStringArray(R.array.arc3abjur);
                                abjur1[3] = getResources().getStringArray(R.array.arc4abjur);
                            } else {
                                abjur1[0] = getResources().getStringArray(R.array.div1abjur);
                                abjur1[1] = getResources().getStringArray(R.array.div2abjur);
                                abjur1[2] = getResources().getStringArray(R.array.div3abjur);
                                abjur1[3] = getResources().getStringArray(R.array.div4abjur);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], abjur1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], abjur1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], abjur1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], abjur1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnAbjur.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1abjur);
                                magi2[1] = getResources().getStringArray(R.array.arc2abjur);
                                magi2[2] = getResources().getStringArray(R.array.arc3abjur);
                                magi2[3] = getResources().getStringArray(R.array.arc4abjur);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1abjur);
                                magi2[1] = getResources().getStringArray(R.array.div2abjur);
                                magi2[2] = getResources().getStringArray(R.array.div3abjur);
                                magi2[3] = getResources().getStringArray(R.array.div4abjur);
                            }
                            cont[0]++;
                        } else {
                            btnAbjur.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1abjur);
                                magi1[1] = getResources().getStringArray(R.array.arc2abjur);
                                magi1[2] = getResources().getStringArray(R.array.arc3abjur);
                                magi1[3] = getResources().getStringArray(R.array.arc4abjur);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1abjur);
                                magi1[1] = getResources().getStringArray(R.array.div2abjur);
                                magi1[2] = getResources().getStringArray(R.array.div3abjur);
                                magi1[3] = getResources().getStringArray(R.array.div4abjur);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnAdiv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                adiv1[0] = getResources().getStringArray(R.array.arc1adiv);
                                adiv1[1] = getResources().getStringArray(R.array.arc2adiv);
                                adiv1[2] = getResources().getStringArray(R.array.arc3adiv);
                                adiv1[3] = getResources().getStringArray(R.array.arc4adiv);
                            } else {
                                adiv1[0] = getResources().getStringArray(R.array.div1adiv);
                                adiv1[1] = getResources().getStringArray(R.array.div2adiv);
                                adiv1[2] = getResources().getStringArray(R.array.div3adiv);
                                adiv1[3] = getResources().getStringArray(R.array.div4adiv);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], adiv1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], adiv1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], adiv1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], adiv1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1adiv);
                                magi2[1] = getResources().getStringArray(R.array.arc2adiv);
                                magi2[2] = getResources().getStringArray(R.array.arc3adiv);
                                magi2[3] = getResources().getStringArray(R.array.arc4adiv);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1adiv);
                                magi2[1] = getResources().getStringArray(R.array.div2adiv);
                                magi2[2] = getResources().getStringArray(R.array.div3adiv);
                                magi2[3] = getResources().getStringArray(R.array.div4adiv);
                            }
                            cont[0]++;
                        } else {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1adiv);
                                magi1[1] = getResources().getStringArray(R.array.arc2adiv);
                                magi1[2] = getResources().getStringArray(R.array.arc3adiv);
                                magi1[3] = getResources().getStringArray(R.array.arc4adiv);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1adiv);
                                magi1[1] = getResources().getStringArray(R.array.div2adiv);
                                magi1[2] = getResources().getStringArray(R.array.div3adiv);
                                magi1[3] = getResources().getStringArray(R.array.div4adiv);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnConv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                conv1[0] = getResources().getStringArray(R.array.arc1conv);
                                conv1[1] = getResources().getStringArray(R.array.arc2conv);
                                conv1[2] = getResources().getStringArray(R.array.arc3conv);
                                conv1[3] = getResources().getStringArray(R.array.arc4conv);
                            } else {
                                conv1[0] = getResources().getStringArray(R.array.div1conv);
                                conv1[1] = getResources().getStringArray(R.array.div2conv);
                                conv1[2] = getResources().getStringArray(R.array.div3conv);
                                conv1[3] = getResources().getStringArray(R.array.div4conv);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], conv1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], conv1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], conv1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], conv1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnConv.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1conv);
                                magi2[1] = getResources().getStringArray(R.array.arc2conv);
                                magi2[2] = getResources().getStringArray(R.array.arc3conv);
                                magi2[3] = getResources().getStringArray(R.array.arc4conv);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1conv);
                                magi2[1] = getResources().getStringArray(R.array.div2conv);
                                magi2[2] = getResources().getStringArray(R.array.div3conv);
                                magi2[3] = getResources().getStringArray(R.array.div4conv);
                            }
                            cont[0]++;
                        } else {
                            btnConv.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1conv);
                                magi1[1] = getResources().getStringArray(R.array.arc2conv);
                                magi1[2] = getResources().getStringArray(R.array.arc3conv);
                                magi1[3] = getResources().getStringArray(R.array.arc4conv);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1conv);
                                magi1[1] = getResources().getStringArray(R.array.div2conv);
                                magi1[2] = getResources().getStringArray(R.array.div3conv);
                                magi1[3] = getResources().getStringArray(R.array.div4conv);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnEncan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                encan1[0] = getResources().getStringArray(R.array.arc1encan);
                                encan1[1] = getResources().getStringArray(R.array.arc2encan);
                                encan1[2] = getResources().getStringArray(R.array.arc3encan);
                                encan1[3] = getResources().getStringArray(R.array.arc4encan);
                            } else {
                                encan1[0] = getResources().getStringArray(R.array.div1encan);
                                encan1[1] = getResources().getStringArray(R.array.div2encan);
                                encan1[2] = getResources().getStringArray(R.array.div3encan);
                                encan1[3] = getResources().getStringArray(R.array.div4encan);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], encan1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], encan1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], encan1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], encan1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnEncan.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1encan);
                                magi2[1] = getResources().getStringArray(R.array.arc2encan);
                                magi2[2] = getResources().getStringArray(R.array.arc3encan);
                                magi2[3] = getResources().getStringArray(R.array.arc4encan);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1encan);
                                magi2[1] = getResources().getStringArray(R.array.div2encan);
                                magi2[2] = getResources().getStringArray(R.array.div3encan);
                                magi2[3] = getResources().getStringArray(R.array.div4encan);
                            }
                            cont[0]++;
                        } else {
                            btnEncan.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1encan);
                                magi1[1] = getResources().getStringArray(R.array.arc2encan);
                                magi1[2] = getResources().getStringArray(R.array.arc3encan);
                                magi1[3] = getResources().getStringArray(R.array.arc4encan);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1encan);
                                magi1[1] = getResources().getStringArray(R.array.div2encan);
                                magi1[2] = getResources().getStringArray(R.array.div3encan);
                                magi1[3] = getResources().getStringArray(R.array.div4encan);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnEvoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                evoc1[0] = getResources().getStringArray(R.array.arc1evoc);
                                evoc1[1] = getResources().getStringArray(R.array.arc2evoc);
                                evoc1[2] = getResources().getStringArray(R.array.arc3evoc);
                                evoc1[3] = getResources().getStringArray(R.array.arc4evoc);
                            } else {
                                evoc1[0] = getResources().getStringArray(R.array.div1evoc);
                                evoc1[1] = getResources().getStringArray(R.array.div2evoc);
                                evoc1[2] = getResources().getStringArray(R.array.div3evoc);
                                evoc1[3] = getResources().getStringArray(R.array.div4evoc);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], evoc1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], evoc1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], evoc1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], evoc1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnEvoc.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1evoc);
                                magi2[1] = getResources().getStringArray(R.array.arc2evoc);
                                magi2[2] = getResources().getStringArray(R.array.arc3evoc);
                                magi2[3] = getResources().getStringArray(R.array.arc4evoc);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1evoc);
                                magi2[1] = getResources().getStringArray(R.array.div2evoc);
                                magi2[2] = getResources().getStringArray(R.array.div3evoc);
                                magi2[3] = getResources().getStringArray(R.array.div4evoc);
                            }
                            cont[0]++;
                        } else {
                            btnEvoc.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1evoc);
                                magi1[1] = getResources().getStringArray(R.array.arc2evoc);
                                magi1[2] = getResources().getStringArray(R.array.arc3evoc);
                                magi1[3] = getResources().getStringArray(R.array.arc4evoc);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1evoc);
                                magi1[1] = getResources().getStringArray(R.array.div2evoc);
                                magi1[2] = getResources().getStringArray(R.array.div3evoc);
                                magi1[3] = getResources().getStringArray(R.array.div4evoc);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnIlusao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                ilusao1[0] = getResources().getStringArray(R.array.arc1ilusao);
                                ilusao1[1] = getResources().getStringArray(R.array.arc2ilusao);
                                ilusao1[2] = getResources().getStringArray(R.array.arc3ilusao);
                                ilusao1[3] = getResources().getStringArray(R.array.arc4ilusao);
                            } else {
                                ilusao1[0] = getResources().getStringArray(R.array.div1ilusao);
                                ilusao1[1] = getResources().getStringArray(R.array.div2ilusao);
                                ilusao1[2] = getResources().getStringArray(R.array.div3ilusao);
                                ilusao1[3] = getResources().getStringArray(R.array.div4ilusao);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], ilusao1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], ilusao1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], ilusao1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], ilusao1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnIlusao.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1ilusao);
                                magi2[1] = getResources().getStringArray(R.array.arc2ilusao);
                                magi2[2] = getResources().getStringArray(R.array.arc3ilusao);
                                magi2[3] = getResources().getStringArray(R.array.arc4ilusao);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1ilusao);
                                magi2[1] = getResources().getStringArray(R.array.div2ilusao);
                                magi2[2] = getResources().getStringArray(R.array.div3ilusao);
                                magi2[3] = getResources().getStringArray(R.array.div4ilusao);
                            }
                            cont[0]++;
                        } else {
                            btnIlusao.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1ilusao);
                                magi1[1] = getResources().getStringArray(R.array.arc2ilusao);
                                magi1[2] = getResources().getStringArray(R.array.arc3ilusao);
                                magi1[3] = getResources().getStringArray(R.array.arc4ilusao);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1ilusao);
                                magi1[1] = getResources().getStringArray(R.array.div2ilusao);
                                magi1[2] = getResources().getStringArray(R.array.div3ilusao);
                                magi1[3] = getResources().getStringArray(R.array.div4ilusao);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnNecro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                necro1[0] = getResources().getStringArray(R.array.arc1necro);
                                necro1[1] = getResources().getStringArray(R.array.arc2necro);
                                necro1[2] = getResources().getStringArray(R.array.arc3necro);
                                necro1[3] = getResources().getStringArray(R.array.arc4necro);
                            } else {
                                necro1[0] = getResources().getStringArray(R.array.div1necro);
                                necro1[1] = getResources().getStringArray(R.array.div2necro);
                                necro1[2] = getResources().getStringArray(R.array.div3necro);
                                necro1[3] = getResources().getStringArray(R.array.div4necro);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], necro1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], necro1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], necro1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], necro1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnNecro.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1necro);
                                magi2[1] = getResources().getStringArray(R.array.arc2necro);
                                magi2[2] = getResources().getStringArray(R.array.arc3necro);
                                magi2[3] = getResources().getStringArray(R.array.arc4necro);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1necro);
                                magi2[1] = getResources().getStringArray(R.array.div2necro);
                                magi2[2] = getResources().getStringArray(R.array.div3necro);
                                magi2[3] = getResources().getStringArray(R.array.div4necro);
                            }
                            cont[0]++;
                        } else {
                            btnNecro.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1necro);
                                magi1[1] = getResources().getStringArray(R.array.arc2necro);
                                magi1[2] = getResources().getStringArray(R.array.arc3necro);
                                magi1[3] = getResources().getStringArray(R.array.arc4necro);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1necro);
                                magi1[1] = getResources().getStringArray(R.array.div2necro);
                                magi1[2] = getResources().getStringArray(R.array.div3necro);
                                magi1[3] = getResources().getStringArray(R.array.div4necro);
                            }
                            cont[0]++;
                        }
                    }
                });
                btnTrans.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cont[0] == 2) {
                            btnAdiv.setVisibility(View.INVISIBLE);
                            btnAbjur.setVisibility(View.INVISIBLE);
                            btnConv.setVisibility(View.INVISIBLE);
                            btnEncan.setVisibility(View.INVISIBLE);
                            btnEvoc.setVisibility(View.INVISIBLE);
                            btnIlusao.setVisibility(View.INVISIBLE);
                            btnNecro.setVisibility(View.INVISIBLE);
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                trans1[0] = getResources().getStringArray(R.array.arc1trans);
                                trans1[1] = getResources().getStringArray(R.array.arc2trans);
                                trans1[2] = getResources().getStringArray(R.array.arc3trans);
                                trans1[3] = getResources().getStringArray(R.array.arc4trans);
                            } else {
                                trans1[0] = getResources().getStringArray(R.array.div1trans);
                                trans1[1] = getResources().getStringArray(R.array.div2trans);
                                trans1[2] = getResources().getStringArray(R.array.div3trans);
                                trans1[3] = getResources().getStringArray(R.array.div4trans);
                            }
                            magi3[0] = juntar3Array(magi1[0], magi2[0], trans1[0]);
                            magi3[1] = juntar3Array(magi1[1], magi2[1], trans1[1]);
                            magi3[2] = juntar3Array(magi1[2], magi2[2], trans1[2]);
                            magi3[3] = juntar3Array(magi1[3], magi2[3], trans1[3]);
                            if (nivel < 6) {
                                lvmagias[0] = magi3[0];
                            } else if (nivel < 10) {
                                lvmagias[0] = juntar2Array(magi3[0], magi3[1]);
                            } else if (nivel < 14) {
                                lvmagias[0] = juntar3Array(magi3[0], magi3[1], magi3[2]);
                            } else {
                                lvmagias[0] = juntar4Array(magi3[0], magi3[1], magi3[2], magi3[3]);
                            }
                            listmagia.setVisibility(View.VISIBLE);
                            btnMagias.setVisibility(View.VISIBLE);
                            finalLvmagias[0] = lvmagias[0];
                            listmagia.setAdapter(new ArrayAdapter<String>(ListMagias.this, R.layout.layout_list_magias, finalLvmagias[0]));
                            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                        } else if (cont[0] == 1) {
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi2[0] = getResources().getStringArray(R.array.arc1trans);
                                magi2[1] = getResources().getStringArray(R.array.arc2trans);
                                magi2[2] = getResources().getStringArray(R.array.arc3trans);
                                magi2[3] = getResources().getStringArray(R.array.arc4trans);
                            } else {
                                magi2[0] = getResources().getStringArray(R.array.div1trans);
                                magi2[1] = getResources().getStringArray(R.array.div2trans);
                                magi2[2] = getResources().getStringArray(R.array.div3trans);
                                magi2[3] = getResources().getStringArray(R.array.div4trans);
                            }
                            cont[0]++;
                        } else {
                            btnTrans.setVisibility(View.INVISIBLE);
                            if (classe.equals("Bardo")) {
                                magi1[0] = getResources().getStringArray(R.array.arc1trans);
                                magi1[1] = getResources().getStringArray(R.array.arc2trans);
                                magi1[2] = getResources().getStringArray(R.array.arc3trans);
                                magi1[3] = getResources().getStringArray(R.array.arc4trans);
                            } else {
                                magi1[0] = getResources().getStringArray(R.array.div1trans);
                                magi1[1] = getResources().getStringArray(R.array.div2trans);
                                magi1[2] = getResources().getStringArray(R.array.div3trans);
                                magi1[3] = getResources().getStringArray(R.array.div4trans);
                            }
                            cont[0]++;
                        }
                    }
                });
            }
        } else {
            quantidade[0] = 2+nivel;
            txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
            btnAdiv.setVisibility(View.INVISIBLE);
            btnAbjur.setVisibility(View.INVISIBLE);
            btnConv.setVisibility(View.INVISIBLE);
            btnEncan.setVisibility(View.INVISIBLE);
            btnEvoc.setVisibility(View.INVISIBLE);
            btnIlusao.setVisibility(View.INVISIBLE);
            btnNecro.setVisibility(View.INVISIBLE);
            btnTrans.setVisibility(View.INVISIBLE);
            if (classe.equals("Clérigo")) {
                String magias[] = getResources().getStringArray(R.array.magias1div);
                String magias2[] = getResources().getStringArray(R.array.magias2div);
                String magias3[] = getResources().getStringArray(R.array.magias3div);
                String magias4[] = getResources().getStringArray(R.array.magias4div);
                String magias5[] = getResources().getStringArray(R.array.magias5div);

                if (nivel < 5) {
                    lvmagias[0] = magias;
                } else if (nivel < 9) {
                    lvmagias[0] = juntar2Array(magias, magias2);
                } else if (nivel < 13) {
                    lvmagias[0] = juntar3Array(magias, magias2, magias3);
                } else if (nivel < 17) {
                    lvmagias[0] = juntar4Array(magias, magias2, magias3, magias4);
                } else {
                    lvmagias[0] = juntar5Array(magias, magias2, magias3, magias4, magias5);
                }

            } else if (classe.equals("Arcanista")) {
                String magias[] = getResources().getStringArray(R.array.magias1arc);
                String magias2[] = getResources().getStringArray(R.array.magias2arc);
                String magias3[] = getResources().getStringArray(R.array.magias3arc);
                String magias4[] = getResources().getStringArray(R.array.magias4arc);
                String magias5[] = getResources().getStringArray(R.array.magias5arc);

                if (nivel < 5) {
                    lvmagias[0] = magias;
                } else if (nivel < 9) {
                    lvmagias[0] = juntar2Array(magias, magias2);
                } else if (nivel < 13) {
                    lvmagias[0] = juntar3Array(magias, magias2, magias3);
                } else if (nivel < 17) {
                    lvmagias[0] = juntar4Array(magias, magias2, magias3, magias4);
                } else {
                    lvmagias[0] = juntar5Array(magias, magias2, magias3, magias4, magias5);
                }
            }
            finalLvmagias[0] = lvmagias[0];
            listmagia.setAdapter(new ArrayAdapter<String>(this, R.layout.layout_list_magias, finalLvmagias[0]));
            listmagia.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        }
        listmagia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(quantidade[0] == 0){
                    if(listmagia.isItemChecked(i)){
                        Toast.makeText(getBaseContext(), "Você não pode escolher essa magias, suas magias acabaram parceiro!", Toast.LENGTH_SHORT).show();
                        listmagia.setItemChecked(i,false);
                    }else{
                        quantidade[0]++;
                        txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                    }
                }else{
                    if(listmagia.isItemChecked(i)){
                        quantidade[0]--;
                        txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                    }else{
                        quantidade[0]++;
                        txtMagias.setText("Você tem "+ quantidade[0].toString()+" magias pra escolher");
                    }
                }
            }
        });
        btnMagias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantidade[0]==0){
                    Magias = new String();
                    SparseBooleanArray a = listmagia.getCheckedItemPositions();
                    for (int i = 0; i < finalLvmagias[0].length; i++) {
                            if (a.get(i)) {
                                Magias = Magias +"\n"+ (String) listmagia.getAdapter().getItem(i);
                            }
                    }
                    ficha.setMagia(Magias);
                    AlertDialog.Builder alert = new AlertDialog.Builder(ListMagias.this);
                    alert.setTitle("Deseja enviar uma imagem do seu personagem?").setPositiveButton("Sim",dialog).setNegativeButton("Não",dialog);
                    alert.show();
                }else{
                    Toast.makeText(getBaseContext(), "Ué? Que isso? Escolhe todas as magias que você pode aprender.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void selecimg() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,SELECT_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            StorageReference arqRef = storageReference.child(System.currentTimeMillis()+"."+extensao(uri));
            arqRef.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful());
                            Uri downloadUrl = urlTask.getResult();
                            url = downloadUrl.toString();
                            ficha.setLink(url);
                            BD.enviar(ficha);
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                        }
                    });
        }
    }
    DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    selecimg();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    BD.enviar(ficha);
                    finish();
                    break;
            }
        }
    };
    private String extensao(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
    protected String[] juntar2Array(String[] array1, String[] array2){
        List<String> soma = new ArrayList<>();
        Collections.addAll(soma,array1);
        Collections.addAll(soma,array2);
        String[] result = soma.toArray(new String[soma.size()]);
        return result;
    }
    protected String[] juntar3Array(String[] array1,String[] array2,String[] array3){
        List<String> soma = new ArrayList<>();
        Collections.addAll(soma,array1);
        Collections.addAll(soma,array2);
        Collections.addAll(soma,array3);
        String[] result = soma.toArray(new String[soma.size()]);
        return result;
    }
    protected String[] juntar4Array(String[] array1,String[] array2,String[] array3,String[] array4){
        List<String> soma = new ArrayList<>();
        Collections.addAll(soma,array1);
        Collections.addAll(soma,array2);
        Collections.addAll(soma,array3);
        Collections.addAll(soma,array4);
        String[] result = soma.toArray(new String[soma.size()]);
        return result;
    }
    protected String[] juntar5Array(String[] array1,String[] array2,String[] array3,String[] array4,String[] array5){
        List<String> soma = new ArrayList<>();
        Collections.addAll(soma,array1);
        Collections.addAll(soma,array2);
        Collections.addAll(soma,array3);
        Collections.addAll(soma,array4);
        Collections.addAll(soma,array5);
        String[] result = soma.toArray(new String[soma.size()]);
        return result;
    }
}