package com.example.battery_level;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    ProgressBar pb;
    BroadcastReceiver b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.t1);
        pb=findViewById(R.id.progressBar);
        b=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                t.setText("Battery level: "+level);
                pb.setProgress(level);
                ConstraintLayout r=findViewById(R.id.c1);
                if (level >60)
                {
                    r.setBackgroundColor(Color.GREEN);
                }
                else if (level >30)
                {
                    r.setBackgroundColor(Color.BLUE);
                }
                else
                {
                    r.setBackgroundColor(Color.RED);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(b,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(b);
    }
}