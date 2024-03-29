package com.example.rpg.Criation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpg.Objects.Atributo;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;
import com.example.rpg.Criation.Vida;

public class Atribut2 extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
    final Integer[] total = {20};
    TextView txttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_atribut2);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final ProgressBar prg, prgA,prgB,prgC,prgD,prgE;
        Button btn1, btn2, btn1A, btn2A,btn1B, btn2B,btn1C, btn2C,btn1D, btn2D,btn1E, btn2E,btnFinish;
        final TextView txt1, txt1A, txt1B, txt1C, txt1D, txt1E;
        txttotal = findViewById(R.id.txtTotal);
        btnFinish = findViewById(R.id.btnFinish2);
        {
            txt1 = findViewById(R.id.txt1);
            btn1 = findViewById(R.id.btn1);
            btn2 = findViewById(R.id.btn2);
            prg = findViewById(R.id.prgB);
            prg.setMax(19);
            prg.setProgress(9);
            txt1.setText(Integer.toString(prg.getProgress()+1));
        }
        {
            txt1A = findViewById(R.id.txt1A);
            btn1A = findViewById(R.id.btn1A);
            btn2A = findViewById(R.id.btn2A);
            prgA = findViewById(R.id.prgBA);
            prgA.setMax(19);
            prgA.setProgress(9);
            txt1A.setText(Integer.toString(prgA.getProgress()+1));
        }
        {
            txt1B = findViewById(R.id.txt1B);
            btn1B = findViewById(R.id.btn1B);
            btn2B = findViewById(R.id.btn2B);
            prgB = findViewById(R.id.prgBB);
            prgB.setMax(19);
            prgB.setProgress(9);
            txt1B.setText(Integer.toString(prgB.getProgress()+1));
        }
        {
            txt1C = findViewById(R.id.txt1C);
            btn1C = findViewById(R.id.btn1C);
            btn2C = findViewById(R.id.btn2C);
            prgC = findViewById(R.id.prgBC);
            prgC.setMax(19);
            prgC.setProgress(9);
            txt1C.setText(Integer.toString(prgC.getProgress()+1));
        }
        {
            txt1D = findViewById(R.id.txt1D);
            btn1D = findViewById(R.id.btn1D);
            btn2D = findViewById(R.id.btn2D);
            prgD = findViewById(R.id.prgBD);
            prgD.setMax(19);
            prgD.setProgress(9);
            txt1D.setText(Integer.toString(prgD.getProgress()+1));
        }
        {
            txt1E = findViewById(R.id.txt1E);
            btn1E = findViewById(R.id.btn1E);
            btn2E = findViewById(R.id.btn2E);
            prgE = findViewById(R.id.prgBE);
            prgE.setMax(19);
            prgE.setProgress(9);
            txt1E.setText(Integer.toString(prgE.getProgress()+1));
        }
        txttotal.setText(Integer.toString(total[0]));
        {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            menos(prg,txt1);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mais(prg,txt1);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
        }
        {
            btn1A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            menos(prgA,txt1A);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btn2A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mais(prgA,txt1A);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
        }
        {
            btn1B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            menos(prgB,txt1B);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btn2B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mais(prgB,txt1B);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
        }
        {
            btn1C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            menos(prgC,txt1C);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btn2C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mais(prgC,txt1C);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
        }
        {
            btn1D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            menos(prgD,txt1D);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btn2D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mais(prgD,txt1D);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
        }
        {
            btn1E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            menos(prgE,txt1E);
                            view.clearAnimation();
                        }
                    },50);


                }
            });
            btn2E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mais(prgE,txt1E);
                            view.clearAnimation();
                        }
                    },50);
                }
            });
        }
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                view.startAnimation(animation);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(total[0]>0){
                            Toast.makeText(getBaseContext(), "Você ainda tem pontos restantes.", Toast.LENGTH_SHORT).show();
                        }else{
                            Atributo atributo = new Atributo();
                            atributo.setForca(txt1.getText().toString());
                            atributo.setDestreza(txt1A.getText().toString());
                            atributo.setConstituicao(txt1B.getText().toString());
                            atributo.setInteligencia(txt1C.getText().toString());
                            atributo.setSabedoria(txt1D.getText().toString());
                            atributo.setCarisma(txt1E.getText().toString());
                            ficha.setAtributo(atributo);
                            Intent intent = new Intent(getApplicationContext(), Vida.class);
                            intent.putExtra("Ficha",ficha);
                            startActivity(intent);
                            finish();
                        }
                        view.clearAnimation();
                    }
                },50);
            }
        });
    }
 public void menos(ProgressBar pr,TextView txt){
     if (pr.getProgress() == 7) {
         Toast.makeText(getBaseContext(), "Você não pode diminuir mais!", Toast.LENGTH_SHORT).show();
     } else {
         if (pr.getProgress() + 1 == 15 || pr.getProgress() + 1 == 16) {
             total[0] = total[0] + 2;
             txttotal.setText(Integer.toString(total[0]));
         } else if (pr.getProgress() + 1 == 17 || pr.getProgress() + 1 == 18) {
             total[0] = total[0] + 3;
             txttotal.setText(Integer.toString(total[0]));
         } else {
             total[0]++;
             txttotal.setText(Integer.toString(total[0]));
         }
         pr.incrementProgressBy(-1);
         txt.setText(Integer.toString(pr.getProgress() + 1));
     }
 }

 public void mais(ProgressBar pr,TextView txt){
     if (total[0] == 0) {
         Toast.makeText(getBaseContext(), "Você não pode adicionar mais!", Toast.LENGTH_SHORT).show();
     } else {
         if (pr.getProgress() == 17) {
             Toast.makeText(getBaseContext(), "Você não pode adicionar mais!", Toast.LENGTH_SHORT).show();
         } else {
             if (pr.getProgress() + 1 == 14 || pr.getProgress() + 1 == 15) {
                 if (total[0] < 2) {
                     Toast.makeText(getBaseContext(), "Você não pode adicionar mais!", Toast.LENGTH_SHORT).show();
                 } else {
                     total[0] = total[0] - 2;
                     txttotal.setText(Integer.toString(total[0]));
                     pr.incrementProgressBy(+1);
                     txt.setText(Integer.toString(pr.getProgress() + 1));
                 }
             } else if (pr.getProgress() + 1 == 16 || pr.getProgress() + 1 == 17) {
                 if (total[0] < 3) {
                     Toast.makeText(getBaseContext(), "Você não pode adicionar mais!", Toast.LENGTH_SHORT).show();
                 } else {
                     total[0] = total[0] - 3;
                     txttotal.setText(Integer.toString(total[0]));
                     pr.incrementProgressBy(+1);
                     txt.setText(Integer.toString(pr.getProgress() + 1));
                 }
             } else {
                 total[0]--;
                 txttotal.setText(Integer.toString(total[0]));
                 pr.incrementProgressBy(+1);
                 txt.setText(Integer.toString(pr.getProgress() + 1));
             }
         }
     }
 }
}