package com.example.rpg.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.rpg.BD;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;

public class DialogSleepAdapter extends AppCompatDialogFragment {
    int recup, vida, pm;
    Button btnBad, btnOk, btnGood, btnWow;
    Ficha ficha;
    public void setFichaDialog(Ficha fichaDialog) {
        ficha = fichaDialog;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sleep, null);
        builder.setView(view);
        btnBad = view.findViewById(R.id.btnSleepRuim);
        btnOk = view.findViewById(R.id.btnSleepNormal);
        btnGood = view.findViewById(R.id.btnSleepConfort);
        btnWow = view.findViewById(R.id.btnSleepLux);

        btnBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recup = Integer.valueOf(ficha.getNivel());
                vida = ficha.getVida();
                pm = ficha.getPM();
                pm = pm + (recup/2);
                vida = vida + (recup/2);
                if (vida>ficha.getVidaMax()){
                    vida = ficha.getVidaMax();
                }
                if (pm>ficha.getPMMax()){
                    pm = ficha.getPMMax();
                }
                ficha.setPM(pm);
                ficha.setVida(vida);
                BD.editar(ficha);
                dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recup = Integer.valueOf(ficha.getNivel());
                vida = ficha.getVida();
                pm = ficha.getPM();
                pm = pm + (recup);
                vida = vida + (recup);
                if (vida>ficha.getVidaMax()){
                    vida = ficha.getVidaMax();
                }
                if (pm>ficha.getPMMax()){
                    pm = ficha.getPMMax();
                }
                ficha.setPM(pm);
                ficha.setVida(vida);
                BD.editar(ficha);
                dismiss();
            }
        });
        btnGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recup = Integer.valueOf(ficha.getNivel());
                vida = ficha.getVida();
                pm = ficha.getPM();
                pm = pm + (recup*2);
                vida = vida + (recup*2);
                if (vida>ficha.getVidaMax()){
                    vida = ficha.getVidaMax();
                }
                if (pm>ficha.getPMMax()){
                    pm = ficha.getPMMax();
                }
                ficha.setPM(pm);
                ficha.setVida(vida);
                BD.editar(ficha);
                dismiss();
            }
        });
        btnWow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recup = Integer.valueOf(ficha.getNivel());
                vida = ficha.getVida();
                pm = ficha.getPM();
                pm = pm + (recup*3);
                vida = vida + (recup*3);
                if (vida>ficha.getVidaMax()){
                    vida = ficha.getVidaMax();
                }
                if (pm>ficha.getPMMax()){
                    pm = ficha.getPMMax();
                }
                ficha.setPM(pm);
                ficha.setVida(vida);
                BD.editar(ficha);
                dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        Intent intent = getActivity().getIntent();
        getActivity().finish();
        startActivity(intent);
        super.onDismiss(dialog);
    }
}
