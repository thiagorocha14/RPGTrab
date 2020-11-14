package com.example.rpg.Atributos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpg.BD;
import com.example.rpg.Ficha;
import com.example.rpg.R;
import com.example.rpg.VidaV;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Atribut1 extends AppCompatActivity {
    Spinner spn1,spn1A,spn1B,spn1C,spn1D,spn1E;
    Integer total,dado;
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
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final TextView txtA1, txtA2, txtA3, txtA4, txtA5, txtC1, txtC2, txtC3, txtC4, txtA1A, txtA2A, txtA3A, txtA4A, txtA5A, txtC1A, txtC2A, txtC3A, txtC4A,
                txtA1B, txtA2B, txtA3B, txtA4B, txtA5B, txtC1B, txtC2B, txtC3B, txtC4B,txtA1C, txtA2C, txtA3C, txtA4C, txtA5C, txtC1C, txtC2C, txtC3C, txtC4C,
                txtA1D, txtA2D, txtA3D, txtA4D, txtA5D, txtC1D, txtC2D, txtC3D, txtC4D,txtA1E, txtA2E, txtA3E, txtA4E, txtA5E, txtC1E, txtC2E, txtC3E, txtC4E,
                txtB1,txtB2,txtB3,txtB4,txtB1A,txtB2A,txtB3A,txtB4A,txtB1B,txtB2B,txtB3B,txtB4B,txtB1C,txtB2C,txtB3C,txtB4C,txtB1D,txtB2D,txtB3D,txtB4D,txtB1E,txtB2E,txtB3E,txtB4E;
        final Button btntest,btntestA,btntestB,btntestC,btntestD,btntestE;
        Button btnFinish;
        btnFinish = findViewById(R.id.btnFinish);
        {
            spn1 = findViewById(R.id.spn1);
            btntest = findViewById(R.id.btnTest);
            txtA1 = findViewById(R.id.txtA1);
            txtA2 = findViewById(R.id.txtA2);
            txtA3 = findViewById(R.id.txtA3);
            txtA4 = findViewById(R.id.txtA4);
            txtA5 = findViewById(R.id.txtA5);
            txtC1 = findViewById(R.id.txtC1);
            txtC2 = findViewById(R.id.txtC2);
            txtC3 = findViewById(R.id.txtC3);
            txtC4 = findViewById(R.id.txtC4);
            txtB1 = findViewById(R.id.txtB1);
            txtB2 = findViewById(R.id.txtB2);
            txtB3 = findViewById(R.id.txtB3);
            txtB4 = findViewById(R.id.txtB4);
        }//Declaração 1
        {
            spn1A = findViewById(R.id.spn1A);
            btntestA = findViewById(R.id.btnTestA);
            txtA1A = findViewById(R.id.txtA1A);
            txtA2A = findViewById(R.id.txtA2A);
            txtA3A = findViewById(R.id.txtA3A);
            txtA4A = findViewById(R.id.txtA4A);
            txtA5A = findViewById(R.id.txtA5A);
            txtC1A = findViewById(R.id.txtC1A);
            txtC2A = findViewById(R.id.txtC2A);
            txtC3A = findViewById(R.id.txtC3A);
            txtC4A = findViewById(R.id.txtC4A);
            txtB1A = findViewById(R.id.txtB1A);
            txtB2A = findViewById(R.id.txtB2A);
            txtB3A = findViewById(R.id.txtB3A);
            txtB4A = findViewById(R.id.txtB4A);
        }//Declaração 2
        {
            spn1B = findViewById(R.id.spn1B);
            btntestB = findViewById(R.id.btnTestB);
            txtA1B = findViewById(R.id.txtA1B);
            txtA2B = findViewById(R.id.txtA2B);
            txtA3B = findViewById(R.id.txtA3B);
            txtA4B = findViewById(R.id.txtA4B);
            txtA5B = findViewById(R.id.txtA5B);
            txtC1B = findViewById(R.id.txtC1B);
            txtC2B = findViewById(R.id.txtC2B);
            txtC3B = findViewById(R.id.txtC3B);
            txtC4B = findViewById(R.id.txtC4B);
            txtB1B = findViewById(R.id.txtB1B);
            txtB2B = findViewById(R.id.txtB2B);
            txtB3B = findViewById(R.id.txtB3B);
            txtB4B = findViewById(R.id.txtB4B);
        }//Declaração 3
        {
            spn1C = findViewById(R.id.spn1C);
            btntestC = findViewById(R.id.btnTestC);
            txtA1C = findViewById(R.id.txtA1C);
            txtA2C = findViewById(R.id.txtA2C);
            txtA3C = findViewById(R.id.txtA3C);
            txtA4C = findViewById(R.id.txtA4C);
            txtA5C = findViewById(R.id.txtA5C);
            txtC1C = findViewById(R.id.txtC1C);
            txtC2C = findViewById(R.id.txtC2C);
            txtC3C = findViewById(R.id.txtC3C);
            txtC4C = findViewById(R.id.txtC4C);
            txtB1C = findViewById(R.id.txtB1C);
            txtB2C = findViewById(R.id.txtB2C);
            txtB3C = findViewById(R.id.txtB3C);
            txtB4C = findViewById(R.id.txtB4C);
        }//Declaração 4
        {
            spn1D = findViewById(R.id.spn1D);
            btntestD = findViewById(R.id.btnTestD);
            txtA1D = findViewById(R.id.txtA1D);
            txtA2D = findViewById(R.id.txtA2D);
            txtA3D = findViewById(R.id.txtA3D);
            txtA4D = findViewById(R.id.txtA4D);
            txtA5D = findViewById(R.id.txtA5D);
            txtC1D = findViewById(R.id.txtC1D);
            txtC2D = findViewById(R.id.txtC2D);
            txtC3D = findViewById(R.id.txtC3D);
            txtC4D = findViewById(R.id.txtC4D);
            txtB1D = findViewById(R.id.txtB1D);
            txtB2D = findViewById(R.id.txtB2D);
            txtB3D = findViewById(R.id.txtB3D);
            txtB4D = findViewById(R.id.txtB4D);
        }//Declaração 5
        {
            spn1E = findViewById(R.id.spn1E);
            btntestE = findViewById(R.id.btnTestE);
            txtA1E = findViewById(R.id.txtA1E);
            txtA2E = findViewById(R.id.txtA2E);
            txtA3E = findViewById(R.id.txtA3E);
            txtA4E = findViewById(R.id.txtA4E);
            txtA5E = findViewById(R.id.txtA5E);
            txtC1E = findViewById(R.id.txtC1E);
            txtC2E = findViewById(R.id.txtC2E);
            txtC3E = findViewById(R.id.txtC3E);
            txtC4E = findViewById(R.id.txtC4E);
            txtB1E = findViewById(R.id.txtB1E);
            txtB2E = findViewById(R.id.txtB2E);
            txtB3E = findViewById(R.id.txtB3E);
            txtB4E = findViewById(R.id.txtB4E);
        }//Declaração 6
        {
            {
                btntest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btntest.setVisibility(View.INVISIBLE);
                        gerarAtributos(txtA1,txtB1,txtA2,txtB2,txtA3,txtB3,txtA4,txtB4,txtA5,txtC1,txtC2,txtC3,txtC4);
                    }
                });
            }//Botão 1
            {
                btntestA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btntestA.setVisibility(View.INVISIBLE);
                        gerarAtributos(txtA1A,txtB1A,txtA2A,txtB2A,txtA3A,txtB3A,txtA4A,txtB4A,txtA5A,txtC1A,txtC2A,txtC3A,txtC4A);
                    }
                });
            }//Botão 2
            {
                btntestB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btntestB.setVisibility(View.INVISIBLE);
                        gerarAtributos(txtA1B,txtB1B,txtA2B,txtB2B,txtA3B,txtB3B,txtA4B,txtB4B,txtA5B,txtC1B,txtC2B,txtC3B,txtC4B);
                    }
                });
            }//Botão 3
            {
                btntestC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btntestC.setVisibility(View.INVISIBLE);
                        gerarAtributos(txtA1C,txtB1C,txtA2C,txtB2C,txtA3C,txtB3C,txtA4C,txtB4C,txtA5C,txtC1C,txtC2C,txtC3C,txtC4C);
                    }
                });
            }//Botão 4
            {
                btntestD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btntestD.setVisibility(View.INVISIBLE);
                        gerarAtributos(txtA1D,txtB1D,txtA2D,txtB2D,txtA3D,txtB3D,txtA4D,txtB4D,txtA5D,txtC1D,txtC2D,txtC3D,txtC4D);
                    }
                });
            }//Botão 5
            {
            btntestE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btntestE.setVisibility(View.INVISIBLE);
                    gerarAtributos(txtA1E,txtB1E,txtA2E,txtB2E,txtA3E,txtB3E,txtA4E,txtB4E,txtA5E,txtC1E,txtC2E,txtC3E,txtC4E);
                }
            });
            }//Botão 6
        }//Botões
        spn1.setSelection(0);
        spn1A.setSelection(1);
        spn1B.setSelection(2);
        spn1C.setSelection(3);
        spn1D.setSelection(4);
        spn1E.setSelection(5);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spn1.getSelectedItemPosition() == spn1A.getSelectedItemPosition() || spn1.getSelectedItemPosition() == spn1B.getSelectedItemPosition() ||spn1.getSelectedItemPosition() == spn1C.getSelectedItemPosition() ||spn1.getSelectedItemPosition() == spn1D.getSelectedItemPosition() ||spn1.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1B.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1C.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1D.getSelectedItemPosition() || spn1A.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1C.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1D.getSelectedItemPosition() || spn1B.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1C.getSelectedItemPosition() == spn1D.getSelectedItemPosition() || spn1C.getSelectedItemPosition() == spn1E.getSelectedItemPosition() || spn1D.getSelectedItemPosition() == spn1E.getSelectedItemPosition()){
                    Toast.makeText(getBaseContext(), "Atributos repetidos!", Toast.LENGTH_SHORT).show();
                }else if(txtA5.getText().toString().equals(" ")||txtA5A.getText().toString().equals(" ")||txtA5B.getText().toString().equals(" ")||txtA5C.getText().toString().equals(" ")||txtA5D.getText().toString().equals(" ")||txtA5E.getText().toString().equals(" ")){
                    Toast.makeText(getBaseContext(), "Pra que a pressa amigo?\nVocê ainda nem definiu seus atributos", Toast.LENGTH_SHORT).show();
                }else{
                    Atributo atributo = new Atributo();
                    {
                        if (spn1.getSelectedItemPosition() == 0) {
                            atributo.setForca(txtA5.getText().toString());
                        } else if (spn1.getSelectedItemPosition() == 1) {
                            atributo.setDestreza(txtA5.getText().toString());
                        } else if (spn1.getSelectedItemPosition() == 2) {
                            atributo.setConstituicao(txtA5.getText().toString());
                        } else if (spn1.getSelectedItemPosition() == 3) {
                            atributo.setInteligencia(txtA5.getText().toString());
                        } else if (spn1.getSelectedItemPosition() == 4) {
                            atributo.setSabedoria(txtA5.getText().toString());
                        } else if (spn1.getSelectedItemPosition() == 5) {
                            atributo.setCarisma(txtA5.getText().toString());
                        }
                    }
                    {
                        if (spn1A.getSelectedItemPosition() == 0) {
                            atributo.setForca(txtA5A.getText().toString());
                        } else if (spn1A.getSelectedItemPosition() == 1) {
                            atributo.setDestreza(txtA5A.getText().toString());
                        } else if (spn1A.getSelectedItemPosition() == 2) {
                            atributo.setConstituicao(txtA5A.getText().toString());
                        } else if (spn1A.getSelectedItemPosition() == 3) {
                            atributo.setInteligencia(txtA5A.getText().toString());
                        } else if (spn1A.getSelectedItemPosition() == 4) {
                            atributo.setSabedoria(txtA5A.getText().toString());
                        } else if (spn1A.getSelectedItemPosition() == 5) {
                            atributo.setCarisma(txtA5A.getText().toString());
                        }
                    }
                    {
                        if (spn1B.getSelectedItemPosition() == 0) {
                            atributo.setForca(txtA5B.getText().toString());
                        } else if (spn1B.getSelectedItemPosition() == 1) {
                            atributo.setDestreza(txtA5B.getText().toString());
                        } else if (spn1B.getSelectedItemPosition() == 2) {
                            atributo.setConstituicao(txtA5B.getText().toString());
                        } else if (spn1B.getSelectedItemPosition() == 3) {
                            atributo.setInteligencia(txtA5B.getText().toString());
                        } else if (spn1B.getSelectedItemPosition() == 4) {
                            atributo.setSabedoria(txtA5B.getText().toString());
                        } else if (spn1B.getSelectedItemPosition() == 5) {
                            atributo.setCarisma(txtA5B.getText().toString());
                        }
                    }
                    {
                        if (spn1C.getSelectedItemPosition() == 0) {
                            atributo.setForca(txtA5C.getText().toString());
                        } else if (spn1C.getSelectedItemPosition() == 1) {
                            atributo.setDestreza(txtA5C.getText().toString());
                        } else if (spn1C.getSelectedItemPosition() == 2) {
                            atributo.setConstituicao(txtA5C.getText().toString());
                        } else if (spn1C.getSelectedItemPosition() == 3) {
                            atributo.setInteligencia(txtA5C.getText().toString());
                        } else if (spn1C.getSelectedItemPosition() == 4) {
                            atributo.setSabedoria(txtA5C.getText().toString());
                        } else if (spn1C.getSelectedItemPosition() == 5) {
                            atributo.setCarisma(txtA5C.getText().toString());
                        }
                    }
                    {
                        if (spn1D.getSelectedItemPosition() == 0) {
                            atributo.setForca(txtA5D.getText().toString());
                        } else if (spn1D.getSelectedItemPosition() == 1) {
                            atributo.setDestreza(txtA5D.getText().toString());
                        } else if (spn1D.getSelectedItemPosition() == 2) {
                            atributo.setConstituicao(txtA5D.getText().toString());
                        } else if (spn1D.getSelectedItemPosition() == 3) {
                            atributo.setInteligencia(txtA5D.getText().toString());
                        } else if (spn1D.getSelectedItemPosition() == 4) {
                            atributo.setSabedoria(txtA5D.getText().toString());
                        } else if (spn1D.getSelectedItemPosition() == 5) {
                            atributo.setCarisma(txtA5D.getText().toString());
                        }
                    }
                    {
                        if (spn1E.getSelectedItemPosition() == 0) {
                            atributo.setForca(txtA5E.getText().toString());
                        } else if (spn1E.getSelectedItemPosition() == 1) {
                            atributo.setDestreza(txtA5E.getText().toString());
                        } else if (spn1E.getSelectedItemPosition() == 2) {
                            atributo.setConstituicao(txtA5E.getText().toString());
                        } else if (spn1E.getSelectedItemPosition() == 3) {
                            atributo.setInteligencia(txtA5E.getText().toString());
                        } else if (spn1E.getSelectedItemPosition() == 4) {
                            atributo.setSabedoria(txtA5E.getText().toString());
                        } else if (spn1E.getSelectedItemPosition() == 5) {
                            atributo.setCarisma(txtA5E.getText().toString());
                        }
                    }
                    ficha.setAtributo(atributo);
                    Intent intent = new Intent(getApplicationContext(), VidaV.class);
                    intent.putExtra("Ficha",ficha);
                    startActivity(intent);
                    finish();
                }
            }
        });

        }
        public void gerarAtributos(final TextView txt1, final TextView txt2, final TextView txt3, final TextView txt4, final TextView txt5, final TextView txt6, final TextView txt7, final TextView txt8, final TextView txt9, final TextView txt10, final TextView txt11, final TextView txt12, final TextView txt13){
            final String[] numero = new String[1];
            numero[0] = " ";
            new CountDownTimer(500, 50) {
                public void onFinish() {
                    final int i1 = r.nextInt(6) + 1;
                    numero[0] = i1+"+";
                    txt1.setText(numero[0]);
                    //txt2.setText("+");
                    new CountDownTimer(500, 50) {
                        public void onFinish() {
                            final int i2 = r.nextInt(6) + 1;
                            numero[0] = numero[0]+i2+"+";
                            txt1.setText(numero[0]);
                            //txt4.setText("+");
                            new CountDownTimer(500, 50) {
                                public void onFinish() {
                                    final int i3 = r.nextInt(6) + 1;
                                    numero[0] = numero[0]+i3+"+";
                                    txt1.setText(numero[0]);
                                    //txt6.setText("+");
                                    new CountDownTimer(500, 50) {
                                        public void onFinish() {
                                            final int i4 = r.nextInt(6) + 1;
                                            numero[0] = numero[0]+i4+"=";
                                            txt1.setText(numero[0]);
                                            //txt8.setText("=");
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
                                            final int i1 = r.nextInt(6) + 1;
                                            txt1.setText(numero[0]+i1);
                                        }
                                    }.start();
                                }

                                public void onTick(long millisUntilFinished) {
                                    final int i1 = r.nextInt(6) + 1;
                                    txt1.setText(numero[0]+i1);
                                }
                            }.start();
                        }

                        public void onTick(long millisUntilFinished) {
                            final int i1 = r.nextInt(6) + 1;
                            txt1.setText(numero[0]+i1);
                        }
                    }.start();
                }

                public void onTick(long millisUntilFinished) {
                    final int i1 = r.nextInt(6) + 1;
                    txt1.setText(numero[0]+i1);
                }
            }.start();
        }
}