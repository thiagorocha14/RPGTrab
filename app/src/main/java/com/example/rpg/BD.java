package com.example.rpg;

import com.example.rpg.Objects.Ficha;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class BD {
    public static FirebaseDatabase bd;
    public static DatabaseReference fichabd;
    public static FirebaseUser user;
    public static StorageReference storage;

    public static void conectar(){
        bd = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        fichabd = bd.getReference("users").child(user.getUid());
        storage = FirebaseStorage.getInstance().getReference("uploads");
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
        if(ficha.getLink()!=null){
            storage.child(getReferenceUrl(ficha.getLink())).delete();
        }
    }
    public static String getReferenceUrl(String url){
        String baseUrl = "https://firebasestorage.googleapis.com/v0/b/rpgtrab.appspot.com/o/uploads";
        String imagepath = url.replace(baseUrl,"");
        int endPath = imagepath.indexOf("?");
        imagepath = imagepath.substring(0,endPath);
        imagepath = imagepath.replace("%2F","/");
        return imagepath;
    }

}