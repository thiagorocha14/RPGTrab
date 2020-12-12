package com.example.rpg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.rpg.Criation.CriarClasse;
import com.example.rpg.Criation.CriarRaca;
import com.example.rpg.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] lst_imagesclasse = {R.drawable.classe_arcanista,R.drawable.classe_barbaro,R.drawable.classe_bardo,R.drawable.classe_bucaneiro,R.drawable.classe_cacador,R.drawable.classe_cavaleiro,R.drawable.classe_clerigo,R.drawable.classe_druida,R.drawable.classe_guerreiro,R.drawable.classe_inventor,R.drawable.classe_ladino,R.drawable.classe_lutador,R.drawable.classe_nobre,R.drawable.classe_paladino};
    public String[] lst_classes = {"Arcanista","Bárbaro","Bardo","Bucaneiro","Caçador","Cavaleiro","Clérigo","Druida","Guerreiro","Inventor","Ladino","Lutador","Nobre","Paladino"};
    public int[] lst_imagesraca = {R.drawable.raca_humano,R.drawable.raca_anao,R.drawable.raca_dahllan,R.drawable.raca_elfo,R.drawable.raca_goblin,R.drawable.raca_lefou,R.drawable.raca_minotauro,R.drawable.raca_qareen,R.drawable.raca_golem,R.drawable.raca_hynne,R.drawable.raca_kliren,R.drawable.raca_medusa,R.drawable.raca_osteon,R.drawable.raca_sereia,R.drawable.raca_silfide,R.drawable.raca_suraggel,R.drawable.raca_trog};
    public String[] lst_raca = {"Humano","Anão","Dahllan","Elfo","Goblin","Lefou","Minotauro","Qareen","Golem","Hynne","Kliren","Medusa","Osteon","Sereia/Tristão","Sílfide","Suraggel","Trog"};
    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        int count = 0;
        if( context instanceof CriarClasse){
            count = lst_classes.length;
        }else if( context instanceof CriarRaca){
            count = lst_raca.length;
        }
        return count;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(ConstraintLayout)object);
    }
    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_slide,container,false);
        ImageView imgPager = view.findViewById(R.id.imgPager);
        ImageView imgL = view.findViewById(R.id.imgArrowL);
        ImageView imgR = view.findViewById(R.id.imgArrowR);
        if(position == 0){
            imgL.setVisibility(View.INVISIBLE);
        }else if(position == getCount()-1){
            imgR.setVisibility(View.INVISIBLE);
        }else{
            imgL.setVisibility(View.VISIBLE);
            imgR.setVisibility(View.VISIBLE);
        }
        final TextView txtPager= (TextView) view.findViewById(R.id.txtPager);
        if( context instanceof CriarClasse){
            imgPager.setImageResource(lst_imagesclasse[position]);
            txtPager.setText(lst_classes[position]);
        }else if( context instanceof CriarRaca){
            imgPager.setImageResource(lst_imagesraca[position]);
            txtPager.setText(lst_raca[position]);
        }
        imgPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPdfAdapter dialog = new DialogPdfAdapter();
                dialog.setPage(getPage(txtPager.getText().toString()));
                dialog.show(((AppCompatActivity)context).getSupportFragmentManager(), "Title");
            }
        });
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
    public int getPage(String string){
        int pg = 0;
        if(string.equals("Arcanista")){
            pg = 41;
        } else if(string.equals("Bárbaro")){
            pg = 45;
        } else if(string.equals("Bardo")){
            pg = 48;
        } else if(string.equals("Bucaneiro")){
            pg = 51;
        } else if(string.equals("Caçador")){
            pg = 54;
        } else if(string.equals("Cavaleiro")){
            pg = 57;
        } else if(string.equals("Clérigo")){
            pg = 61;
        } else if(string.equals("Druida")){
            pg = 65;
        } else if(string.equals("Guerreiro")){
            pg = 69;
        } else if(string.equals("Inventor")){
            pg = 71;
        } else if(string.equals("Ladino")){
            pg = 77;
        } else if(string.equals("Lutador")){
            pg = 80;
        } else if(string.equals("Nobre")){
            pg = 83;
        } else if(string.equals("Paladino")){
            pg = 86;
        } else if(string.equals("Humano")){
            pg = 24;
        } else if(string.equals("Anão")){
            pg = 25;
        } else if(string.equals("Dahllan")){
            pg = 26;
        } else if(string.equals("Elfo")){
            pg = 27;
        } else if(string.equals("Goblin")){
            pg = 28;
        } else if(string.equals("Lefou")){
            pg = 29;
        } else if(string.equals("Minotauro")){
            pg = 30;
        } else if(string.equals("Qareen")){
            pg = 31;
        } else if(string.equals("Golem")){
            pg = 32;
        } else if(string.equals("Hynne")){
            pg = 32;
        } else if(string.equals("Kliren")){
            pg = 33;
        } else if(string.equals("Medusa")){
            pg = 33;
        } else if(string.equals("Osteon")){
            pg = 34;
        } else if(string.equals("Sereia/Tristão")){
            pg = 34;
        } else if(string.equals("Sílfide")){
            pg = 35;
        } else if(string.equals("Suraggel")){
            pg = 35;
        } else if(string.equals("Trog")){
            pg = 36;
        }
        return pg;
    }
}
