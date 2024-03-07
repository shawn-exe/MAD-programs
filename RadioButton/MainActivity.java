package com.example.radiobtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button button;
    RadioButton selectedRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        radioGroup= findViewById(R.id.rdgp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedRadioButton=(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())  ;
                String yr=selectedRadioButton.getText().toString();
                Toast.makeText(MainActivity.this, "You are "+ yr, Toast.LENGTH_SHORT).show();
            }
        });

    }
}