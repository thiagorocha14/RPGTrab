package com.example.rpg.Criation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpg.Objects.Atributo;
import com.example.rpg.Objects.Classe;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;

public class Vida extends AppCompatActivity {
    Integer total,dado,For,Des,Con,Int,Sab,Car;
    String totalTot,base,mais,raca,addFor,addDes,addCon,addInt,addSab,addCar;
    final Integer[] cont = {0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_vida);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        final Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.implod);
        final TextView txtVida = findViewById(R.id.txtVida2);
        final TextView txtFor,txtDes,txtCon,txtInt,txtSab,txtCar,txtaddFor,txtaddDes,txtaddCon,txtaddInt,txtaddSab,txtaddCar,txtForF,txtDesF,txtConF,txtIntF,txtSabF,txtCarF,txtmodFor,txtmodDes,txtmodCon,txtmodInt,txtmodSab,txtmodCar;
        final Button btnaddFor,btnaddDes,btnaddCon,btnaddInt,btnaddSab,btnaddCar,btnDef,btnUlt;
        addFor = "0";
        addDes = "0";
        addCon = "0";
        addInt = "0";
        addSab = "0";
        addCar = "0";
        {
            txtFor = findViewById(R.id.txtFor1);
            txtDes = findViewById(R.id.txtDes1);
            txtCon = findViewById(R.id.txtCon1);
            txtInt = findViewById(R.id.txtInt1);
            txtSab = findViewById(R.id.txtSab1);
            txtCar = findViewById(R.id.txtCar1);
            txtForF = findViewById(R.id.txtForF);
            txtDesF = findViewById(R.id.txtDesF);
            txtConF = findViewById(R.id.txtConF);
            txtIntF = findViewById(R.id.txtIntF);
            txtSabF = findViewById(R.id.txtSabF);
            txtCarF = findViewById(R.id.txtCarF);
            txtmodFor = findViewById(R.id.txtmodFor);
            txtmodDes = findViewById(R.id.txtmodDes);
            txtmodCon = findViewById(R.id.txtmodCon);
            txtmodInt = findViewById(R.id.txtmodInt);
            txtmodSab = findViewById(R.id.txtmodSab);
            txtmodCar = findViewById(R.id.txtmodCar);
            txtaddFor = findViewById(R.id.txtaddFor);
            txtaddDes = findViewById(R.id.txtaddDes);
            txtaddCon = findViewById(R.id.txtaddCon);
            txtaddInt = findViewById(R.id.txtaddInt);
            txtaddSab = findViewById(R.id.txtaddSab);
            txtaddCar = findViewById(R.id.txtaddCar);
            btnaddFor = findViewById(R.id.btnaddFor);
            btnaddDes = findViewById(R.id.btnaddDes);
            btnaddCon = findViewById(R.id.btnaddCon);
            btnaddInt = findViewById(R.id.btnaddInt);
            btnaddSab = findViewById(R.id.btnaddSab);
            btnaddCar = findViewById(R.id.btnaddCar);
            btnDef = findViewById(R.id.btnDef);
            btnUlt = findViewById(R.id.btnUltimo);
            btnaddFor.setVisibility(View.INVISIBLE);
            btnaddDes.setVisibility(View.INVISIBLE);
            btnaddCon.setVisibility(View.INVISIBLE);
            btnaddInt.setVisibility(View.INVISIBLE);
            btnaddSab.setVisibility(View.INVISIBLE);
            btnaddCar.setVisibility(View.INVISIBLE);
        }
        final Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final Atributo atributo = ficha.getAtributo();
        raca = ficha.getRaca();
        {
        if (raca.equals("Humano")) {
            btnaddFor.setVisibility(View.VISIBLE);
            btnaddDes.setVisibility(View.VISIBLE);
            btnaddCon.setVisibility(View.VISIBLE);
            btnaddInt.setVisibility(View.VISIBLE);
            btnaddSab.setVisibility(View.VISIBLE);
            btnaddCar.setVisibility(View.VISIBLE);
        } else if (raca.equals("Anão")) {
            addCon = "+4";
            addSab = "+2";
            addDes = "-2";
        } else if (raca.equals("Dahllan")) {
            addSab = "+4";
            addDes = "+2";
            addInt = "-2";
        } else if (raca.equals("Elfo")) {
            addInt = "+4";
            addDes = "+2";
            addCon = "-2";
        } else if (raca.equals("Goblin")) {
            addDes = "+4";
            addInt = "+2";
            addCar = "-2";
        } else if (raca.equals("Lefou")) {
            btnaddFor.setVisibility(View.VISIBLE);
            btnaddDes.setVisibility(View.VISIBLE);
            btnaddCon.setVisibility(View.VISIBLE);
            btnaddInt.setVisibility(View.VISIBLE);
            btnaddSab.setVisibility(View.VISIBLE);
        } else if (raca.equals("Minotauro")) {
            addFor = "+4";
            addCon = "+2";
            addSab = "-2";
        } else if (raca.equals("Qareen")) {
            addCar = "+4";
            addInt = "+2";
            addSab = "-2";
        } else if (raca.equals("Golem")) {
            addFor = "+4";
            addCon = "+2";
            addCar = "-2";
        } else if (raca.equals("Hynne")) {
            addDes = "+4";
            addCar = "+2";
            addFor = "-2";
        } else if (raca.equals("Kliren")) {
            addInt = "+4";
            addCar = "+2";
            addFor = "-2";
        } else if (raca.equals("Medusa")) {
            addDes = "+4";
            addCar = "+2";
        } else if (raca.equals("Osteon")) {

        } else if (raca.equals("Sereia/Tristão")) {
            btnaddFor.setVisibility(View.VISIBLE);
            btnaddDes.setVisibility(View.VISIBLE);
            btnaddCon.setVisibility(View.VISIBLE);
            btnaddInt.setVisibility(View.VISIBLE);
            btnaddSab.setVisibility(View.VISIBLE);
            btnaddCar.setVisibility(View.VISIBLE);
        } else if (raca.equals("Sílfide")) {
            addCar = "+4";
            addDes = "+2";
            addFor = "-4";
        } else if (raca.equals("Suraggel")) {

        } else if (raca.equals("Trog")) {
            addCon = "+4";
            addFor = "+2";
            addInt = "-2";
        }
    }
        txtFor.setText(atributo.getForca());
        txtDes.setText(atributo.getDestreza());
        txtCon.setText(atributo.getConstituicao());
        txtInt.setText(atributo.getInteligencia());
        txtSab.setText(atributo.getSabedoria());
        txtCar.setText(atributo.getCarisma());
        if(addFor.equals("0")){txtaddFor.setVisibility(View.INVISIBLE);}
        if(addDes.equals("0")){txtaddDes.setVisibility(View.INVISIBLE);}
        if(addCon.equals("0")){txtaddCon.setVisibility(View.INVISIBLE);}
        if(addInt.equals("0")){txtaddInt.setVisibility(View.INVISIBLE);}
        if(addSab.equals("0")){txtaddSab.setVisibility(View.INVISIBLE);}
        if(addCar.equals("0")){txtaddCar.setVisibility(View.INVISIBLE);}
        if (raca.equals("Humano")||raca.equals("Lefou")||raca.equals("Osteon")||raca.equals("Sereia/Tristão")){
            btnDef.setVisibility(View.VISIBLE);
            txtForF.setText(atributo.getForca());
            txtDesF.setText(atributo.getDestreza());
            txtConF.setText(atributo.getConstituicao());
            txtIntF.setText(atributo.getInteligencia());
            txtSabF.setText(atributo.getSabedoria());
            txtCarF.setText(atributo.getCarisma());
            {
                {
                    String valorCon = atributo.getConstituicao();
                    int valCon = (int) Math.floor((Double.valueOf(valorCon) - 10) / 2);
                    if (valCon > 0) {
                        atributo.setModCon("+" + String.valueOf(valCon));
                    } else {
                        atributo.setModCon(String.valueOf(valCon));
                    }
                }
                {
                    String valorFor = atributo.getForca();
                    int val = (int) Math.floor((Double.valueOf(valorFor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModFor("+" + String.valueOf(val));
                    } else {
                        atributo.setModFor(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getDestreza();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModDes("+" + String.valueOf(val));
                    } else {
                        atributo.setModDes(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getCarisma();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModCar("+" + String.valueOf(val));
                    } else {
                        atributo.setModCar(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getSabedoria();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModSab("+" + String.valueOf(val));
                    } else {
                        atributo.setModSab(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getInteligencia();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModInt("+" + String.valueOf(val));
                    } else {
                        atributo.setModInt(String.valueOf(val));
                    }
                }
            }
            txtmodFor.setText(atributo.getModFor());
            txtmodDes.setText(atributo.getModDes());
            txtmodCon.setText(atributo.getModCon());
            txtmodInt.setText(atributo.getModInt());
            txtmodSab.setText(atributo.getModSab());
            txtmodCar.setText(atributo.getModCar());
            btnaddFor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation2);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(cont[0] == 2){
                                btnaddFor.setVisibility(View.INVISIBLE);
                                btnaddDes.setVisibility(View.INVISIBLE);
                                btnaddCon.setVisibility(View.INVISIBLE);
                                btnaddInt.setVisibility(View.INVISIBLE);
                                btnaddSab.setVisibility(View.INVISIBLE);
                                btnaddCar.setVisibility(View.INVISIBLE);
                                addFor = "+2";
                                txtaddFor.setText(addFor);
                                For = Integer.valueOf(atributo.getForca());
                                For = For+Integer.valueOf(addFor);
                                atributo.setForca(For.toString());
                                {
                                    String valorFor = atributo.getForca();
                                    int val = (int) Math.floor((Double.valueOf(valorFor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModFor("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModFor(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtForF.setText(atributo.getForca());
                                txtmodFor.setText(atributo.getModFor());
                                cont[0]++;
                            }else{
                                btnaddFor.setVisibility(View.INVISIBLE);
                                addFor = "+2";
                                txtaddFor.setText(addFor);
                                For = Integer.valueOf(atributo.getForca());
                                For = For+Integer.valueOf(addFor);
                                atributo.setForca(For.toString());
                                {
                                    String valorFor = atributo.getForca();
                                    int val = (int) Math.floor((Double.valueOf(valorFor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModFor("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModFor(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtForF.setText(atributo.getForca());
                                txtmodFor.setText(atributo.getModFor());
                                cont[0]++;
                            }
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btnaddDes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation2);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(cont[0] == 2){
                                btnaddFor.setVisibility(View.INVISIBLE);
                                btnaddDes.setVisibility(View.INVISIBLE);
                                btnaddCon.setVisibility(View.INVISIBLE);
                                btnaddInt.setVisibility(View.INVISIBLE);
                                btnaddSab.setVisibility(View.INVISIBLE);
                                btnaddCar.setVisibility(View.INVISIBLE);
                                addDes = "+2";
                                txtaddDes.setText(addDes);
                                Des = Integer.valueOf(atributo.getDestreza());
                                Des = Des+Integer.valueOf(addDes);
                                atributo.setDestreza(Des.toString());
                                {
                                    String valor = atributo.getDestreza();
                                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModDes("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModDes(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtDesF.setText(atributo.getDestreza());
                                txtmodDes.setText(atributo.getModDes());
                                cont[0]++;
                            }else{
                                btnaddDes.setVisibility(View.INVISIBLE);
                                addDes = "+2";
                                txtaddDes.setText(addDes);
                                Des = Integer.valueOf(atributo.getDestreza());
                                Des = Des+Integer.valueOf(addDes);
                                atributo.setDestreza(Des.toString());
                                {
                                    String valor = atributo.getDestreza();
                                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModDes("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModDes(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtDesF.setText(atributo.getDestreza());
                                txtmodDes.setText(atributo.getModDes());
                                cont[0]++;
                            }
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btnaddCon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation2);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(cont[0] == 2){
                                btnaddFor.setVisibility(View.INVISIBLE);
                                btnaddDes.setVisibility(View.INVISIBLE);
                                btnaddCon.setVisibility(View.INVISIBLE);
                                btnaddInt.setVisibility(View.INVISIBLE);
                                btnaddSab.setVisibility(View.INVISIBLE);
                                btnaddCar.setVisibility(View.INVISIBLE);
                                addCon = "+2";
                                txtaddCon.setText(addCon);
                                Con = Integer.valueOf(atributo.getConstituicao());
                                Con = Con+Integer.valueOf(addCon);
                                atributo.setConstituicao(Con.toString());
                                {
                                    String valorCon = atributo.getConstituicao();
                                    int valCon = (int) Math.floor((Double.valueOf(valorCon) - 10) / 2);
                                    if (valCon > 0) {
                                        atributo.setModCon("+" + String.valueOf(valCon));
                                    } else {
                                        atributo.setModCon(String.valueOf(valCon));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtConF.setText(atributo.getConstituicao());
                                txtmodCon.setText(atributo.getModCon());
                                cont[0]++;
                            }else{
                                btnaddCon.setVisibility(View.INVISIBLE);
                                addCon = "+2";
                                txtaddCon.setText(addCon);
                                Con = Integer.valueOf(atributo.getConstituicao());
                                Con = Con+Integer.valueOf(addCon);
                                atributo.setConstituicao(Con.toString());
                                {
                                    String valorCon = atributo.getConstituicao();
                                    int valCon = (int) Math.floor((Double.valueOf(valorCon) - 10) / 2);
                                    if (valCon > 0) {
                                        atributo.setModCon("+" + String.valueOf(valCon));
                                    } else {
                                        atributo.setModCon(String.valueOf(valCon));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtConF.setText(atributo.getConstituicao());
                                txtmodCon.setText(atributo.getModCon());
                                cont[0]++;
                            }
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btnaddInt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation2);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(cont[0] == 2){
                                btnaddFor.setVisibility(View.INVISIBLE);
                                btnaddDes.setVisibility(View.INVISIBLE);
                                btnaddCon.setVisibility(View.INVISIBLE);
                                btnaddInt.setVisibility(View.INVISIBLE);
                                btnaddSab.setVisibility(View.INVISIBLE);
                                btnaddCar.setVisibility(View.INVISIBLE);
                                addInt = "+2";
                                txtaddInt.setText(addInt);
                                Int = Integer.valueOf(atributo.getInteligencia());
                                Int = Int+Integer.valueOf(addInt);
                                atributo.setInteligencia(Int.toString());
                                {
                                    String valor = atributo.getInteligencia();
                                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModInt("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModInt(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtIntF.setText(atributo.getInteligencia());
                                txtmodInt.setText(atributo.getModInt());
                                cont[0]++;
                            }else{
                                btnaddInt.setVisibility(View.INVISIBLE);
                                addInt = "+2";
                                txtaddInt.setText(addInt);
                                Int = Integer.valueOf(atributo.getInteligencia());
                                Int = Int+Integer.valueOf(addInt);
                                atributo.setInteligencia(Int.toString());
                                {
                                    String valor = atributo.getInteligencia();
                                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModInt("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModInt(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtIntF.setText(atributo.getInteligencia());
                                txtmodInt.setText(atributo.getModInt());
                                cont[0]++;
                            }
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btnaddSab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    view.startAnimation(animation2);
                    view.postOnAnimationDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(cont[0] == 2){
                                btnaddFor.setVisibility(View.INVISIBLE);
                                btnaddDes.setVisibility(View.INVISIBLE);
                                btnaddCon.setVisibility(View.INVISIBLE);
                                btnaddInt.setVisibility(View.INVISIBLE);
                                btnaddSab.setVisibility(View.INVISIBLE);
                                btnaddCar.setVisibility(View.INVISIBLE);
                                addSab = "+2";
                                txtaddSab.setText(addSab);
                                Sab = Integer.valueOf(atributo.getSabedoria());
                                Sab = Sab+Integer.valueOf(addSab);
                                atributo.setSabedoria(Sab.toString());
                                {
                                    String valor = atributo.getSabedoria();
                                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModSab("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModSab(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtSabF.setText(atributo.getSabedoria());
                                txtmodSab.setText(atributo.getModSab());
                                cont[0]++;
                            }else{
                                btnaddSab.setVisibility(View.INVISIBLE);
                                addSab = "+2";
                                txtaddSab.setText(addSab);
                                Sab = Integer.valueOf(atributo.getSabedoria());
                                Sab = Sab+Integer.valueOf(addSab);
                                atributo.setSabedoria(Sab.toString());
                                {
                                    String valor = atributo.getSabedoria();
                                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                    if (val > 0) {
                                        atributo.setModSab("+" + String.valueOf(val));
                                    } else {
                                        atributo.setModSab(String.valueOf(val));
                                    }
                                }
                                ficha.setAtributo(atributo);
                                txtSabF.setText(atributo.getSabedoria());
                                txtmodSab.setText(atributo.getModSab());
                                cont[0]++;
                            }
                            view.clearAnimation();
                        }
                    },50);
                }
            });
            btnaddCar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(final View view) {
                  view.startAnimation(animation2);
                  view.postOnAnimationDelayed(new Runnable() {
                      @Override
                      public void run() {
                          if(cont[0] == 2){
                              btnaddFor.setVisibility(View.INVISIBLE);
                              btnaddDes.setVisibility(View.INVISIBLE);
                              btnaddCon.setVisibility(View.INVISIBLE);
                              btnaddInt.setVisibility(View.INVISIBLE);
                              btnaddSab.setVisibility(View.INVISIBLE);
                              btnaddCar.setVisibility(View.INVISIBLE);
                              addCar = "+2";
                              txtaddCar.setText(addCar);
                              Car = Integer.valueOf(atributo.getCarisma());
                              Car = Car+Integer.valueOf(addCar);
                              atributo.setCarisma(Car.toString());
                              {
                                  String valor = atributo.getCarisma();
                                  int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                  if (val > 0) {
                                      atributo.setModCar("+" + String.valueOf(val));
                                  } else {
                                      atributo.setModCar(String.valueOf(val));
                                  }
                              }
                              ficha.setAtributo(atributo);
                              txtCarF.setText(atributo.getCarisma());
                              txtmodCar.setText(atributo.getModCar());
                              cont[0]++;
                          }else{
                              btnaddCar.setVisibility(View.INVISIBLE);
                              addCar = "+2";
                              txtaddCar.setText(addCar);
                              Car = Integer.valueOf(atributo.getCarisma());
                              Car = Car+Integer.valueOf(addCar);
                              atributo.setCarisma(Car.toString());
                              {
                                  String valor = atributo.getCarisma();
                                  int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                                  if (val > 0) {
                                      atributo.setModCar("+" + String.valueOf(val));
                                  } else {
                                      atributo.setModCar(String.valueOf(val));
                                  }
                              }
                              ficha.setAtributo(atributo);
                              txtCarF.setText(atributo.getCarisma());
                              txtmodCar.setText(atributo.getModCar());
                              cont[0]++;
                          }
                          view.clearAnimation();
                      }
                  },50);
              }
            });
        }else{
            btnDef.setVisibility(View.INVISIBLE);
            txtaddFor.setText(addFor);
            txtaddDes.setText(addDes);
            txtaddCon.setText(addCon);
            txtaddInt.setText(addInt);
            txtaddSab.setText(addSab);
            txtaddCar.setText(addCar);
            For = Integer.valueOf(atributo.getForca());
            Des = Integer.valueOf(atributo.getDestreza());
            Con = Integer.valueOf(atributo.getConstituicao());
            Int = Integer.valueOf(atributo.getInteligencia());
            Sab = Integer.valueOf(atributo.getSabedoria());
            Car = Integer.valueOf(atributo.getCarisma());
            For = For+Integer.valueOf(addFor);
            Des = Des+Integer.valueOf(addDes);
            Con = Con+Integer.valueOf(addCon);
            Int = Int+Integer.valueOf(addInt);
            Sab = Sab+Integer.valueOf(addSab);
            Car = Car+Integer.valueOf(addCar);
            atributo.setForca(For.toString());
            atributo.setDestreza(Des.toString());
            atributo.setConstituicao(Con.toString());
            atributo.setInteligencia(Int.toString());
            atributo.setSabedoria(Sab.toString());
            atributo.setCarisma(Car.toString());
            {
                {
                    String valorCon = atributo.getConstituicao();
                    int valCon = (int) Math.floor((Double.valueOf(valorCon) - 10) / 2);
                    if (valCon > 0) {
                        atributo.setModCon("+" + String.valueOf(valCon));
                    } else {
                        atributo.setModCon(String.valueOf(valCon));
                    }
                }
                {
                    String valorFor = atributo.getForca();
                    int val = (int) Math.floor((Double.valueOf(valorFor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModFor("+" + String.valueOf(val));
                    } else {
                        atributo.setModFor(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getDestreza();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModDes("+" + String.valueOf(val));
                    } else {
                        atributo.setModDes(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getCarisma();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModCar("+" + String.valueOf(val));
                    } else {
                        atributo.setModCar(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getSabedoria();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModSab("+" + String.valueOf(val));
                    } else {
                        atributo.setModSab(String.valueOf(val));
                    }
                }
                {
                    String valor = atributo.getInteligencia();
                    int val = (int) Math.floor((Double.valueOf(valor) - 10) / 2);
                    if (val > 0) {
                        atributo.setModInt("+" + String.valueOf(val));
                    } else {
                        atributo.setModInt(String.valueOf(val));
                    }
                }
            }
            ficha.setAtributo(atributo);
            txtForF.setText(atributo.getForca());
            txtDesF.setText(atributo.getDestreza());
            txtConF.setText(atributo.getConstituicao());
            txtIntF.setText(atributo.getInteligencia());
            txtSabF.setText(atributo.getSabedoria());
            txtCarF.setText(atributo.getCarisma());
            txtmodFor.setText(atributo.getModFor());
            txtmodDes.setText(atributo.getModDes());
            txtmodCon.setText(atributo.getModCon());
            txtmodInt.setText(atributo.getModInt());
            txtmodSab.setText(atributo.getModSab());
            txtmodCar.setText(atributo.getModCar());
            getVida(ficha.getClasseO(),Integer.valueOf(atributo.getModCon()),Integer.valueOf(ficha.getNivel()));
            txtVida.setText("Sua vida é: "+totalTot);
            ficha.setVida(total.toString());
        }
        btnDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                view.startAnimation(animation2);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (cont[0]<=2){
                            Toast.makeText(getBaseContext(), "Você ainda tem pontos pra adicionar!", Toast.LENGTH_SHORT).show();
                        }else {
                            getVida(ficha.getClasseO(), Integer.valueOf(atributo.getModCon()), Integer.valueOf(ficha.getNivel()));
                            txtVida.setText("Sua vida é: " + totalTot);
                            ficha.setVida(total.toString());
                            btnDef.setVisibility(View.INVISIBLE);
                        }
                        view.clearAnimation();
                    }
                },50);
            }
        });
        btnUlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                view.startAnimation(animation);
                view.postOnAnimationDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (total == null){
                            Toast.makeText(getBaseContext(), "Defina sua vida!", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(getApplicationContext(), Pericias.class);
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
    public void getVida(Classe classe, Integer modCon, Integer nivel){
        total = classe.getDadoInicial()+modCon;
        dado = classe.getDadoNivel()+modCon;
        base = total.toString();
        totalTot = "+ ";
        mais = " + ";
        if(nivel==1){
            totalTot = total.toString();
        }else{
            for (int i = 1;i<nivel;i++){
                total = total+dado;
                if(i == nivel-1){
                    mais = " ";
                }
                totalTot = totalTot + dado.toString() + mais;
            }
            totalTot = base+" "+totalTot+"= "+total.toString();
        }
    }
}