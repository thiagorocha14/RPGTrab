package com.example.rpg.Atributos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rpg.Ficha;
import com.example.rpg.R;
import com.example.rpg.VidaV;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Atribut1 extends AppCompatActivity {
    Spinner spn1A, spn1B, spn1C, spn1D, spn1E, spn1F;
    final Random r = new Random();
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_atribut1);

            /*
            txt1,txt3,txt5,txt7 são os números aleatórios
            txt2,txt4,txt6,txt8 são os simbolos +
            txt9 é o resultado
            txt10,txt11,txt12,txt13 são as barras que cortam o menor número
             */

            final Animation animation = AnimationUtils.loadAnimation(this,R.anim.implod);
            final Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.bounce);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.style_spinner,getResources().getStringArray(R.array.Atributos));
            final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Button btnNext = findViewById(R.id.btnFinish);

            spn1A = findViewById(R.id.spn1A);
            spn1A.setAdapter(adapter);
            final Button btnRollA = findViewById(R.id.btnRollA);
            final TextView txt1A = findViewById(R.id.txt1A);
            final TextView txt2A = findViewById(R.id.txt2A);
            final TextView txt3A = findViewById(R.id.txt3A);
            final TextView txt4A = findViewById(R.id.txt4A);
            final TextView txt5A = findViewById(R.id.txt5A);
            final TextView txt6A = findViewById(R.id.txt6A);
            final TextView txt7A = findViewById(R.id.txt7A);
            final TextView txt8A = findViewById(R.id.txt8A);
            final TextView txt9A = findViewById(R.id.txt9A);
            final TextView txt10A = findViewById(R.id.txt10A);
            final TextView txt11A = findViewById(R.id.txt11A);
            final TextView txt12A = findViewById(R.id.txt12A);
            final TextView txt13A = findViewById(R.id.txt13A);
            //Declaração 1

            spn1B = findViewById(R.id.spn1B);
            spn1B.setAdapter(adapter);
            final Button btnRollB = findViewById(R.id.btnRollB);
            final TextView txt1B = findViewById(R.id.txt1B);
            final TextView txt2B = findViewById(R.id.txt2B);
            final TextView txt3B = findViewById(R.id.txt3B);
            final TextView txt4B = findViewById(R.id.txt4B);
            final TextView txt5B = findViewById(R.id.txt5B);
            final TextView txt6B = findViewById(R.id.txt6B);
            final TextView txt7B = findViewById(R.id.txt7B);
            final TextView txt8B = findViewById(R.id.txt8B);
            final TextView txt9B = findViewById(R.id.txt9B);
            final TextView txt10B = findViewById(R.id.txt10B);
            final TextView txt11B = findViewById(R.id.txt11B);
            final TextView txt12B = findViewById(R.id.txt12B);
            final TextView txt13B = findViewById(R.id.txt13B);
            //Declaração 2

            spn1C = findViewById(R.id.spn1C);
            spn1C.setAdapter(adapter);
            final Button btnRollC = findViewById(R.id.btnRollC);
            final TextView txt1C = findViewById(R.id.txt1C);
            final TextView txt2C = findViewById(R.id.txt2C);
            final TextView txt3C = findViewById(R.id.txt3C);
            final TextView txt4C = findViewById(R.id.txt4C);
            final TextView txt5C = findViewById(R.id.txt5C);
            final TextView txt6C = findViewById(R.id.txt6C);
            final TextView txt7C = findViewById(R.id.txt7C);
            final TextView txt8C = findViewById(R.id.txt8C);
            final TextView txt9C = findViewById(R.id.txt9C);
            final TextView txt10C = findViewById(R.id.txt10C);
            final TextView txt11C = findViewById(R.id.txt11C);
            final TextView txt12C = findViewById(R.id.txt12C);
            final TextView txt13C = findViewById(R.id.txt13C);
            //Declaração 3

            spn1D = findViewById(R.id.spn1D);
            spn1D.setAdapter(adapter);
            final Button btnRollD = findViewById(R.id.btnRollD);
            final TextView txt1D = findViewById(R.id.txt1D);
            final TextView txt2D = findViewById(R.id.txt2D);
            final TextView txt3D = findViewById(R.id.txt3D);
            final TextView txt4D = findViewById(R.id.txt4D);
            final TextView txt5D = findViewById(R.id.txt5D);
            final TextView txt6D = findViewById(R.id.txt6D);
            final TextView txt7D = findViewById(R.id.txt7D);
            final TextView txt8D = findViewById(R.id.txt8D);
            final TextView txt9D = findViewById(R.id.txt9D);
            final TextView txt10D = findViewById(R.id.txt10D);
            final TextView txt11D = findViewById(R.id.txt11D);
            final TextView txt12D = findViewById(R.id.txt12D);
            final TextView txt13D = findViewById(R.id.txt13D);
            //Declaração 4

            spn1E = findViewById(R.id.spn1E);
            spn1E.setAdapter(adapter);
            final Button btnRollE = findViewById(R.id.btnRollE);
            final TextView txt1E = findViewById(R.id.txt1E);
            final TextView txt2E = findViewById(R.id.txt2E);
            final TextView txt3E = findViewById(R.id.txt3E);
            final TextView txt4E = findViewById(R.id.txt4E);
            final TextView txt5E = findViewById(R.id.txt5E);
            final TextView txt6E = findViewById(R.id.txt6E);
            final TextView txt7E = findViewById(R.id.txt7E);
            final TextView txt8E = findViewById(R.id.txt8E);
            final TextView txt9E = findViewById(R.id.txt9E);
            final TextView txt10E = findViewById(R.id.txt10E);
            final TextView txt11E = findViewById(R.id.txt11E);
            final TextView txt12E = findViewById(R.id.txt12E);
            final TextView txt13E = findViewById(R.id.txt13E);
            //Declaração 5

            spn1F = findViewById(R.id.spn1F);
            spn1F.setAdapter(adapter);
            final Button btnRollF = findViewById(R.id.btnRollF);
            final TextView txt1F = findViewById(R.id.txt1F);
            final TextView txt2F = findViewById(R.id.txt2F);
            final TextView txt3F = findViewById(R.id.txt3F);
            final TextView txt4F = findViewById(R.id.txt4F);
            final TextView txt5F = findViewById(R.id.txt5F);
            final TextView txt6F = findViewById(R.id.txt6F);
            final TextView txt7F = findViewById(R.id.txt7F);
            final TextView txt8F = findViewById(R.id.txt8F);
            final TextView txt9F = findViewById(R.id.txt9F);
            final TextView txt10F = findViewById(R.id.txt10F);
            final TextView txt11F = findViewById(R.id.txt11F);
            final TextView txt12F = findViewById(R.id.txt12F);
            final TextView txt13F = findViewById(R.id.txt13F);
            //Declaração 6
        {
            {
                btnRollA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(animation);
                        view.postOnAnimationDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnRollA.setVisibility(View.INVISIBLE);
                                gerarAtributos(txt1A,txt2A,txt3A,txt4A,txt5A,txt6A,txt7A,txt8A,txt9A,txt10A,txt11A,txt12A,txt13A);
                            }
                        },100);
                    }
                });
            }//Botão 1
            {
                btnRollB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(animation);
                        view.postOnAnimationDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnRollB.setVisibility(View.INVISIBLE);
                                gerarAtributos(txt1B,txt2B,txt3B,txt4B,txt5B,txt6B,txt7B,txt8B,txt9B,txt10B,txt11B,txt12B,txt13B);
                            }
                        },100);
                    }
                });
            }//Botão 2
            {
                btnRollC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(animation);
                        view.postOnAnimationDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnRollC.setVisibility(View.INVISIBLE);
                                gerarAtributos(txt1C,txt2C,txt3C,txt4C,txt5C,txt6C,txt7C,txt8C,txt9C,txt10C,txt11C,txt12C,txt13C);
                            }
                        },100);
                    }
                });
            }//Botão 3
            {
                btnRollD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(animation);
                        view.postOnAnimationDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnRollD.setVisibility(View.INVISIBLE);
                                gerarAtributos(txt1D,txt2D,txt3D,txt4D,txt5D,txt6D,txt7D,txt8D,txt9D,txt10D,txt11D,txt12D,txt13D);
                            }
                        },100);
                    }
                });
            }//Botão 4
            {
                btnRollE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(animation);
                        view.postOnAnimationDelayed(new Runnable() {
                            @Override
                            public void run() {
                                btnRollE.setVisibility(View.INVISIBLE);
                                gerarAtributos(txt1E,txt2E,txt3E,txt4E,txt5E,txt6E,txt7E,txt8E,txt9E,txt10E,txt11E,txt12E,txt13E);
                            }
                        },100);
                    }
                });
            }//Botão 5
            {
                btnRollF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.startAnimation(animation);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnRollF.setVisibility(View.INVISIBLE);
                            gerarAtributos(txt1F,txt2F,txt3F,txt4F,txt5F,txt6F,txt7F,txt8F,txt9F,txt10F,txt11F,txt12F,txt13F);
                        }
                    },100);
                }
                });
            }//Botão 6
        }//Botões
        spn1A.setSelection(0);
        spn1B.setSelection(1);
        spn1C.setSelection(2);
        spn1D.setSelection(3);
        spn1E.setSelection(4);
        spn1F.setSelection(5);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(animation2);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (spn1A.getSelectedItemPosition() == spn1B.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1C.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1D.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1F.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1C.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1D.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1F.getSelectedItemPosition() || spn1C.getSelectedItemPosition() == spn1D.getSelectedItemPosition() || spn1C.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1C.getSelectedItemPosition() == spn1F.getSelectedItemPosition() || spn1D.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1D.getSelectedItemPosition() == spn1F.getSelectedItemPosition() || spn1E.getSelectedItemPosition() == spn1F.getSelectedItemPosition()){
                            Toast.makeText(getBaseContext(), "Atributos repetidos!", Toast.LENGTH_SHORT).show();
                        }else if(txt9A.getText().toString().equals(" ")||txt9B.getText().toString().equals(" ")||txt9C.getText().toString().equals(" ")||txt9D.getText().toString().equals(" ")||txt9E.getText().toString().equals(" ")||txt9F.getText().toString().equals(" ")){
                            Toast.makeText(getBaseContext(), "Pra que a pressa amigo?\nVocê ainda nem definiu seus atributos", Toast.LENGTH_SHORT).show();
                        }else{
                            Atributo atributo = new Atributo();
                            {
                                if (spn1A.getSelectedItemPosition() == 0) {
                                    atributo.setForca(txt9A.getText().toString());
                                } else if (spn1A.getSelectedItemPosition() == 1) {
                                    atributo.setDestreza(txt9A.getText().toString());
                                } else if (spn1A.getSelectedItemPosition() == 2) {
                                    atributo.setConstituicao(txt9A.getText().toString());
                                } else if (spn1A.getSelectedItemPosition() == 3) {
                                    atributo.setInteligencia(txt9A.getText().toString());
                                } else if (spn1A.getSelectedItemPosition() == 4) {
                                    atributo.setSabedoria(txt9A.getText().toString());
                                } else if (spn1A.getSelectedItemPosition() == 5) {
                                    atributo.setCarisma(txt9A.getText().toString());
                                }
                            }
                            {
                                if (spn1B.getSelectedItemPosition() == 0) {
                                    atributo.setForca(txt9B.getText().toString());
                                } else if (spn1B.getSelectedItemPosition() == 1) {
                                    atributo.setDestreza(txt9B.getText().toString());
                                } else if (spn1B.getSelectedItemPosition() == 2) {
                                    atributo.setConstituicao(txt9B.getText().toString());
                                } else if (spn1B.getSelectedItemPosition() == 3) {
                                    atributo.setInteligencia(txt9B.getText().toString());
                                } else if (spn1B.getSelectedItemPosition() == 4) {
                                    atributo.setSabedoria(txt9B.getText().toString());
                                } else if (spn1B.getSelectedItemPosition() == 5) {
                                    atributo.setCarisma(txt9B.getText().toString());
                                }
                            }
                            {
                                if (spn1C.getSelectedItemPosition() == 0) {
                                    atributo.setForca(txt9C.getText().toString());
                                } else if (spn1C.getSelectedItemPosition() == 1) {
                                    atributo.setDestreza(txt9C.getText().toString());
                                } else if (spn1C.getSelectedItemPosition() == 2) {
                                    atributo.setConstituicao(txt9C.getText().toString());
                                } else if (spn1C.getSelectedItemPosition() == 3) {
                                    atributo.setInteligencia(txt9C.getText().toString());
                                } else if (spn1C.getSelectedItemPosition() == 4) {
                                    atributo.setSabedoria(txt9C.getText().toString());
                                } else if (spn1C.getSelectedItemPosition() == 5) {
                                    atributo.setCarisma(txt9C.getText().toString());
                                }
                            }
                            {
                                if (spn1D.getSelectedItemPosition() == 0) {
                                    atributo.setForca(txt9D.getText().toString());
                                } else if (spn1D.getSelectedItemPosition() == 1) {
                                    atributo.setDestreza(txt9D.getText().toString());
                                } else if (spn1D.getSelectedItemPosition() == 2) {
                                    atributo.setConstituicao(txt9D.getText().toString());
                                } else if (spn1D.getSelectedItemPosition() == 3) {
                                    atributo.setInteligencia(txt9D.getText().toString());
                                } else if (spn1D.getSelectedItemPosition() == 4) {
                                    atributo.setSabedoria(txt9D.getText().toString());
                                } else if (spn1D.getSelectedItemPosition() == 5) {
                                    atributo.setCarisma(txt9D.getText().toString());
                                }
                            }
                            {
                                if (spn1E.getSelectedItemPosition() == 0) {
                                    atributo.setForca(txt9E.getText().toString());
                                } else if (spn1E.getSelectedItemPosition() == 1) {
                                    atributo.setDestreza(txt9E.getText().toString());
                                } else if (spn1E.getSelectedItemPosition() == 2) {
                                    atributo.setConstituicao(txt9E.getText().toString());
                                } else if (spn1E.getSelectedItemPosition() == 3) {
                                    atributo.setInteligencia(txt9E.getText().toString());
                                } else if (spn1E.getSelectedItemPosition() == 4) {
                                    atributo.setSabedoria(txt9E.getText().toString());
                                } else if (spn1E.getSelectedItemPosition() == 5) {
                                    atributo.setCarisma(txt9E.getText().toString());
                                }
                            }
                            {
                                if (spn1F.getSelectedItemPosition() == 0) {
                                    atributo.setForca(txt9F.getText().toString());
                                } else if (spn1F.getSelectedItemPosition() == 1) {
                                    atributo.setDestreza(txt9F.getText().toString());
                                } else if (spn1F.getSelectedItemPosition() == 2) {
                                    atributo.setConstituicao(txt9F.getText().toString());
                                } else if (spn1F.getSelectedItemPosition() == 3) {
                                    atributo.setInteligencia(txt9F.getText().toString());
                                } else if (spn1F.getSelectedItemPosition() == 4) {
                                    atributo.setSabedoria(txt9F.getText().toString());
                                } else if (spn1F.getSelectedItemPosition() == 5) {
                                    atributo.setCarisma(txt9F.getText().toString());
                                }
                            }
                            ficha.setAtributo(atributo);
                            Intent intent = new Intent(getApplicationContext(), VidaV.class);
                            intent.putExtra("Ficha",ficha);
                            startActivity(intent);
                            finish();
                        }
                    }
                },50);
            }
        });

        }
        public void gerarAtributos(final TextView txt1, final TextView txt2, final TextView txt3, final TextView txt4, final TextView txt5, final TextView txt6, final TextView txt7, final TextView txt8, final TextView txt9, final TextView txt10, final TextView txt11, final TextView txt12, final TextView txt13){
            new CountDownTimer(500, 50) {
                public void onFinish() {
                    final int i1 = r.nextInt(6) + 1;
                    txt1.setText(Integer.toString(i1));
                    txt2.setText("+");
                    new CountDownTimer(500, 50) {
                        public void onFinish() {
                            final int i2 = r.nextInt(6) + 1;
                            txt3.setText(Integer.toString(i2));
                            txt4.setText("+");
                            new CountDownTimer(500, 50) {
                                public void onFinish() {
                                    final int i3 = r.nextInt(6) + 1;
                                    txt5.setText(Integer.toString(i3));
                                    txt6.setText("+");
                                    new CountDownTimer(500, 50) {
                                        public void onFinish() {
                                            final int i4 = r.nextInt(6) + 1;
                                            txt7.setText(Integer.toString(i4));
                                            txt8.setText("=");
                                            List<Integer> list = Arrays.asList(i1, i2, i3, i4);
                                            int min = Collections.min(list);
                                            int soma = (i1 + i2 + i3 + i4) - min;
                                            txt9.setText(Integer.toString(soma));
                                            if (min == i1) {
                                                txt10.setText("/");
                                            } else if (min == i2) {
                                                txt11.setText("/");
                                            } else if (min == i3) {
                                                txt12.setText("/");
                                            } else if (min == i4) {
                                                txt13.setText("/");
                                            }
                                        }

                                        public void onTick(long millisUntilFinished) {
                                            txt7.setText(Integer.toString(r.nextInt(6) + 1));
                                        }
                                    }.start();
                                }

                                public void onTick(long millisUntilFinished) {
                                    txt5.setText(Integer.toString(r.nextInt(6) + 1));
                                }
                            }.start();
                        }

                        public void onTick(long millisUntilFinished) {
                            txt3.setText(Integer.toString(r.nextInt(6) + 1));
                        }
                    }.start();
                }

                public void onTick(long millisUntilFinished) {
                    txt1.setText(Integer.toString(r.nextInt(6) + 1));
                }
            }.start();
        }
}