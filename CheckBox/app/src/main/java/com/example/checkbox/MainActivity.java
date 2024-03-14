package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox idli,vada,tea,coffee;
    Button b;
    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        idli=findViewById(R.id.c1);
        vada=findViewById(R.id.c2);
        tea=findViewById(R.id.c3);
        coffee=findViewById(R.id.c4);
        b=findViewById(R.id.button);
        txtv=findViewById(R.id.txtv);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total=0;
                StringBuilder result=new StringBuilder();
                result.append("Ordered items are:");
                if(idli.isChecked()){
                    total+=80;
                    result.append("\nIdli - 80rs");
                }
                if(vada.isChecked()){
                    total+=90;
                    result.append("\nvada - 90rs");
                }
                if(tea.isChecked()){
                    total+=20;
                    result.append("\ntea - 20rs");
                }
                if(coffee.isChecked()){
                    total+=30;
                    result.append("\ncoffee - 30rs");
                }
                result.append("\nTotal= "+total);
                txtv.append(result.toString());
            }
        });
    }
}