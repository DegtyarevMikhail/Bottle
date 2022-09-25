package com.example.bottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;

    RelativeLayout back;

    Random random;

    int lastPos;
    int rounds;
    boolean flagBottleSpinning;

    ImageView back_02, back_03,back_04,back_05, back_06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        back = findViewById(R.id.back);

        back_02 = findViewById(R.id.scrollBack_02);
        back_03 = findViewById(R.id.scrollBack_03);
        back_04 = findViewById(R.id.scrollBack_04);
        back_05 = findViewById(R.id.scrollBack_05);
        back_06 = findViewById(R.id.scrollBack_06);




        back_02.setOnClickListener(view ->{
            back.setBackgroundResource(R.drawable.back_02);
        });

        back_03.setOnClickListener(view ->{
            back.setBackgroundResource(R.drawable.back_03);
        });

        back_04.setOnClickListener(view ->{
            back.setBackgroundResource(R.drawable.back_04);
        });

        back_05.setOnClickListener(view ->{
            back.setBackgroundResource(R.drawable.back_05);
        });

        back_06.setOnClickListener(view ->{
            back.setBackgroundResource(R.drawable.back_06);
        });



        bottle = findViewById(R.id.bottle);
        rounds = 5;


        bottle.setOnClickListener(view -> {
            if (!flagBottleSpinning){

                int kol = random.nextInt(360);
            float x = bottle.getWidth() / 2;
            float y = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastPos, kol + rounds + 360, x, y);
            rotate.setDuration(4000);
            rotate.setFillAfter(true);
            bottle.startAnimation(rotate);
            lastPos = kol;
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    flagBottleSpinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    flagBottleSpinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        });

    }
}