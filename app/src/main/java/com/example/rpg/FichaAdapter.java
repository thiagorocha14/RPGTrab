package com.example.rpg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FichaAdapter extends ArrayAdapter<Ficha> {
    private ArrayList<Ficha> lista;
    private Context context;

    public FichaAdapter(Context c, ArrayList<Ficha> objects) {
        super(c, 0, objects);
        this.context = c;
        this.lista = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (lista != null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.act_lista, parent, false);

            TextView txtNome = view.findViewById(R.id.txtNomeAdapter);
            TextView txtClasse = view.findViewById(R.id.txtClasseAdapter);
            TextView txtNivel = view.findViewById(R.id.txtNivelAdapter);
            ImageView img = view.findViewById(R.id.imageView3);

            Ficha ficha = lista.get(position);
            if (ficha.getLink()!=null){
                Picasso.get().load(ficha.getLink()).into(img);
            }
            txtNome.setText(ficha.getPersonagem());
            txtClasse.setText(ficha.getClasse());
            txtNivel.setText(ficha.getNivel());
        }
        return view;
    }
}