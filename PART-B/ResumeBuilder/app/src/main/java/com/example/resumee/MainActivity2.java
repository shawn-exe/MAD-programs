package com.example.resumee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity2 extends AppCompatActivity {
    TextView name1,email1,phone1,qual1,gender1;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        name1=findViewById(R.id.name);
        email1=findViewById(R.id.email);
        phone1=findViewById(R.id.phone);
        qual1=findViewById(R.id.qual);
        gender1=findViewById(R.id.gender);
        imageView=findViewById(R.id.imgv);
        Intent i =getIntent();
        String name=i.getStringExtra("name");
        String email=i.getStringExtra("email");
        String phone=i.getStringExtra("phone");
        String qual=i.getStringExtra("qual");
        String gender=i.getStringExtra("gender");
        String imguri=i.getStringExtra("imguri");
        name1.setText(name);
        email1.setText(email);
        phone1.setText(phone);
        qual1.setText(qual);
        gender1.setText(gender);
        if(imguri!=null)
        {
            Uri uri= Uri.parse(imguri);
            imageView.setImageURI(uri);
        }
    }
}
