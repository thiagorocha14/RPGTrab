package com.example.rpg.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.rpg.BD;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;

public class DialogVidaAdapter extends AppCompatDialogFragment {

    EditText edtDano, edtCura;
    Button btn;
    Ficha ficha;
    int vida, dano, cura;

    public void setFichaDialog(Ficha fichaDialog){
        ficha = fichaDialog;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_vida, null);
        edtDano = view.findViewById(R.id.edtDialogVida);
        edtCura = view.findViewById(R.id.edtDialogVida2);
        dano = Integer.parseInt(edtDano.toString());
        cura = Integer.parseInt(edtCura.toString());
        btn = view.findViewById(R.id.btnDialogVida);
        vida = ficha.getVida();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ficha.setVida(vida-dano+cura);
                BD.enviar(ficha);
            }
        });
        return builder.create();
    }
}
