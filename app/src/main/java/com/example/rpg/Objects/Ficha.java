package com.example.rpg.Objects;

import java.io.Serializable;

public class Ficha implements Serializable {

    //private String Nome;
    private String Personagem;
    //private String Sistema;
    private String Raca;
    private Classe Classe;
    private String Id;
    //private int PgC;
    private int PgR;
    private String Nivel;
    private String Alinhamento;
    private String Origem;
    private int Vida;
    private int VidaMax;
    private int PM;
    private int PMMax;
    private String Magia;
    private String Link;
    private String Pericia;
    private Atributo Atributo = new Atributo();

    public Ficha() {
    }

    public Ficha(String personagem, String raca, Classe classe, String id, int pgR, String nivel, String alinhamento, String origem, int vida,int vidamax, String magia, String link, Atributo atributo, String pericia) {
        Personagem = personagem;
        Raca = raca;
        Classe = classe;
        Id = id;
        PgR = pgR;
        Nivel = nivel;
        Alinhamento = alinhamento;
        Origem = origem;
        Vida = vida;
        VidaMax = vidamax;
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

    public Classe getClasseO() {
        return Classe;
    }

    public void setClasseO(Classe classe) {
        Classe = classe;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

   /* public int getPgC() {
        return PgC;
    }

    public void setPgC(int pgC) {
        PgC = pgC;
    }

    */

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

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    public int getVidaMax() {
        return VidaMax;
    }

    public void setVidaMax(int vidaMax) {
        VidaMax = vidaMax;
    }

    public int getPM() {
        return PM;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public int getPMMax() {
        return PMMax;
    }

    public void setPMMax(int PMMax) {
        this.PMMax = PMMax;
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
                "Página da Classe: " + Classe.getPgC() + '\n' +
                "Página da Raca: " + PgR + '\n' +
                "Nivel: " + Nivel + '\n' +
                "Alinhamento: " + Alinhamento + '\n' +
                "Origem: " + Origem + '\n' +
                "Vida: "+Vida+'\n'+
                "Atributos: "+'\n'+ Atributo +'\n'+
                "Magias: "+'\n'+Magia;
    }
}
