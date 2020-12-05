package com.example.rpg.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.rpg.Atributos.Atribut2;
import com.example.rpg.BD;
import com.example.rpg.Criation.CriarRaca;
import com.example.rpg.Ficha;
import com.example.rpg.FichaAdapter;
import com.example.rpg.Login;
import com.example.rpg.MainActivity;
import com.example.rpg.R;
import com.example.rpg.ShowFicha;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


public class Frag3 extends Fragment {

    ListView listFichas;
    ArrayAdapter<Ficha> adapter;
    Ficha ficha;
    boolean isRotate = false;
    boolean show = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_frag3, container, false);
        listFichas = view.findViewById(R.id.listPer);
        FloatingActionButton btnadd = view.findViewById(R.id.btnAddFicha);
        final FloatingActionButton fabAdd = view.findViewById(R.id.fabAdd);
        final FloatingActionButton fabSearch = view.findViewById(R.id.fabSearch);
        final EditText edtSearch = view.findViewById(R.id.ediSearch);
        init(fabAdd);
        init(fabSearch);
        init(edtSearch);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRotate = rotateFab(v, !isRotate);
                if(isRotate){
                    showIn(fabAdd);
                    showIn(fabSearch);
                }else{
                    showOut(fabAdd);
                    showOut(fabSearch);
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
                    showIn(edtSearch);
                    show = true;
                }else{
                    edtSearch.setVisibility(View.GONE);
                    show = false;
                }
            }
        });
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
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
        listFichas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ficha = adapter.getItem(position);
                Intent intent = new Intent(getContext(), ShowFicha.class);
                intent.putExtra("Ficha", ficha);
                startActivity(intent);
                /*
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Ó grande "+ficha.getPersonagem())
                     .setMessage("Você pode encontrar sobre "+ficha.getRaca()+" na página "+ficha.getPaginaR()+" no Livro do Jogador Tormenta20 "+"\n"+"Você pode encontrar sobre "+ficha.getClasse()+" na página "+ficha.getPaginaC()+" no Livro do Jogador Tormenta20 ")
                        .setPositiveButton("Ir para a Classe",dialog)
                        .setNegativeButton("Ir para a Raca",dialog);
                alert.show();

                 */
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
    DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Fragment Frag = new Frag4();
            Bundle bundle = new Bundle();
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    bundle.putString("Extra","Classe");
                break;
                case DialogInterface.BUTTON_NEGATIVE:
                    bundle.putString("Extra","Raca");
                    break;
        }
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
    }
  };
    DialogInterface.OnClickListener dialog3 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getContext(), Login.class);
                        startActivity(intent);
                        getActivity().finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:

                    break;
            }
        }
    };
    public static boolean rotateFab(final View v, boolean rotate) {
        v.animate().setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .rotation(rotate ? 135f : 0f);
        return rotate;
    }
    public static void showIn(final View v) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(0f);
        v.setTranslationY(v.getHeight());
        v.animate()
                .setDuration(200)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .alpha(1f)
                .start();
    }
    public static void showOut(final View v) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(1f);
        v.setTranslationY(0);
        v.animate()
                .setDuration(200)
                .translationY(v.getHeight())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        v.setVisibility(View.GONE);
                        super.onAnimationEnd(animation);
                    }
                }).alpha(0f)
                .start();
    }

    public static void init(final View v) {
        v.setVisibility(View.GONE);
        v.setTranslationY(v.getHeight());
        v.setAlpha(0f);
    }
}
