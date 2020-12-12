package com.example.rpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rpg.Objects.Atributo;
import com.example.rpg.Objects.Classe;
import com.example.rpg.Objects.Ficha;
import com.squareup.picasso.Picasso;

public class ShowFicha extends AppCompatActivity {
    Context context = ShowFicha.this;
    Bitmap bit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ficha);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ImageView imgbg = findViewById(R.id.imgbg);final ImageView imgArrow1 = findViewById(R.id.imgArrow1);final ImageView imgArrow2 = findViewById(R.id.imgArrow2);final ImageView imgArrow3 = findViewById(R.id.imgArrow3);final ImageView imgArrow4 = findViewById(R.id.imgArrow4);final ImageView imgArrow5 = findViewById(R.id.imgArrow5);final ImageView imgArrow6 = findViewById(R.id.imgArrow6);final TextView txtName = findViewById(R.id.txtNameShow);final TextView txtRaca = findViewById(R.id.txtRacaShow);final TextView txtClasse = findViewById(R.id.txtClassShow);final TextView txtNivel = findViewById(R.id.txtNivelShow);final TextView txtPv = findViewById(R.id.txtSVida);final TextView txtPvS = findViewById(R.id.txtVidaShow);final TextView txtOrigem = findViewById(R.id.txtSOrigem);final TextView txtOrigemS = findViewById(R.id.txtOrigemShow);final TextView txtAlin = findViewById(R.id.txtSAlin);final TextView txtAlinS = findViewById(R.id.txtAlinShow);final TextView txtAtrib = findViewById(R.id.txtSAtrib);final TextView txtFor = findViewById(R.id.txtSFor);final TextView txtForS = findViewById(R.id.txtForShow);final TextView txtModFor = findViewById(R.id.txtModForShow);final TextView txtDes = findViewById(R.id.txtSDes);final TextView txtDesS = findViewById(R.id.txtDesShow);final TextView txtModDes = findViewById(R.id.txtModDesShow);final TextView txtCon = findViewById(R.id.txtSCon);final TextView txtConS = findViewById(R.id.txtConShow);final TextView txtModCon = findViewById(R.id.txtModConShow);final TextView txtInt = findViewById(R.id.txtSInt);final TextView txtIntS = findViewById(R.id.txtIntShow);final TextView txtModInt = findViewById(R.id.txtModIntShow);final TextView txtSab = findViewById(R.id.txtSSab);final TextView txtSabS = findViewById(R.id.txtSabShow);final TextView txtModSab = findViewById(R.id.txtModSabShow);final TextView txtCar = findViewById(R.id.txtSCar);final TextView txtCarS = findViewById(R.id.txtCarShow);final TextView txtModCar = findViewById(R.id.txtModCarShow);final TextView txtMagias = findViewById(R.id.txtSMagias);final TextView txtMagiasShow = findViewById(R.id.txtMagiaShow);final TextView txtPeri = findViewById(R.id.txtSPeri);final TextView txtPeriShow = findViewById(R.id.txtPeriShow);
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final Classe classeO = ficha.getClasseO();
        String classe = classeO.getClasse();
        Atributo atributo = ficha.getAtributo();
        txtName.setText(ficha.getPersonagem());
        txtRaca.setText(ficha.getRaca());
        txtClasse.setText(classe);
        txtNivel.setText(ficha.getNivel());
        txtPvS.setText(ficha.getVida());
        txtOrigemS.setText(ficha.getOrigem());
        txtAlinS.setText(ficha.getAlinhamento());
        txtForS.setText(atributo.getForca());
        txtDesS.setText(atributo.getDestreza());
        txtConS.setText(atributo.getConstituicao());
        txtIntS.setText(atributo.getInteligencia());
        txtSabS.setText(atributo.getSabedoria());
        txtCarS.setText(atributo.getCarisma());
        txtModFor.setText(atributo.getModFor());
        txtModDes.setText(atributo.getModDes());
        txtModCon.setText(atributo.getModCon());
        txtModInt.setText(atributo.getModInt());
        txtModSab.setText(atributo.getModSab());
        txtModCar.setText(atributo.getModCar());
        txtPeriShow.setText(ficha.getPericia());
        txtClasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Classe",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        txtRaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Raca",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        txtPeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Peri",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        txtAlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Alin",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        txtMagias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Magia",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        txtAtrib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Atrib",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        txtOrigem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String extra = "extra";
                intent.putExtra("Origem",extra);
                intent.putExtra("Ficha",ficha);
                startActivity(intent);
                finish();
            }
        });
        if (classe.equals("Arcanista")||classe.equals("Bardo")||classe.equals("Clérigo")||classe.equals("Druida")){
            txtMagiasShow.setText(ficha.getMagia());
        }else{
            txtMagias.setVisibility(View.INVISIBLE);
            txtMagiasShow.setVisibility(View.INVISIBLE);
        }
        final ConstraintLayout layout = findViewById(R.id.layoutzin);
        Picasso.get().load(ficha.getLink()).into(imgbg,new com.squareup.picasso.Callback(){

            @Override
            public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) imgbg.getDrawable()).getBitmap();
                if (bitmap != null) {
                    Palette color = Palette.from(bitmap).generate();
                    int vibrantColor = color.getVibrantColor(getResources().getColor(R.color.colorPrimary));
                    int average = color.getDominantColor(getResources().getColor(R.color.colorPrimary));
                    layout.setBackgroundColor(average);
                    txtName.setTextColor(vibrantColor);txtRaca.setTextColor(vibrantColor);txtClasse.setTextColor(vibrantColor);txtNivel.setTextColor(vibrantColor);txtPv.setTextColor(vibrantColor);txtPvS.setTextColor(vibrantColor);txtOrigem.setTextColor(vibrantColor);txtOrigemS.setTextColor(vibrantColor);txtAlin.setTextColor(vibrantColor);txtAlinS.setTextColor(vibrantColor);txtAtrib.setTextColor(vibrantColor);txtFor.setTextColor(vibrantColor);txtDes.setTextColor(vibrantColor);txtCon.setTextColor(vibrantColor);txtInt.setTextColor(vibrantColor);txtSab.setTextColor(vibrantColor);txtCar.setTextColor(vibrantColor);txtForS.setTextColor(vibrantColor);txtDesS.setTextColor(vibrantColor);txtConS.setTextColor(vibrantColor);txtIntS.setTextColor(vibrantColor);txtSabS.setTextColor(vibrantColor);txtCarS.setTextColor(vibrantColor);txtModFor.setTextColor(vibrantColor);txtModDes.setTextColor(vibrantColor);txtModCon.setTextColor(vibrantColor);txtModInt.setTextColor(vibrantColor);txtModSab.setTextColor(vibrantColor);txtModCar.setTextColor(vibrantColor);txtMagias.setTextColor(vibrantColor);txtMagiasShow.setTextColor(vibrantColor);txtPeri.setTextColor(vibrantColor);txtPeriShow.setTextColor(vibrantColor);
                    imgArrow1.setColorFilter(vibrantColor);imgArrow2.setColorFilter(vibrantColor);imgArrow3.setColorFilter(vibrantColor);imgArrow4.setColorFilter(vibrantColor);imgArrow5.setColorFilter(vibrantColor);imgArrow6.setColorFilter(vibrantColor);
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });

        /*Picasso.get().load(ficha.getLink()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                imgbg.setImageBitmap(bitmap);
                bit = bitmap;
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

         */
    }
}