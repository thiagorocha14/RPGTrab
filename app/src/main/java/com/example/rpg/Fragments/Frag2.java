package com.example.rpg.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rpg.Dialogs.DialogDado;
import com.example.rpg.R;

import java.util.Random;

public class Frag2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        final EditText edtD;
        final Button bd4,bd6,bd8,bd10,bd12,bd20,bfim;
        final Random r = new Random();
        edtD = view.findViewById(R.id.edtD);
        bd4 = view.findViewById(R.id.bd4);
        bd6 = view.findViewById(R.id.bd6);
        bd8 = view.findViewById(R.id.bd8);
        bd10 = view.findViewById(R.id.bd10);
        bd12 = view.findViewById(R.id.bd12);
        bd20 = view.findViewById(R.id.bd20);
        bfim = view.findViewById(R.id.bfim);

        bd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDado dialog = new DialogDado();
                dialog.setDado(4);
                dialog.show(getChildFragmentManager(),"dialog");
            }
        });
        bd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDado dialog = new DialogDado();
                dialog.setDado(6);
                dialog.show(getChildFragmentManager(),"dialog");
            }
        });
        bd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDado dialog = new DialogDado();
                dialog.setDado(8);
                dialog.show(getChildFragmentManager(),"dialog");
            }
        });
        bd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDado dialog = new DialogDado();
                dialog.setDado(10);
                dialog.show(getChildFragmentManager(),"dialog");
            }
        });
        bd12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDado dialog = new DialogDado();
                dialog.setDado(12);
                dialog.show(getChildFragmentManager(),"dialog");
            }
        });
        bd20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDado dialog = new DialogDado();
                dialog.setDado(20);
                dialog.show(getChildFragmentManager(),"dialog");
            }
        });
        bfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vald = edtD.getText().toString();
                if (vald.equals("")){
                    Toast.makeText(getContext(), "Insira um valor.", Toast.LENGTH_LONG).show();

                }else{
                    Integer da = Integer.valueOf(vald);
                    DialogDado dialog = new DialogDado();
                    dialog.setDado(da);
                    dialog.show(getChildFragmentManager(), "dialog");
                }
            }
        });


        return view;
    }
}