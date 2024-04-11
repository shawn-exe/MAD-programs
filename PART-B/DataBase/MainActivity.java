package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ins,display;
    TextView txt;
    EditText name,address,age;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ins = findViewById(R.id.insert);
         display = findViewById(R.id.display);

         name = findViewById(R.id.name);
         age = findViewById(R.id.age);
         address = findViewById(R.id.address);
         txt = findViewById(R.id.txt);
        ins.setOnClickListener(this);
        display.setOnClickListener(this);
    }
    @SuppressLint("Range")
    @Override
    public void onClick(View view){
        String n,a,addr;
        n = name.getText().toString();
        a = age.getText().toString();
        addr = address.getText().toString();
        Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
        try{
            db = this.openOrCreateDatabase("sample",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS TEST(name varchar(20),age varchar(20),address varchar(100))");
            Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
            if(view.getId() == ins.getId()){
                db.execSQL("INSERT INTO TEST VALUES('"+n+"','"+a+"','"+addr+"')");
                Toast.makeText(this,"successfully inserted",Toast.LENGTH_LONG).show();
            }
            if(view.getId() == display.getId()){
                String msg;
                msg="Name\t Age\t Address\n";
                Cursor c = db.rawQuery("Select * FROM TEST",null);
                if(c!=null){
                    if(c.moveToFirst()){
                        do{
                            n = c.getString(c.getColumnIndex("name"));
                            a = c.getString(c.getColumnIndex("age"));
                            addr = c.getString(c.getColumnIndex("address"));
                            msg = msg+n+'\t'+a+"\t"+addr+"\n";
                        }while(c.moveToNext());
                    }
                    txt.setText(msg);
                }
            }
        }catch(SQLException e){
            System.out.println("Create Failed");
        }finally{
            if(db!=null){
                db.close();
            }
        }
    }
}