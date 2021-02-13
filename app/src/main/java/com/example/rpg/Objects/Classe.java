package com.example.rpg.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Classe implements Serializable {

    private String Classe;
    private int PgC;
    private List<String> PeriBase = new ArrayList<String>();;
    private int DadoInicial;
    private int DadoNivel;
    private int PeriQuanti;
    private int PMNivel;

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
        if(classe.equals("Arcanista")){
            PgC = 36;
            DadoInicial = 8;
            DadoNivel = 2;
            PMNivel = 6;
            PeriBase.add(0,"Misticismo");
            PeriBase.add(1, "Vontade");
            PeriQuanti = 1;
        } else if(classe.equals("Bárbaro")){
            PgC = 40;
            DadoInicial = 24;
            DadoNivel = 6;
            PMNivel = 3;
            PeriBase.add(0,"Fortitude");
            PeriBase.add(1,"Luta");
            PeriQuanti = 4;
        } else if(classe.equals("Bardo")){
            PgC = 43;
            DadoInicial = 12;
            DadoNivel = 3;
            PMNivel = 4;
            PeriBase.add(0,"Atuação");
            PeriBase.add(1,"Reflexos");
            PeriQuanti = 6;
        } else if(classe.equals("Bucaneiro")){
            PgC = 46;
            DadoInicial = 16;
            DadoNivel = 4;
            PMNivel = 3;
            PeriQuanti = 4;
            PeriBase.add(0,"Reflexos");
        } else if(classe.equals("Caçador")){
            PgC = 49;
            DadoInicial = 16;
            DadoNivel = 4;
            PMNivel = 4;
            PeriQuanti = 6;
            PeriBase.add(0,"Sobrevivência");
        } else if(classe.equals("Cavaleiro")){
            PgC = 52;
            DadoInicial = 20;
            DadoNivel = 5;
            PMNivel = 3;
            PeriBase.add(0,"Fortitude");
            PeriBase.add(1,"Luta");
            PeriQuanti = 2;
        } else if(classe.equals("Clérigo")){
            PgC = 56;
            DadoInicial = 16;
            DadoNivel = 4;
            PMNivel = 5;
            PeriBase.add(0,"Religião");
            PeriBase.add(1,"Vontade");
            PeriQuanti = 2;
        } else if(classe.equals("Druida")){
            PgC = 60;
            DadoInicial = 16;
            DadoNivel = 4;
            PMNivel = 4;
            PeriBase.add(0,"Sobrevivência");
            PeriBase.add(1,"Vontade");
            PeriQuanti = 4;
        } else if(classe.equals("Guerreiro")){
            PgC = 64;
            DadoInicial = 20;
            DadoNivel = 5;
            PMNivel = 3;
            PeriQuanti = 2;
            PeriBase.add(0,"Fortitude");
        } else if(classe.equals("Inventor")){
            PgC = 67;
            DadoInicial = 12;
            DadoNivel = 3;
            PMNivel = 4;
            PeriBase.add(0,"Ofício");
            PeriBase.add(1,"Vontade");
            PeriQuanti = 4;
        } else if(classe.equals("Ladino")){
            PgC = 72;
            DadoInicial = 12;
            DadoNivel = 3;
            PMNivel = 4;
            PeriBase.add(0,"Ladinagem");
            PeriBase.add(1,"Reflexos");
            PeriQuanti = 8;
        } else if(classe.equals("Lutador")){
            PgC = 75;
            DadoInicial = 20;
            DadoNivel = 5;
            PeriQuanti = 4;
            PMNivel = 3;
            PeriBase.add(0,"Fortitude");
            PeriBase.add(1,"Luta");
        } else if(classe.equals("Nobre")){
            PgC = 78;
            DadoInicial = 16;
            DadoNivel = 4;
            PMNivel = 4;
            PeriQuanti = 4;
            PeriBase.add(0,"Vontade");
        } else if(classe.equals("Paladino")){
            PgC = 81;
            DadoInicial = 20;
            DadoNivel = 5;
            PMNivel = 3;
            PeriBase.add(0,"Luta");
            PeriBase.add(1,"Vontade");
            PeriQuanti = 2;
        }
    }

    public int getPgC() {
        return PgC;
    }

    public List<String> getPeriBase() {
        return PeriBase;
    }

    public int getDadoInicial() {
        return DadoInicial;
    }

    public int getDadoNivel() {
        return DadoNivel;
    }

    public int getPeriQuanti() {
        return PeriQuanti;
    }

    public int getPMNivel() {
        return PMNivel;
    }
}
