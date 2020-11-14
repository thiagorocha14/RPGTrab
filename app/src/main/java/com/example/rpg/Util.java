package com.example.rpg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Util {

    public static boolean statusNet(Context context) {
        ConnectivityManager conect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conect.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public static void error(Context context, String respost) {
        if (respost.contains("least 6 characters")) {
            Toast.makeText(context, "A senha deve ter pelo menos 6 caracteres.", Toast.LENGTH_LONG).show();
        } else if (respost.contains("address is badly")) {
            Toast.makeText(context, "Endereço de email inválido.", Toast.LENGTH_LONG).show();
        } else if (respost.contains("interrupted connection")) {
            Toast.makeText(context, "Sem conexão com o Banco de Dados.", Toast.LENGTH_LONG).show();
        } else if (respost.contains("There is no user")) {
            Toast.makeText(context, "Email não cadastrado.", Toast.LENGTH_LONG).show();
        } else if (respost.contains("password is invalid")) {
            Toast.makeText(context, "Senha inválida.", Toast.LENGTH_LONG).show();
        } else if (respost.contains("address is already")) {
            Toast.makeText(context, "Email já foi cadastrado.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, respost, Toast.LENGTH_LONG).show();
        }

    }

}
