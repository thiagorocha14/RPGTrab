package com.example.rpg.Criation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;
import com.example.rpg.Adapters.SlideAdapter;

public class CriarRaca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_raca);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager2);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        Button btnAvanc = findViewById(R.id.btnAvanRaca);
        final String[] lst_raca = {"Humano","Anão","Dahllan","Elfo","Goblin","Lefou","Minotauro","Qareen","Golem","Hynne","Kliren","Medusa","Osteon","Sereia/Tristão","Sílfide","Suraggel","Trog"};
        final SlideAdapter adapter = new SlideAdapter(this);
        viewPager.setAdapter(adapter);
        btnAvanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int i = viewPager.getCurrentItem();
                        Ficha ficha = new Ficha();
                        ficha.setRaca(lst_raca[i]);
                        ficha.setPgR(getPaginas(lst_raca[i]));
                        Intent intent = new Intent(CriarRaca.this, CriarClasse.class);
                        intent.putExtra("Ficha", ficha);
                        startActivity(intent);
                        finish();
                    }
                },50);
            }
        });
    }
    public int getPaginas(String raca){
        int pgR = 0;
        if(raca.equals("Humano")){
            pgR = 19;
        } else if(raca.equals("Anão")){
            pgR = 20;
        } else if(raca.equals("Dahllan")){
            pgR = 21;
        } else if(raca.equals("Elfo")){
            pgR = 22;
        } else if(raca.equals("Goblin")){
            pgR = 23;
        } else if(raca.equals("Lefou")){
            pgR = 24;
        } else if(raca.equals("Minotauro")){
            pgR = 25;
        } else if(raca.equals("Qareen")){
            pgR = 26;
        } else if(raca.equals("Golem")){
            pgR = 27;
        } else if(raca.equals("Hynne")){
            pgR = 27;
        } else if(raca.equals("Kliren")){
            pgR = 28;
        } else if(raca.equals("Medusa")){
            pgR = 28;
        } else if(raca.equals("Osteon")){
            pgR = 29;
        } else if(raca.equals("Sereia/Tristão")){
            pgR = 29;
        } else if(raca.equals("Sílfide")){
            pgR = 30;
        } else if(raca.equals("Suraggel")){
            pgR = 30;
        } else if(raca.equals("Trog")){
            pgR = 31;
        }
        return pgR;
    }
}