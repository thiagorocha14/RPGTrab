package com.example.rpg.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatDialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rpg.R;

import java.util.Random;

public class DialogDadoAdapter extends AppCompatDialogFragment {

    Integer i, b = 0;
    TextView txt;
    ImageView img4,img6,img8,img10,img12,img20;
    Random r = new Random();

    public void setDado(Integer i){
        this.i = i;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_dado, null);
        txt = view.findViewById(R.id.txtRandom);
        img4 = view.findViewById(R.id.img4);
        img6 = view.findViewById(R.id.img6);
        img8 = view.findViewById(R.id.img8);
        img10 = view.findViewById(R.id.img10);
        img12 = view.findViewById(R.id.img12);
        img20 = view.findViewById(R.id.img20);
        if (i>99){
            img4.setVisibility(View.INVISIBLE);
            img6.setVisibility(View.INVISIBLE);
            img8.setVisibility(View.INVISIBLE);
            img10.setVisibility(View.INVISIBLE);
            img12.setVisibility(View.INVISIBLE);
            img20.setVisibility(View.INVISIBLE);
        }
        builder.setView(view);

        new CountDownTimer(3000, 50) {
            public void onFinish() {
               txt.setText(Integer.toString(r.nextInt(i)+1));
            }

            public void onTick(long millisUntilFinished) {
                txt.setText(Integer.toString(r.nextInt(i)+1));
            }
        }.start();

        return builder.create();
    }

}
