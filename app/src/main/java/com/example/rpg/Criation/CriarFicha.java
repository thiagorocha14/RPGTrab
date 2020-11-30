package com.example.rpg.Criation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.rpg.Dialogs.DialogPdf;
import com.example.rpg.Ficha;
import com.example.rpg.R;

public class CriarFicha extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_criar_ficha);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        ArrayAdapter<String> adapterAlin1 = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Alin1));
        ArrayAdapter<String> adapterAlin2 = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Alin2));
        ArrayAdapter<String> adapterOrigem = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Origem));
        final EditText edtNick;
        final Spinner spnAlin1,spnAlin2,spnOrigem;
        ImageView imgJog,imgNivel,imgAlin,imgOrigem,imgAtributos;
        final RadioButton rbBuy,rbRoll;
        final SeekBar skbLvl;
        Button btnAvançar;
        final TextView txtLvl;
        edtNick = findViewById(R.id.edtNick);
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
            imgNivel = findViewById(R.id.imgNivel);
            imgAlin = findViewById(R.id.imgAlin);
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
                    DialogPdf dialog = new DialogPdf();
                    dialog.setPage(114-1);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgNivel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogPdf dialog = new DialogPdf();
                    dialog.setPage(41-1);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgAlin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogPdf dialog = new DialogPdf();
                    dialog.setPage(115-1);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgOrigem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogPdf dialog = new DialogPdf();
                    dialog.setPage(91-1);
                    dialog.show(getSupportFragmentManager(), "dialog");
                }
            });
            imgAtributos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogPdf dialog = new DialogPdf();
                    dialog.setPage(23-1);
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
                            Integer nivel = skbLvl.getProgress();
                            nivel++;
                            ficha.setPersonagem(edtNick.getText().toString());
                            ficha.setNivel(nivel.toString());
                            ficha.setAlinhamento(spnAlin1.getSelectedItem().toString() + " " + spnAlin2.getSelectedItem().toString());
                            ficha.setOrigem(spnOrigem.getSelectedItem().toString());
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
}