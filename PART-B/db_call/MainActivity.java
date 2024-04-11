package com.example.dbcall;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2;
    EditText ed1,ed2,ed3,ed4;
    SQLiteDatabase db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @SuppressLint("Range")
    @Override
    public void onClick(View view) {
        String name,usn,ph;
        usn= ed2.getText().toString();
        name= ed1.getText().toString();
        ph= ed3.getText().toString();

        try {
            db=this.openOrCreateDatabase("calldb",MODE_PRIVATE,null);
            db.execSQL("Create table if not exists test(usn varchar(20),name varchar(20),phone varchar(20));");
            if(view.getId()==b1.getId())
            {
                db.execSQL("insert into test values('"+usn+"','"+name+"','"+ph+"');");
                Toast.makeText(this, "Row inserted Successfully", Toast.LENGTH_SHORT).show();
            }
            if(view.getId()==b2.getId())
            {
                Cursor c=db.rawQuery("select * from test where usn='"+ed4.getText().toString()+"';",null);

                if(c.getCount()!=1)
                {
                    Toast.makeText(this, "invalid", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   c.moveToNext();
                   ph=c.getString(c.getColumnIndex("phone"));
                    Intent i=new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+ph));
                    startActivity(i);
                }
            }
        }
        catch (SQLiteException e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        finally {
            if(db!=null)
            {
                db.close();
            }
        }
    }
}