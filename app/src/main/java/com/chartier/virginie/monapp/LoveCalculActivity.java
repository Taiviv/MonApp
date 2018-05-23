package com.chartier.virginie.monapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

public class LoveCalculActivity extends AppCompatActivity {

    private EditText mPrenomF;
    private EditText mPrenommH;
    private TextView mResultat;
    private Button mCalcul;
    private ImageView mCoeur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_calcul);

        this.configureWidgets();
        this.configureCalculButtonOnClick();
        this.configureImageView();
    }


    private void configureWidgets() {
         mPrenomF = findViewById(R.id.prenomf_txt);
         mPrenommH = findViewById(R.id.prenomh_txt);
         mResultat = findViewById(R.id.resultat_txt);
         mCalcul = findViewById(R.id.calcul_btn);
         mCoeur = findViewById(R.id.coeur_png);
    }


    private void configureCalculButtonOnClick(){
        mCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mPrenomF.getText().toString().equals("")
                        && !mPrenommH.getText().toString().equals("")){
                    String female = mPrenomF.getText().toString();
                    String male = mPrenommH.getText().toString();
                    Calendar c = Calendar.getInstance();
                    String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    String month = String.valueOf(c.get(Calendar.MONTH));
                    String year = String.valueOf(c.get(Calendar.YEAR));
                    String result_string = female+male+day+month+year;
                    result_string = result_string.toLowerCase();
                    result_string = result_string.trim();
                    int seed = result_string.hashCode();
                    Random r = new Random(seed);
                    mResultat.setText((r.nextInt(100)+1)+"%");
                }
            }
        });
    }


    private void configureImageView(){
        mCoeur.setAlpha(110); //value: [0-255]. 0 is fully transparent and 255 is fully opaque.
    }
}
