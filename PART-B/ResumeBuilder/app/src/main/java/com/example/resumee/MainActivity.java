package com.example.resumee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name1,email1,phone1,qual1;
    Button imgbtn,next;
    ImageView imageView;
    RadioGroup rgrp;
    RadioButton male,female;
    Uri imguri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.name);
        email1=findViewById(R.id.email);
        phone1=findViewById(R.id.phone);
        qual1=findViewById(R.id.qual);
        imgbtn=findViewById(R.id.image);
        next=findViewById(R.id.next);
        imageView=findViewById(R.id.imgv);
        rgrp=findViewById(R.id.rgrp);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name1.getText().toString();
                String email=email1.getText().toString();
                String phone= phone1.getText().toString();
                String qual=qual1.getText().toString();
                String gender=male.isChecked()?"male":"female";
                Intent i=new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("phone",phone);
                i.putExtra("qual",qual);
                i.putExtra("gender",gender);
                i.putExtra("imguri",imguri.toString());
                startActivity(i);
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(imageIntent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK && data!=null){
            imguri=data.getData();
            imageView.setImageURI(imguri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}