package com.example.rpg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ShowFicha extends AppCompatActivity {
    Context context = ShowFicha.this;
    Bitmap bit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ficha);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ImageView imgbg = findViewById(R.id.imgbg);
        Ficha ficha = (Ficha) getIntent().getSerializableExtra("Ficha");
        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.show_ficha);
        Picasso.get().load(ficha.getLink()).into(imgbg,new com.squareup.picasso.Callback(){

            @Override
            public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) imgbg.getDrawable()).getBitmap();
                if (bitmap != null) {
                    Palette color = Palette.from(bitmap).generate();
                    int darkVibrantColor = color.getVibrantColor(getResources().getColor(R.color.colorPrimary));
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
        /*Picasso.get().load(ficha.getLink()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                imgbg.setImageBitmap(bitmap);
                bit = bitmap;
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

         */
    }
}