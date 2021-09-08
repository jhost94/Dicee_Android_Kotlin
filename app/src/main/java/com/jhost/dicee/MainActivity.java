package com.jhost.dicee;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random rng = new Random();
    private int[] dices;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dices = new int[]{
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        Button rollBtn = findViewById(R.id.rollbutton);
        ImageView leftDice = findViewById(R.id.leftDice);
        ImageView rightDice = findViewById(R.id.rightDice);

        setRandomDice(leftDice);
        setRandomDice(rightDice);

        rollBtn.setOnClickListener((event) -> {
            setRandomDice(leftDice);
            setRandomDice(rightDice);
        });
    }

    private void setRandomDice(ImageView iv) {
        iv.setImageResource(dices[rng.nextInt(dices.length)]);
    }
}