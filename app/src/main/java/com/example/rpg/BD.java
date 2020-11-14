package com.example.rpg;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BD {
    public static FirebaseDatabase bd;
    public static DatabaseReference fichabd;
    public static FirebaseUser user;

    public static void conectar(){
        bd = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        fichabd = bd.getReference("users").child(user.getUid());
    }

    public static void enviar(Ficha ficha){
        conectar();
        String id = fichabd.push().getKey();
        ficha.setId(id);
        fichabd.child(ficha.getId()).setValue(ficha);
    }

    public static void editar(Ficha ficha){
        conectar();
        fichabd.child(ficha.getId()).setValue(ficha);
    }

    public static void excluir(Ficha ficha){
        conectar();
        fichabd.child(ficha.getId()).removeValue();
    }

}