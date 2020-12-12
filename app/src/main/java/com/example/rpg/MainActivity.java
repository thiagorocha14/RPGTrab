package com.example.rpg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.Menu;
import android.view.WindowManager;

import com.example.rpg.Fragments.Frag3;
import com.example.rpg.Logins.Login;
import com.example.rpg.Objects.Ficha;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Intent intent = getIntent();
        if (intent.hasExtra("Classe")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Classe");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (intent.hasExtra("Raca")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Raca");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (intent.hasExtra("Peri")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Peri");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (intent.hasExtra("Magia")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Magia");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (intent.hasExtra("Atrib")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Atrib");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (intent.hasExtra("Origem")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Origem");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        if (intent.hasExtra("Alin")){
            Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
            Fragment Frag = new Frag3();
            Bundle bundle = new Bundle();
            bundle.putString("Extra","Alin");
            bundle.putSerializable("ficha",ficha);
            Frag.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,Frag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_dice, R.id.navigation_fichas,R.id.navigation_livro).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setPositiveButton("Deslogar",dialog).setNegativeButton("Fechar a aplicação",dialog);
        alert.show();
    }
    DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                    finish();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    finish();
                    System.exit(0);
                    break;
            }
        }
    };
}