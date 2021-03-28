package com.example.rpg.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rpg.Animation;
import com.example.rpg.BD;
import com.example.rpg.Criation.CriarRaca;
import com.example.rpg.Objects.Ficha;
import com.example.rpg.Adapters.FichaAdapter;
import com.example.rpg.R;
import com.example.rpg.ShowFicha;
import com.example.rpg.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;


public class Frag2 extends Fragment {

    ListView listFichas;
    FichaAdapter adapter;
    Ficha ficha;
    boolean isRotate = false;
    boolean show = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        listFichas = view.findViewById(R.id.listPer);
        FloatingActionButton btnadd = view.findViewById(R.id.btnAddFicha);
        final FloatingActionButton fabAdd = view.findViewById(R.id.fabAdd);
        final FloatingActionButton fabSearch = view.findViewById(R.id.fabSearch);
        final EditText edtSearch = view.findViewById(R.id.ediSearch);
        Animation.init(fabAdd);
        Animation.init(fabSearch);
        Animation.init(edtSearch);
        if (Util.statusNet(getContext())) {
            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isRotate = Animation.rotateFab135(v, !isRotate);
                    if(isRotate){
                        Animation.showIn(fabAdd);
                        Animation.showIn(fabSearch);
                    }else{
                        Animation.showOut(fabAdd);
                        Animation.showOut(fabSearch);
                    }
                }
            });
            fabAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), CriarRaca.class);
                    startActivity(intent);
                }
            });
            fabSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (show==false) {
                        Animation.showIn(edtSearch);
                        show = true;
                    }else{
                        edtSearch.setVisibility(View.GONE);
                        show = false;
                    }
                }
            });
        } else {
            Toast.makeText(getContext(), "Sem conexão com a internet", Toast.LENGTH_LONG).show();
        }
        BD.conectar();
        BD.fichabd.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Ficha> lista = new ArrayList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Ficha ficha = data.getValue(Ficha.class);
                    lista.add(ficha);
                }
                if (getActivity() != null) {
                    adapter = new FichaAdapter(getActivity(),lista);
                    listFichas.setAdapter(adapter);
                    listFichas.setTextFilterEnabled(true);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = edtSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        listFichas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ficha = adapter.getItem(position);
                Intent intent = new Intent(getContext(), ShowFicha.class);
                intent.putExtra("Ficha", ficha);
                startActivity(intent);
            }
        });
        listFichas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ficha = adapter.getItem(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Deseja excluir esta ficha?")
                            .setPositiveButton("Excluir",dialog2)
                            .setNegativeButton("Cancelar",dialog2);
                alert.show();
                return true;
            }
        });
        return view;
    }
    DialogInterface.OnClickListener dialog2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    BD.excluir(ficha);
                    adapter.notifyDataSetChanged();
                break;
                case DialogInterface.BUTTON_NEGATIVE:

                    break;
            }
        }
    };
}
