package com.example.rpg;

import com.example.rpg.Atributos.Atributo;

import java.io.Serializable;

public class Ficha implements Serializable {

    //private String Nome;
    private String Personagem;
    //private String Sistema;
    private String Raca;
    private String Classe;
    private String Id;
    private int PgC;
    private int PgR;
    private String Nivel;
    private String Alinhamento;
    private String Origem;
    private String Vida;
    private String Magia;
    private String Link;
    private String Pericia;
    private Atributo Atributo = new Atributo();

    public Ficha() {
    }

    public Ficha(String personagem, String raca, String classe, String id, int pgC, int pgR, String nivel, String alinhamento, String origem, String vida, String magia, String link, Atributo atributo, String pericia) {
        Personagem = personagem;
        Raca = raca;
        Classe = classe;
        Id = id;
        PgC = pgC;
        PgR = pgR;
        Nivel = nivel;
        Alinhamento = alinhamento;
        Origem = origem;
        Vida = vida;
        Magia = magia;
        Link = link;
        Atributo = atributo;
        Pericia = pericia;
    }

    public String getPersonagem() {
        return Personagem;
    }

    public void setPersonagem(String personagem) {
        Personagem = personagem;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String raca) {
        Raca = raca;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getPgC() {
        return PgC;
    }

    public void setPgC(int pgC) {
        PgC = pgC;
    }

    public int getPgR() {
        return PgR;
    }

    public void setPgR(int pgR) {
        PgR = pgR;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) {
        Nivel = nivel;
    }

    public String getAlinhamento() {
        return Alinhamento;
    }

    public void setAlinhamento(String alinhamento) {
        Alinhamento = alinhamento;
    }

    public String getOrigem() {
        return Origem;
    }

    public void setOrigem(String origem) {
        Origem = origem;
    }

    public String getVida() {
        return Vida;
    }

    public void setVida(String vida) {
        Vida = vida;
    }

    public String getMagia() {
        return Magia;
    }

    public void setMagia(String magia) {
        Magia = magia;
    }

    public Atributo getAtributo() {
        return Atributo;
    }

    public void setAtributo(Atributo atributo) {
        Atributo = atributo;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getPericia() {
        return Pericia;
    }

    public void setPericia(String pericia) {
        Pericia = pericia;
    }

    @Override
    public String toString() {
        return "Ficha:" +"\n"+
                "Personagem: " + Personagem + '\n' +
                "Raca: " + Raca + '\n' +
                "Classe: " + Classe + '\n' +
                "Página da Classe: " + PgC + '\n' +
                "Página da Raca: " + PgR + '\n' +
                "Nivel: " + Nivel + '\n' +
                "Alinhamento: " + Alinhamento + '\n' +
                "Origem: " + Origem + '\n' +
                "Vida: "+Vida+'\n'+
                "Atributos: "+'\n'+ Atributo +'\n'+
                "Magias: "+'\n'+Magia;
    }
}
