package com.chartier.virginie.monapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private Animation anim;
    private TextView mTitle;
    private TextView mNbr;
    private TextView mText;
    private Button mGo;
    private Button mReset;
    private int nbrClic = 0; //Nombre de clic sur le bouton
    private Button mGo2;
    private Button mGo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureWidgets();
        this.configureAnimation();
        this.configureResetButtonOnClick();
        this.configureGoButtonOnClick();
        this.configureGo2ButtonOnClick();
        this.configureGo3ButtonOnClick();
    }


    private void configureWidgets(){
        mTitle = findViewById(R.id.title_txt);
        mNbr = findViewById(R.id.nbr_txt);
        mText = findViewById(R.id.text_txt);
        mGo = findViewById(R.id.go_btn);
        mReset = findViewById(R.id.reset_btn);
        mGo2 = findViewById(R.id.go2_btn);
        mGo3 = findViewById(R.id.go3_btn);

    }


    private void configureAnimation(){
        this.mp = MediaPlayer.create(this, R.raw.smb_coin);
        this.anim = new AlphaAnimation(0.0f, 1.0f);
    }


    private void configureResetButtonOnClick(){
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbrClic = 0;
                mNbr.setText(String.valueOf(nbrClic));
                mText.setText("Appuie sur le bouton !");
                mGo.setEnabled(true);
                mReset.setVisibility(View.GONE);
                mTitle.setTextColor(getResources().getColor(R.color.white));
                mText.clearAnimation();
            }
        });
    }


    private void configureGoButtonOnClick(){
        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbrClic++; //Incrémente le nombre de clics
                mNbr.setText(String.valueOf(nbrClic));
                if (nbrClic == 10) {
                    mText.setText("Le jeu est terminé !");
                    mGo.setEnabled(false);//Désactivation du bouton
                    mReset.setVisibility(View.VISIBLE);
                    mTitle.setTextColor(getResources().getColor(R.color.colorPrimary));
                    anim.setDuration(500); // Gestion du clignotement avec ce paramètre
                    anim.setStartOffset(20);
                    anim.setRepeatMode(Animation.REVERSE);
                    anim.setRepeatCount(Animation.INFINITE);
                    mText.startAnimation(anim);
                    mReset.setText("RESET");
                }
                mp.start();
                Toast.makeText(getApplicationContext(), " + 1", Toast.LENGTH_SHORT).show();
                Log.e("Tag", "le contenu de mon TextView est : " + mText.getText().toString());
            }
        });
    }


    private void configureGo2ButtonOnClick(){
        mGo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, LoveCalculActivity.class);
                startActivity(mIntent);
            }
        });
    }


    private void configureGo3ButtonOnClick(){
        mGo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, DesActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
