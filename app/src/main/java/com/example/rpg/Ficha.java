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
    private String paginaC;
    private String paginaR;
    private String Nivel;
    private String Alinhamento;
    private String Origem;
    private String Vida;
    private String Magia;
    private String Link;
    private String Pericia;
    private Atributo atributo = new Atributo();

    public Ficha() {
    }

    public Ficha(String personagem, String raca, String classe, String id, String paginaC, String paginaR, String nivel, String alinhamento, String origem,String vida,String magia,String link, Atributo atributo,String pericia) {
        Personagem = personagem;
        Raca = raca;
        Classe = classe;
        Id = id;
        this.paginaC = paginaC;
        this.paginaR = paginaR;
        Nivel = nivel;
        Alinhamento = alinhamento;
        Origem = origem;
        Vida = vida;
        Magia = magia;
        Link = link;
        this.atributo = atributo;
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

    public String getPaginaC() {
        return paginaC;
    }

    public void setPaginaC(String paginaC) {
        this.paginaC = paginaC;
    }

    public String getPaginaR() {
        return paginaR;
    }

    public void setPaginaR(String paginaR) {
        this.paginaR = paginaR;
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
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
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
                "Página da Classe: " + paginaC + '\n' +
                "Página da Raca: " + paginaR + '\n' +
                "Nivel: " + Nivel + '\n' +
                "Alinhamento: " + Alinhamento + '\n' +
                "Origem: " + Origem + '\n' +
                "Vida: "+Vida+'\n'+
                "Atributos: "+'\n'+atributo+'\n'+
                "Magias: "+'\n'+Magia;
    }
}
