package com.example.rpg.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
                p = ficha.getPgC()+5;
            }
            if (extra.equals("Raca")) {
                p = ficha.getPgR()+5;
            }
            if (extra.equals("Peri")) {
                p = 112+5;
            }
            if (extra.equals("Magia")) {
                p = 158+5;
            }
            if (extra.equals("Atrib")) {
                p = 17+5;
            }
            if (extra.equals("Origem")) {
                p = 85+5;
            }
            if (extra.equals("Alin")) {
                p = 109+5;
            }
        }
        pdfView.fromAsset("t.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(p)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(2)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();
        return view;
    }


}