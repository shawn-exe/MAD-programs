package com.example.sms;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        b=findViewById(R.id.button);

         b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ph=ed1.getText().toString();
                String msg=ed2.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:"+ph));
                i.putExtra("sms_body",msg);
                startActivity(i);
            }
        });
    }
}
