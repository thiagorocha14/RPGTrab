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

import com.example.rpg.Objects.Classe;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;
import com.example.rpg.Adapters.SlideAdapter;

public class CriarClasse extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_classe);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final Classe classe = new Classe();
        Button btnAvanc = findViewById(R.id.btnAvanClasse);
        SlideAdapter adapter = new SlideAdapter(this);
        viewPager.setAdapter(adapter);
        final String[] lst_classes = {"Arcanista","Bárbaro","Bardo","Bucaneiro","Caçador","Cavaleiro","Clérigo","Druida","Guerreiro","Inventor","Ladino","Lutador","Nobre","Paladino"};
        btnAvanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int i = viewPager.getCurrentItem();
                        classe.setClasse(lst_classes[i]);
                        ficha.setClasseO(classe);
                        Intent intent = new Intent(CriarClasse.this, CriarFicha.class);
                        intent.putExtra("Ficha", ficha);
                        startActivity(intent);
                        finish();
                    }
                },50);
            }
        });
    }
}