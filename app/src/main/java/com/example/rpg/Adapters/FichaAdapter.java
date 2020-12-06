package com.example.rpg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rpg.Objects.Classe;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;

import java.util.ArrayList;
import java.util.Locale;

public class FichaAdapter extends ArrayAdapter<Ficha> {
    private ArrayList<Ficha> lista;
    private Context context;
    private ArrayList<Ficha> listafilter = null;

    public FichaAdapter(Context c, ArrayList<Ficha> objects) {
        super(c, 0, objects);
        this.context = c;
        this.lista = objects;
        this.listafilter = new ArrayList<Ficha>();
        this.listafilter.addAll(lista);
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
            Classe classe = ficha.getClasseO();
            txtNome.setText(ficha.getPersonagem());
            txtClasse.setText(classe.getClasse());
            txtNivel.setText(ficha.getNivel());
        }
        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        lista.clear();
        if (charText.length() == 0) {
            lista.addAll(listafilter);
        }
        else
        {
            for (Ficha ficha : listafilter) {
                if (ficha.getPersonagem().toLowerCase(Locale.getDefault()).contains(charText)) {
                    lista.add(ficha);
                }
                if (ficha.getRaca().toLowerCase(Locale.getDefault()).contains(charText)) {
                    lista.add(ficha);
                }
                if (ficha.getClasseO().getClasse().toLowerCase(Locale.getDefault()).contains(charText)) {
                    lista.add(ficha);
                }
                if (ficha.getNivel().toLowerCase(Locale.getDefault()).contains(charText)) {
                    lista.add(ficha);
                }
            }
        }
        notifyDataSetChanged();
    }
}