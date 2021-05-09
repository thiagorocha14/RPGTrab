package com.example.rpg.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rpg.BD;
import com.example.rpg.Objects.Classe;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.R;
import com.example.rpg.ShowFicha;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FichaAdapter extends RecyclerView.Adapter<FichaAdapter.FichaHolder> {
    private List<Ficha> lista;
    private Context context;
    private List<Ficha> listafilter = null;
    Ficha ficha;

    public FichaAdapter(Context c, List<Ficha> objects) {
        this.context = c;
        this.lista = objects;
        this.listafilter = new ArrayList<Ficha>();
        this.listafilter.addAll(lista);
    }
    public class FichaHolder extends RecyclerView.ViewHolder{
        TextView txtNome;
        //TextView txtClasse;
        //TextView txtNivel;
        ImageView img;
        public FichaHolder(@NonNull View itemView) {
            super(itemView);
            this.txtNome = itemView.findViewById(R.id.txtNomeAdapter);
            //this.txtClasse = itemView.findViewById(R.id.txtClasseAdapter);
            //this.txtNivel = itemView.findViewById(R.id.txtNivelAdapter);
            this.img = itemView.findViewById(R.id.imageView3);
        }
    }
    @NonNull
    @Override
    public FichaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_lista,parent,false);
        return new FichaHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final FichaHolder holder,final int position) {
        ficha = lista.get(position);
        final Classe classe = ficha.getClasseO();
        holder.txtNome.setText(ficha.getPersonagem());
        //holder.txtClasse.setText(classe.getClasse());
        //holder.txtNivel.setText(ficha.getNivel());
        if (ficha.getLink() == null){

        }else{
            Picasso.get().load(ficha.getLink()).into(holder.img,new com.squareup.picasso.Callback(){

                @Override
                public void onSuccess() {
                    Bitmap bitmap = ((BitmapDrawable) holder.img.getDrawable()).getBitmap();
                    if (bitmap != null) {
                        Palette color = Palette.from(bitmap).generate();
                        int vibrantColor = color.getVibrantColor(context.getResources().getColor(R.color.colorPrimary));
                        int average = color.getDominantColor(context.getResources().getColor(R.color.colorPrimary));
                        holder.txtNome.setTextColor(vibrantColor);//holder.txtClasse.setTextColor(vibrantColor);holder.txtNivel.setTextColor(vibrantColor);
                    }
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ficha = lista.get(position);
                Intent intent = new Intent(context, ShowFicha.class);
                intent.putExtra("Ficha", ficha);
                context.startActivity(intent);
            }
        });
        holder.img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ficha = lista.get(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Deseja excluir esta ficha?")
                        .setPositiveButton("Excluir",dialog2)
                        .setNegativeButton("Cancelar",dialog2);
                alert.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    /*public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            if (lista != null) {
                LayoutInflater inflater = (LayoutInflater)
                        context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.adapter_lista, parent, false);

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
        }*/
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
    DialogInterface.OnClickListener dialog2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    BD.excluir(ficha);
                    notifyDataSetChanged();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:

                    break;
            }
        }
    };
}