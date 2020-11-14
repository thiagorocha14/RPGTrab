package com.example.rpg.Atributos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpg.BD;
import com.example.rpg.Ficha;
import com.example.rpg.R;
import com.example.rpg.VidaV;

public class Atribut2 extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_atribut2);
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final ProgressBar prg, prgA,prgB,prgC,prgD,prgE;
        final Integer[] total = {20};
        Button btn1, btn2, btn1A, btn2A,btn1B, btn2B,btn1C, btn2C,btn1D, btn2D,btn1E, btn2E,btnFinish;
        final TextView txttotal, txt1, txt1A, txt1B, txt1C, txt1D, txt1E;
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
                public void onClick(View view) {
                    if (prg.getProgress() == 7) {

                    } else {
                        if (prg.getProgress() + 1 == 15 || prg.getProgress() + 1 == 16) {
                            total[0] = total[0] + 2;
                            txttotal.setText(Integer.toString(total[0]));
                        } else if (prg.getProgress() + 1 == 17 || prg.getProgress() + 1 == 18) {
                            total[0] = total[0] + 3;
                            txttotal.setText(Integer.toString(total[0]));
                        } else {
                            total[0]++;
                            txttotal.setText(Integer.toString(total[0]));
                        }
                        prg.incrementProgressBy(-1);
                        txt1.setText(Integer.toString(prg.getProgress() + 1));
                    }
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (total[0] == 0) {

                    } else {
                        if (prg.getProgress() == 17) {

                        } else {
                            if (prg.getProgress() + 1 == 14 || prg.getProgress() + 1 == 15) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 2;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prg.incrementProgressBy(+1);
                                    txt1.setText(Integer.toString(prg.getProgress() + 1));
                                }
                            } else if (prg.getProgress() + 1 == 16 || prg.getProgress() + 1 == 17) {
                                if (total[0] < 3) {

                                } else {
                                    total[0] = total[0] - 3;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prg.incrementProgressBy(+1);
                                    txt1.setText(Integer.toString(prg.getProgress() + 1));
                                }
                            } else {
                                total[0]--;
                                txttotal.setText(Integer.toString(total[0]));
                                prg.incrementProgressBy(+1);
                                txt1.setText(Integer.toString(prg.getProgress() + 1));
                            }
                        }
                    }
                }
            });
        }
        {
            btn1A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prgA.getProgress() == 7) {

                    } else {
                        if (prgA.getProgress() + 1 == 15 || prgA.getProgress() + 1 == 16) {
                            total[0] = total[0] + 2;
                            txttotal.setText(Integer.toString(total[0]));
                        } else if (prgA.getProgress() + 1 == 17 || prgA.getProgress() + 1 == 18) {
                            total[0] = total[0] + 3;
                            txttotal.setText(Integer.toString(total[0]));
                        } else {
                            total[0]++;
                            txttotal.setText(Integer.toString(total[0]));
                        }
                        prgA.incrementProgressBy(-1);
                        txt1A.setText(Integer.toString(prgA.getProgress() + 1));
                    }
                }
            });
            btn2A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (total[0] == 0) {

                    } else {
                        if (prgA.getProgress() == 17) {

                        } else {
                            if (prgA.getProgress() + 1 == 14 || prgA.getProgress() + 1 == 15) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 2;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgA.incrementProgressBy(+1);
                                    txt1A.setText(Integer.toString(prgA.getProgress() + 1));
                                }
                            } else if (prgA.getProgress() + 1 == 16 || prgA.getProgress() + 1 == 17) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 3;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgA.incrementProgressBy(+1);
                                    txt1A.setText(Integer.toString(prgA.getProgress() + 1));
                                }
                            } else {
                                total[0]--;
                                txttotal.setText(Integer.toString(total[0]));
                                prgA.incrementProgressBy(+1);
                                txt1A.setText(Integer.toString(prgA.getProgress() + 1));
                            }
                        }
                    }
                }
            });
        }
        {
            btn1B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prgB.getProgress() == 7) {

                    } else {
                        if (prgB.getProgress() + 1 == 15 || prgB.getProgress() + 1 == 16) {
                            total[0] = total[0] + 2;
                            txttotal.setText(Integer.toString(total[0]));
                        } else if (prgB.getProgress() + 1 == 17 || prgB.getProgress() + 1 == 18) {
                            total[0] = total[0] + 3;
                            txttotal.setText(Integer.toString(total[0]));
                        } else {
                            total[0]++;
                            txttotal.setText(Integer.toString(total[0]));
                        }
                        prgB.incrementProgressBy(-1);
                        txt1B.setText(Integer.toString(prgB.getProgress() + 1));
                    }
                }
            });
            btn2B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (total[0] == 0) {

                    } else {
                        if (prgB.getProgress() == 17) {

                        } else {
                            if (prgB.getProgress() + 1 == 14 || prgB.getProgress() + 1 == 15) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 2;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgB.incrementProgressBy(+1);
                                    txt1B.setText(Integer.toString(prgB.getProgress() + 1));
                                }
                            } else if (prgB.getProgress() + 1 == 16 || prgB.getProgress() + 1 == 17) {
                                if (total[0] < 3) {

                                } else {
                                    total[0] = total[0] - 3;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgB.incrementProgressBy(+1);
                                    txt1B.setText(Integer.toString(prgB.getProgress() + 1));
                                }
                            } else {
                                total[0]--;
                                txttotal.setText(Integer.toString(total[0]));
                                prgB.incrementProgressBy(+1);
                                txt1B.setText(Integer.toString(prgB.getProgress() + 1));
                            }
                        }
                    }
                }
            });
        }
        {
            btn1C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prgC.getProgress() == 7) {

                    } else {
                        if (prgC.getProgress() + 1 == 15 || prgC.getProgress() + 1 == 16) {
                            total[0] = total[0] + 2;
                            txttotal.setText(Integer.toString(total[0]));
                        } else if (prgC.getProgress() + 1 == 17 || prgC.getProgress() + 1 == 18) {
                            total[0] = total[0] + 3;
                            txttotal.setText(Integer.toString(total[0]));
                        } else {
                            total[0]++;
                            txttotal.setText(Integer.toString(total[0]));
                        }
                        prgC.incrementProgressBy(-1);
                        txt1C.setText(Integer.toString(prgC.getProgress() + 1));
                    }
                }
            });
            btn2C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (total[0] == 0) {

                    } else {
                        if (prgC.getProgress() == 17) {

                        } else {
                            if (prgC.getProgress() + 1 == 14 || prgC.getProgress() + 1 == 15) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 2;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgC.incrementProgressBy(+1);
                                    txt1C.setText(Integer.toString(prgC.getProgress() + 1));
                                }
                            } else if (prgC.getProgress() + 1 == 16 || prgC.getProgress() + 1 == 17) {
                                if (total[0] < 3) {

                                } else {
                                    total[0] = total[0] - 3;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgC.incrementProgressBy(+1);
                                    txt1C.setText(Integer.toString(prgC.getProgress() + 1));
                                }
                            } else {
                                total[0]--;
                                txttotal.setText(Integer.toString(total[0]));
                                prgC.incrementProgressBy(+1);
                                txt1C.setText(Integer.toString(prgC.getProgress() + 1));
                            }
                        }
                    }
                }
            });
        }
        {
            btn1D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prgD.getProgress() == 7) {

                    } else {
                        if (prgD.getProgress() + 1 == 15 || prgD.getProgress() + 1 == 16) {
                            total[0] = total[0] + 2;
                            txttotal.setText(Integer.toString(total[0]));
                        } else if (prgD.getProgress() + 1 == 17 || prgD.getProgress() + 1 == 18) {
                            total[0] = total[0] + 3;
                            txttotal.setText(Integer.toString(total[0]));
                        } else {
                            total[0]++;
                            txttotal.setText(Integer.toString(total[0]));
                        }
                        prgD.incrementProgressBy(-1);
                        txt1D.setText(Integer.toString(prgD.getProgress() + 1));
                    }
                }
            });
            btn2D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (total[0] == 0) {

                    } else {
                        if (prgD.getProgress() == 17) {

                        } else {
                            if (prgD.getProgress() + 1 == 14 || prgD.getProgress() + 1 == 15) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 2;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgD.incrementProgressBy(+1);
                                    txt1D.setText(Integer.toString(prgD.getProgress() + 1));
                                }
                            } else if (prgD.getProgress() + 1 == 16 || prgD.getProgress() + 1 == 17) {
                                if (total[0] < 3) {

                                } else {
                                    total[0] = total[0] - 3;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgD.incrementProgressBy(+1);
                                    txt1D.setText(Integer.toString(prgD.getProgress() + 1));
                                }
                            } else {
                                total[0]--;
                                txttotal.setText(Integer.toString(total[0]));
                                prgD.incrementProgressBy(+1);
                                txt1D.setText(Integer.toString(prgD.getProgress() + 1));
                            }
                        }
                    }
                }
            });
        }
        {
            btn1E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (prgE.getProgress() == 7) {

                    } else {
                        if (prgE.getProgress() + 1 == 15 || prgE.getProgress() + 1 == 16) {
                            total[0] = total[0] + 2;
                            txttotal.setText(Integer.toString(total[0]));
                        } else if (prgE.getProgress() + 1 == 17 || prgE.getProgress() + 1 == 18) {
                            total[0] = total[0] + 3;
                            txttotal.setText(Integer.toString(total[0]));
                        } else {
                            total[0]++;
                            txttotal.setText(Integer.toString(total[0]));
                        }
                        prgE.incrementProgressBy(-1);
                        txt1E.setText(Integer.toString(prgE.getProgress() + 1));
                    }
                }
            });
            btn2E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (total[0] == 0) {

                    } else {
                        if (prgE.getProgress() == 17) {

                        } else {
                            if (prgE.getProgress() + 1 == 14 || prgE.getProgress() + 1 == 15) {
                                if (total[0] < 2) {

                                } else {
                                    total[0] = total[0] - 2;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgE.incrementProgressBy(+1);
                                    txt1E.setText(Integer.toString(prgE.getProgress() + 1));
                                }
                            } else if (prgE.getProgress() + 1 == 16 || prgE.getProgress() + 1 == 17) {
                                if (total[0] < 3) {

                                } else {
                                    total[0] = total[0] - 3;
                                    txttotal.setText(Integer.toString(total[0]));
                                    prgE.incrementProgressBy(+1);
                                    txt1E.setText(Integer.toString(prgE.getProgress() + 1));
                                }
                            } else {
                                total[0]--;
                                txttotal.setText(Integer.toString(total[0]));
                                prgE.incrementProgressBy(+1);
                                txt1E.setText(Integer.toString(prgE.getProgress() + 1));
                            }
                        }
                    }
                }
            });
        }
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    Intent intent = new Intent(getApplicationContext(), VidaV.class);
                    intent.putExtra("Ficha",ficha);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}