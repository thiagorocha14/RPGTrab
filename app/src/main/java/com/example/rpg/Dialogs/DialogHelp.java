package com.example.rpg.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;

import com.example.rpg.R;

public class DialogHelp extends AppCompatDialogFragment {

    ImageView imgHelp;
    int dw;

    public void setImgHelp(int drawable) {
        this.dw = drawable;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_help, null);

        imgHelp = view.findViewById(R.id.imgHelp);
        imgHelp.setImageResource(dw);
        //imgHelp.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.nome_personagem));

        builder.setView(view);

        return builder.create();
    }
}
