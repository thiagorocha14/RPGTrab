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

public class DialogManaAdapter  extends AppCompatDialogFragment {

    EditText edtMana;
    Button btn;
    Ficha ficha;
    int mana, gasto, manamax;

    public void setFichaDialog(Ficha fichaDialog) {
        ficha = fichaDialog;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_mana, null);
        edtMana = view.findViewById(R.id.edtDialogMana);
        btn = view.findViewById(R.id.btnDialogMana);
        mana = ficha.getPM();
        manamax = ficha.getPMMax();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMana.getText().toString().equals("")) {
                    gasto = 0;
                } else {
                    gasto = Integer.parseInt(edtMana.getText().toString());
                }
                int manatotal = mana - gasto;
                if (manatotal > manamax) {
                    ficha.setPM(ficha.getPMMax());
                    BD.editar(ficha);
                    dismiss();
                } else if(manatotal<0){
                    Toast.makeText(getContext(), "Você não tem pontos o suficiente!", Toast.LENGTH_LONG).show();
                }else{
                    ficha.setPM(mana - gasto);
                    BD.editar(ficha);
                    dismiss();
                }
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