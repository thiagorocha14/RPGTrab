package com.example.rpg.Criation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rpg.Atributos.Atributo;
import com.example.rpg.BD;
import com.example.rpg.Ficha;
import com.example.rpg.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Pericias extends AppCompatActivity {

    private String Pericia;
    Ficha ficha;
    Uri uri;
    String url  = "";
    private static final int SELECT_IMAGE = 1;
    private StorageReference storageReference;
    String[] listabase = new String[2];
    String specialperi = "";
    TextView txtTitu;
    Integer[] quantidade = new Integer[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pericias);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txtTitu = findViewById(R.id.txtPericias);
        final Button btnPeri1 = findViewById(R.id.btnPeri1);
        final Button btnPeri2 = findViewById(R.id.btnPeri2);
        btnPeri1.setVisibility(View.INVISIBLE);
        btnPeri2.setVisibility(View.INVISIBLE);
        final TextView txtAvanc = findViewById(R.id.txtEnd);
        ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        Atributo atributo = ficha.getAtributo();
        storageReference = FirebaseStorage.getInstance().getReference("uploads");
        quantidade[0] = Integer.parseInt(atributo.getModInt());
        if (quantidade[0] <0){
            quantidade[0] = 0;
        }
        final String classe = ficha.getClasse();
        final ListView listperi = (ListView) findViewById(R.id.listperi);
        final String[] listapericias = getResources().getStringArray(R.array.pericias);
        if(classe.equals("Bucaneiro")||classe.equals("Caçador")||classe.equals("Guerreiro")||classe.equals("Nobre")){
            txtTitu.setText("Como você escolheu "+classe+" você tem que escolher uma dessas perícias para treinar.");
            btnPeri1.setVisibility(View.VISIBLE);
            btnPeri2.setVisibility(View.VISIBLE);
            listperi.setVisibility(View.INVISIBLE);
            txtAvanc.setVisibility(View.INVISIBLE);
            final String peri1,peri2;
            if (classe.equals("Nobre")){
                peri1 = "Diplomacia";
                peri2 = "Intimidação";
                btnPeri1.setText(peri1);
                btnPeri2.setText(peri2);
            }else{
                peri1 = "Luta";
                peri2 = "Pontaria";
                btnPeri1.setText(peri1);
                btnPeri2.setText(peri2);
            }
            btnPeri1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    specialperi = peri1;
                    getPeri(classe);
                    btnPeri1.setVisibility(View.INVISIBLE);
                    btnPeri2.setVisibility(View.INVISIBLE);
                    listperi.setVisibility(View.VISIBLE);
                    txtAvanc.setVisibility(View.VISIBLE);
                    listperi.setAdapter(new ArrayAdapter<String>(Pericias.this, R.layout.layout_list_magias, listapericias));
                    listperi.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                    for(int i = 0;i<listabase.length;i++){
                        for(int o = 0;o<listapericias.length;o++){
                            if(listabase[i].equals(listapericias[o])){
                                listperi.setItemChecked(o,true);
                            }
                        }
                    }
                }
            });
            btnPeri2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    specialperi = peri2;
                    getPeri(classe);
                    btnPeri1.setVisibility(View.INVISIBLE);
                    btnPeri2.setVisibility(View.INVISIBLE);
                    listperi.setVisibility(View.VISIBLE);
                    txtAvanc.setVisibility(View.VISIBLE);
                    listperi.setAdapter(new ArrayAdapter<String>(Pericias.this, R.layout.layout_list_magias, listapericias));
                    listperi.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                    for(int i = 0;i<listabase.length;i++){
                        for(int o = 0;o<listapericias.length;o++){
                            if(listabase[i].equals(listapericias[o])){
                                listperi.setItemChecked(o,true);
                            }
                        }
                    }
                }
            });
        }else{
            getPeri(classe);
            listperi.setAdapter(new ArrayAdapter<String>(Pericias.this, R.layout.layout_list_magias, listapericias));
            listperi.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            for(int i = 0;i<listabase.length;i++){
                for(int o = 0;o<listapericias.length;o++){
                    if(listabase[i].equals(listapericias[o])){
                        listperi.setItemChecked(o,true);
                    }
                }
            }
        }
        listperi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(quantidade[0] == 0){
                    if(adapterView.getItemAtPosition(i).equals(listabase[0])||adapterView.getItemAtPosition(i).equals(listabase[1])){
                        listperi.setItemChecked(i,true);
                        Toast.makeText(getBaseContext(), "Essas perícias são da sua classe.", Toast.LENGTH_SHORT).show();
                    }else if(listperi.isItemChecked(i)){
                        listperi.setItemChecked(i,false);
                        Toast.makeText(getBaseContext(), "Suas perícias acabaram :(", Toast.LENGTH_SHORT).show();
                    }else{
                        quantidade[0]++;
                        txtTitu.setText("Você tem "+ quantidade[0].toString()+" perícias pra treinar");
                    }
                }else{
                    if(adapterView.getItemAtPosition(i).equals(listabase[0])||adapterView.getItemAtPosition(i).equals(listabase[1])){
                        listperi.setItemChecked(i,true);
                        Toast.makeText(getBaseContext(), "Essas perícias são da sua classe", Toast.LENGTH_SHORT).show();
                    }else if(listperi.isItemChecked(i)){
                        quantidade[0]--;
                        txtTitu.setText("Você tem "+ quantidade[0].toString()+" perícias pra treinar");
                    }else{
                        quantidade[0]++;
                        txtTitu.setText("Você tem "+ quantidade[0].toString()+" perícias pra treinar");
                    }
                }
            }
        });
        txtAvanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantidade[0]==0){
                    Pericia = new String();
                    SparseBooleanArray a = listperi.getCheckedItemPositions();
                    for (int i = 0; i < listapericias.length; i++) {
                        if (a.get(i)) {
                            Pericia = Pericia +"\n"+ (String) listperi.getAdapter().getItem(i);
                        }
                    }
                    ficha.setPericia(Pericia);
                    if(classe.equals("Arcanista")||classe.equals("Bardo")||classe.equals("Clérigo")||classe.equals("Druida")){
                        Intent intent = new Intent(getApplicationContext(), ListMagias.class);
                        intent.putExtra("Ficha",ficha);
                        startActivity(intent);
                        finish();
                    }else{
                        AlertDialog.Builder alert = new AlertDialog.Builder(Pericias.this);
                        alert.setTitle("Deseja enviar uma imagem do seu personagem?").setPositiveButton("Sim",dialog).setNegativeButton("Não",dialog);
                        alert.show();
                    }
                }else{
                    Toast.makeText(getBaseContext(), "Você ainda tem perícias pra treinar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void selecimg() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,SELECT_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            StorageReference arqRef = storageReference.child(System.currentTimeMillis()+"."+extensao(uri));
            arqRef.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful());
                            Uri downloadUrl = urlTask.getResult();
                            url = downloadUrl.toString();
                            ficha.setLink(url);
                            BD.enviar(ficha);
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            finish();
                        }
                    });
        }
    }
    DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    selecimg();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    BD.enviar(ficha);
                    finish();
                    break;
            }
        }
    };
    private String extensao(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
    public void getPeri(String classe){
        if(classe.equals("Arcanista")){
            listabase[0] = "Misticismo";
            listabase[1] = "Vontade";
            quantidade[0] = quantidade[0] +1;
        } else if(classe.equals("Bárbaro")){
            listabase[0] = "Fortitude";
            listabase[1] = "Luta";
            quantidade[0] = quantidade[0] +4;
        } else if(classe.equals("Bardo")){
            listabase[0] = "Atuação";
            listabase[1] = "Reflexos";
            quantidade[0] = quantidade[0] +6;
        } else if(classe.equals("Bucaneiro")){
            //listabase[0] = "Luta";
            listabase[0] = specialperi;
            listabase[1] = "Reflexos";
            quantidade[0] = quantidade[0] +4;
        } else if(classe.equals("Caçador")){
            //listabase[0] = "Luta";
            listabase[0] = specialperi;
            listabase[1] = "Sobrevivência";
            quantidade[0] = quantidade[0] +6;
        } else if(classe.equals("Cavaleiro")){
            listabase[0] = "Fortitude";
            listabase[1] = "Luta";
            quantidade[0] = quantidade[0] +2;
        } else if(classe.equals("Clérigo")){
            listabase[0] = "Religião";
            listabase[1] = "Vontade";
            quantidade[0] = quantidade[0] +2;
        } else if(classe.equals("Druida")){
            listabase[0] = "Sobrevivência";
            listabase[1] = "Vontade";
            quantidade[0] = quantidade[0] +4;
        } else if(classe.equals("Guerreiro")){
            listabase[0] = specialperi;
            //listabase[1] = "Pontaria";
            listabase[1] = "Fortitude";
            quantidade[0] = quantidade[0] +2;
        } else if(classe.equals("Inventor")){
            listabase[0] = "Ofício";
            listabase[1] = "Vontade";
            quantidade[0] = quantidade[0] +4;
        } else if(classe.equals("Ladino")){
            listabase[0] = "Ladinagem";
            listabase[1] = "Reflexos";
            quantidade[0] = quantidade[0] +8;
        } else if(classe.equals("Lutador")){
            listabase[0] = "Fortitude";
            listabase[1] = "Luta";
            quantidade[0] = quantidade[0] +4;
        } else if(classe.equals("Nobre")){
            listabase[0] = specialperi;
            //listabase[1] = "Intimidação";
            listabase[1] = "Vontade";
            quantidade[0] = quantidade[0] +4;
        } else if(classe.equals("Paladino")){
            listabase[0] = "Luta";
            listabase[1] = "Vontade";
            quantidade[0] = quantidade[0] +2;
        }
        txtTitu.setText("Você tem "+ quantidade[0].toString()+" perícias pra treinar");
    }
}