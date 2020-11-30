package com.example.rpg.Criation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.rpg.Ficha;
import com.example.rpg.R;
import com.example.rpg.SlideAdapter;

public class CriarClasse extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_classe);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        Button btnAvanc = findViewById(R.id.btnAvanClasse);
        SlideAdapter adapter = new SlideAdapter(this);
        viewPager.setAdapter(adapter);
        final String[] lst_classes = {"Arcanista","Bárbaro","Bardo","Bucaneiro","Caçador","Cavaleiro","Clérigo","Druida","Guerreiro","Inventor","Ladino","Lutador","Nobre","Paladino"};
        btnAvanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = viewPager.getCurrentItem();
                ficha.setClasse(lst_classes[i]);
                ficha.setPgC(getPaginas(lst_classes[i]));
                Intent intent = new Intent(CriarClasse.this, CriarFicha.class);
                intent.putExtra("Ficha", ficha);
                startActivity(intent);
                finish();
            }
        });
    }
    public int getPaginas(String classe){
        int pgC = 0;
        if(classe.equals("Arcanista")){
            pgC = 36;
        } else if(classe.equals("Bárbaro")){
            pgC = 40;
        } else if(classe.equals("Bardo")){
            pgC = 43;
        } else if(classe.equals("Bucaneiro")){
            pgC = 46;
        } else if(classe.equals("Caçador")){
            pgC = 49;
        } else if(classe.equals("Cavaleiro")){
            pgC = 52;
        } else if(classe.equals("Clérigo")){
            pgC = 56;
        } else if(classe.equals("Druida")){
            pgC = 60;
        } else if(classe.equals("Guerreiro")){
            pgC = 64;
        } else if(classe.equals("Inventor")){
            pgC = 67;
        } else if(classe.equals("Ladino")){
            pgC = 72;
        } else if(classe.equals("Lutador")){
            pgC = 75;
        } else if(classe.equals("Nobre")){
            pgC = 78;
        } else if(classe.equals("Paladino")){
            pgC = 81;
        }
        return pgC;
    }
}