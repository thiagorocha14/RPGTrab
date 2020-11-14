package com.example.rpg.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rpg.CriarFicha;
import com.example.rpg.Ficha;
import com.example.rpg.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class Frag4 extends Fragment {

    Ficha ficha;
    String extra;
    Bundle bundle;
    int p;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag4, container, false);
        PDFView pdfView = view.findViewById(R.id.pdfView);
        bundle = getArguments();
        p = 2;
        if(bundle !=null && bundle.containsKey("Extra")){
            extra = getArguments().getString("Extra");
            ficha = (Ficha) getArguments().getSerializable("ficha");
            if (extra.equals("Classe")) {
                p = Integer.parseInt(ficha.getPaginaC()) - 1;
            }
            if (extra.equals("Raca")) {
                p = Integer.parseInt(ficha.getPaginaR()) - 1;
            }
        }
        pdfView.fromAsset("t20.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(p)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(1)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();
        return view;
    }


}