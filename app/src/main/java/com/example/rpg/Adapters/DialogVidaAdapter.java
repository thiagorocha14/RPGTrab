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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.rpg.BD;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;
import com.example.rpg.ShowFicha;

public class DialogVidaAdapter extends AppCompatDialogFragment {

    EditText edtDano, edtCura;
    Button btn;
    Ficha ficha;
    int vida, dano, cura,vidamax;

    public void setFichaDialog(Ficha fichaDialog){
        ficha = fichaDialog;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_vida, null);
        edtDano = view.findViewById(R.id.edtDialogVida);
        edtCura = view.findViewById(R.id.edtDialogVida2);
        btn = view.findViewById(R.id.btnDialogVida);
        vida = ficha.getVida();
        vidamax = ficha.getVidaMax();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtCura.getText().toString().equals("")){
                    cura = 0;
                }else{
                    cura = Integer.parseInt(edtCura.getText().toString());
                }
                if(edtDano.getText().toString().equals("")){
                    dano = 0;
                }else{
                    dano = Integer.parseInt(edtDano.getText().toString());
                }
                int vidatotal = vida - dano + cura;
                if(vidatotal>vidamax){
                    ficha.setVida(ficha.getVidaMax());
                }else {
                    ficha.setVida(vida - dano + cura);
                }
                BD.editar(ficha);
                dismiss();
            }
        });
        builder.setView(view);
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
