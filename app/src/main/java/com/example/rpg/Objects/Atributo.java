package com.example.rpg.Objects;

import java.io.Serializable;

public class Atributo implements Serializable {

    private String Forca;
    private String Destreza;
    private String Constituicao;
    private String Inteligencia;
    private String Sabedoria;
    private String Carisma;
    private String ModFor;
    private String ModDes;
    private String ModCon;
    private String ModInt;
    private String ModSab;
    private String ModCar;

    @Override
    public String toString() {
        return "   Forca = " + Forca +" -> "+ModFor+ '\n' +
                "   Destreza = " + Destreza +" -> "+ModDes+'\n' +
                "   Constituicao = " + Constituicao+" -> "+ModCon+ '\n' +
                "   Inteligencia = " + Inteligencia+" -> "+ModInt+ '\n'+
                "   Sabedoria = " + Sabedoria +" -> "+ModSab+ '\n' +
                "   Carisma = " + Carisma +" -> "+ModCar;
    }

    public Atributo() {
    }

    public Atributo(String constituicao, String forca, String destreza, String carisma, String sabedoria, String inteligencia, String modCon, String modFor, String modDes, String modCar, String modSab, String modInt) {
        Constituicao = constituicao;
        Forca = forca;
        Destreza = destreza;
        Carisma = carisma;
        Sabedoria = sabedoria;
        Inteligencia = inteligencia;
        ModCon = modCon;
        ModFor = modFor;
        ModDes = modDes;
        ModCar = modCar;
        ModSab = modSab;
        ModInt = modInt;
    }

    public String getModCon() {
        return ModCon;
    }

    public void setModCon(String modCon) {
        ModCon = modCon;
    }

    public String getModFor() {
        return ModFor;
    }

    public void setModFor(String modFor) {
        ModFor = modFor;
    }

    public String getModDes() {
        return ModDes;
    }

    public void setModDes(String modDes) {
        ModDes = modDes;
    }

    public String getModCar() {
        return ModCar;
    }

    public void setModCar(String modCar) {
        ModCar = modCar;
    }

    public String getModSab() {
        return ModSab;
    }

    public void setModSab(String modSab) {
        ModSab = modSab;
    }

    public String getModInt() {
        return ModInt;
    }

    public void setModInt(String modInt) {
        ModInt = modInt;
    }

    public String getConstituicao() {
        return Constituicao;
    }

    public void setConstituicao(String constituicao) {
        Constituicao = constituicao;
    }

    public String getForca() {
        return Forca;
    }

    public void setForca(String forca) {
        Forca = forca;
    }

    public String getDestreza() {
        return Destreza;
    }

    public void setDestreza(String destreza) {
        Destreza = destreza;
    }

    public String getCarisma() {
        return Carisma;
    }

    public void setCarisma(String carisma) {
        Carisma = carisma;
    }

    public String getSabedoria() {
        return Sabedoria;
    }

    public void setSabedoria(String sabedoria) {
        Sabedoria = sabedoria;
    }

    public String getInteligencia() {
        return Inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        Inteligencia = inteligencia;
    }

}
