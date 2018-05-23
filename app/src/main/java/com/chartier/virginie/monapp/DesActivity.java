package com.chartier.virginie.monapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class DesActivity extends AppCompatActivity {

    private ImageView mDes;
    private Button mRoll;
    private Random r = new Random();
    private int rollNbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);

        this.configureWidgets();
        this.configureRollButtonOnClick();
    }


    private void configureWidgets() {
        mDes = findViewById(R.id.des_img);
        mRoll = findViewById(R.id.roll_btn);
    }


    private void configureRollButtonOnClick(){
        mRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollNbr = r.nextInt(6) + 1;
                if (rollNbr == 1){
                    mDes.setImageResource(R.drawable.a);
                }
                else if (rollNbr ==2){
                    mDes.setImageResource(R.drawable.b);
                }
                else if (rollNbr ==3){
                    mDes.setImageResource(R.drawable.c);
                }
                else if (rollNbr ==4){
                    mDes.setImageResource(R.drawable.d);
                }
                else if (rollNbr ==5){
                    mDes.setImageResource(R.drawable.e);
                }
                else if (rollNbr ==6){
                    mDes.setImageResource(R.drawable.f);
                }
                Toast.makeText(getApplicationContext(), "Rolled !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
