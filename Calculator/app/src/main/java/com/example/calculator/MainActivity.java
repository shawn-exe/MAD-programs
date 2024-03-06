package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,sum,difference,multiplication,division,reset;
    EditText num1,num2;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button10);
        sum = findViewById(R.id.sum);
        reset = findViewById(R.id.button16);
        difference = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        num1 =  findViewById(R.id.editTextNumber);
        num2 =  findViewById(R.id.editTextNumber2);
        ans =  findViewById(R.id.ans);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1.setText("0");
                num2.setText("0");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("0");
                }else{
                    num1.setText("0");
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("1");
                }else{
                    num1.setText("1");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("2");
                }else{
                    num1.setText("2");
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("3");
                }else{
                    num1.setText("3");
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("4");
                }else{
                    num1.setText("4");
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("5");
                }else{
                    num1.setText("5");
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("6");
                }else{
                    num1.setText("6");
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("7");
                }else{
                    num1.setText("7");
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("8");
                }else{
                    num1.setText("8");
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().length()>0){
                    num2.setText("9");
                }else{
                    num1.setText("0");
                }
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1,n2;
                if(num1.getText().toString()==""){
                    n1=0;
                }else{
                    n1 =Integer.parseInt(num1.getText().toString()) ;
                }
                if(num2.getText().toString()==""){
                    n2=0;
                }else{
                    n2 =Integer.parseInt( num2.getText().toString());
                }


                String answer = String.valueOf(n1+n2);
                ans.setText(answer);

            }
        });

        difference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1,n2;
                if(num1.getText().toString()==""){
                    n1=0;
                }else{
                    n1 =Integer.parseInt(num1.getText().toString()) ;
                }
                if(num2.getText().toString()==""){
                    n2=0;
                }else{
                    n2 =Integer.parseInt( num2.getText().toString());
                }
                String answer = String.valueOf(n1-n2);
                ans.setText(answer);

            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1,n2;
                if(num1.getText().toString()==""){
                    n1=0;
                }else{
                    n1 =Integer.parseInt(num1.getText().toString()) ;
                }
                if(num2.getText().toString()==""){
                    n2=0;
                }else{
                    n2 =Integer.parseInt( num2.getText().toString());
                }
                String answer = String.valueOf(n1*n2);
                ans.setText(answer);

            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer;
                int n1,n2;
                if(num1.getText().toString()==""){
                    n1=0;
                }else{
                    n1 =Integer.parseInt(num1.getText().toString()) ;
                }
                if(num2.getText().toString()==""){
                    n2=0;
                }else{
                    n2 =Integer.parseInt( num2.getText().toString());
                }
                if(n2==0){
                    answer="divide by zero";
                }else{
                    answer = String.valueOf(n1/n2);
                }
                ans.setText(answer);

            }
        });

    }

}