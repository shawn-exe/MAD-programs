package com.example.animations;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button blink,move,rotate,zoom;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        blink=findViewById(R.id.blink);
        move=findViewById(R.id.move);
        rotate=findViewById(R.id.rotate);
        zoom=findViewById(R.id.zoom);
        img=findViewById(R.id.img);

        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                img.startAnimation(animation);
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                img.startAnimation(animation);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                img.startAnimation(animation);
            }
        });

        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                img.startAnimation(animation);
            }
        });

    }
}