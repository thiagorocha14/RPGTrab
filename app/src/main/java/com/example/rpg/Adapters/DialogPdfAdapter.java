package com.example.rpg.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.rpg.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class DialogPdfAdapter extends AppCompatDialogFragment {
    int p = 0;
    public void setPage(int page){
        p = page;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_pdf, null);
        PDFView pdfView = view.findViewById(R.id.pdfDialog);
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
        builder.setView(view);
        return builder.create();
    }
}
