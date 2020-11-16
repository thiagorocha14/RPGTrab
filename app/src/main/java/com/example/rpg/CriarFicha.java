package com.example.rpg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpg.Atributos.Atribut1;
import com.example.rpg.Atributos.Atribut2;
import com.example.rpg.Atributos.Atributo;
import com.example.rpg.Dialogs.DialogHelp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CriarFicha extends AppCompatActivity {
    String pgC;
    String pgR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_criar_ficha);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        ArrayAdapter<String> adapterRaca = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Raças));
        ArrayAdapter<String> adapterClass = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Classes));
        ArrayAdapter<String> adapterAlin1 = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Alin1));
        ArrayAdapter<String> adapterAlin2 = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Alin2));
        ArrayAdapter<String> adapterOrigem = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Origem));
        final EditText edtNick;
        final Spinner spnRace, spnClass,spnAlin1,spnAlin2,spnOrigem;
        ImageView imgJog,imgRace,imgClass,imgNivel,imgAlin,imgMoral,imgEtico,imgOrigem,imgAtributos;
        final RadioButton rbBuy,rbRoll;
        final SeekBar skbLvl;
        Button btnAvançar;
        final TextView txtLvl;
        edtNick = findViewById(R.id.edtNick);
        spnRace = findViewById(R.id.spnRace);
        spnRace.setAdapter(adapterRaca);
        spnClass = findViewById(R.id.spnClass);
        spnClass.setAdapter(adapterClass);
        spnAlin1 = findViewById(R.id.spnAlin1);
        spnAlin1.setAdapter(adapterAlin1);
        spnAlin2 = findViewById(R.id.spnAlin2);
        spnAlin2.setAdapter(adapterAlin2);
        spnOrigem = findViewById(R.id.spnOrigem);
        spnOrigem.setAdapter(adapterOrigem);
        btnAvançar = findViewById(R.id.btnAvançar);
        skbLvl = findViewById(R.id.skbLvl);
        rbBuy = findViewById(R.id.radioBuy);
        rbRoll = findViewById(R.id.radioRoll);
        txtLvl = findViewById(R.id.txtLvl);
        {
            imgJog = findViewById(R.id.imgJog);
            imgRace = findViewById(R.id.imgRace);
            imgClass = findViewById(R.id.imgClasse);
            imgNivel = findViewById(R.id.imgNivel);
            imgAlin = findViewById(R.id.imgAlin);
            imgMoral = findViewById(R.id.imgMoral);
            imgEtico = findViewById(R.id.imgEtico);
            imgOrigem = findViewById(R.id.imgOrigem);
            imgAtributos = findViewById(R.id.imgAtrib);
        }
        skbLvl.setMax(19);
        skbLvl.setProgress(0);
        skbLvl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtLvl.setText(String.valueOf(i+1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        {
            imgJog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.nome);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgRace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.racas);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgClass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.classe);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgNivel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.nivel);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgAlin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.alin);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgMoral.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.moral);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgEtico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.etico);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgOrigem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.origem);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgAtributos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelp dialog = new DialogHelp();
                    dialog.setImgHelp(R.drawable.atributos);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });

        }
        btnAvançar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(edtNick.getText().toString().equals("")){
                            Toast.makeText(getBaseContext(), "Ué? Precisamos de um nome!", Toast.LENGTH_SHORT).show();
                        }else {
                            String classe, raca;
                            classe = spnClass.getSelectedItem().toString();
                            raca = spnRace.getSelectedItem().toString();
                            getPaginas(classe, raca);
                            Integer nivel = skbLvl.getProgress();
                            nivel++;
                            Ficha ficha = new Ficha();
                            ficha.setPersonagem(edtNick.getText().toString());
                            ficha.setRaca(raca);
                            ficha.setClasse(classe);
                            ficha.setNivel(nivel.toString());
                            ficha.setAlinhamento(spnAlin1.getSelectedItem().toString() + " " + spnAlin2.getSelectedItem().toString());
                            ficha.setOrigem(spnOrigem.getSelectedItem().toString());
                            ficha.setPaginaC(pgC);
                            ficha.setPaginaR(pgR);
                            if (rbBuy.isChecked()) {
                                Intent intent = new Intent(getApplicationContext(), Atribut2.class);
                                intent.putExtra("Ficha", ficha);
                                startActivity(intent);
                                finish();
                            } else if (rbRoll.isChecked()) {
                                Intent intent = new Intent(getApplicationContext(), Atribut1.class);
                                intent.putExtra("Ficha", ficha);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                },50);
            }
        });
    }
    public void getPaginas(String classe, String raca){
        if(classe.equals("Arcanista")){
            pgC = "42";
        } else if(classe.equals("Bárbaro")){
            pgC = "46";
        } else if(classe.equals("Bardo")){
            pgC = "50";
        } else if(classe.equals("Bucaneiro")){
            pgC = "52";
        } else if(classe.equals("Caçador")){
            pgC = "55";
        } else if(classe.equals("Cavaleiro")){
            pgC = "58";
        } else if(classe.equals("Clérigo")){
            pgC = "62";
        } else if(classe.equals("Druida")){
            pgC = "66";
        } else if(classe.equals("Guerreiro")){
            pgC = "70";
        } else if(classe.equals("Inventor")){
            pgC = "72";
        } else if(classe.equals("Ladino")){
            pgC = "78";
        } else if(classe.equals("Lutador")){
            pgC = "81";
        } else if(classe.equals("Nobre")){
            pgC = "84";
        } else if(classe.equals("Paladino")){
            pgC = "87";
        }
        if(raca.equals("Humano")){
            pgR = "25";
        } else if(raca.equals("Anão")){
            pgR = "26";
        } else if(raca.equals("Dahllan")){
            pgR = "27";
        } else if(raca.equals("Elfo")){
            pgR = "28";
        } else if(raca.equals("Goblin")){
            pgR = "29";
        } else if(raca.equals("Lefou")){
            pgR = "30";
        } else if(raca.equals("Minotauro")){
            pgR = "31";
        } else if(raca.equals("Qareen")){
            pgR = "32";
        } else if(raca.equals("Golem")){
            pgR = "33";
        } else if(raca.equals("Hynne")){
            pgR = "33";
        } else if(raca.equals("Kliren")){
            pgR = "34";
        } else if(raca.equals("Medusa")){
            pgR = "34";
        } else if(raca.equals("Osteon")){
            pgR = "35";
        } else if(raca.equals("Sereia/Tristão")){
            pgR = "35";
        } else if(raca.equals("Sílfide")){
            pgR = "36";
        } else if(raca.equals("Suraggel")){
            pgR = "36";
        } else if(raca.equals("Trog")){
            pgR = "37";
        }
    }
}