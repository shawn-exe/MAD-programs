package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    TextView t;
    ProgressBar p;
    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        t=findViewById(R.id.textView);
        p=findViewById(R.id.progressBar);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        T t1=new T();
        t1.execute("100");
    }
    class T extends AsyncTask<String,Integer,String>
    {

        @Override
        protected void onPreExecute(){super.onPreExecute();}
        @Override
        protected String doInBackground(String... strings){
            int max=Integer.parseInt(strings[0]);
            int i=0;
            while(i<max)
            {
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                publishProgress(i);
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values)
        {
            p.setProgress(values[0]);
            t.setText(values[0].toString());
            super.onProgressUpdate(values);
        }
    }
}