package com.example.lifecycle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "onCreate invoked");
        Toast.makeText(MainActivity.this, "on create phase", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart invoked");
        Toast.makeText(MainActivity.this, "on start phase", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop invoked");
        Toast.makeText(MainActivity.this, "on stop phase", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause invoked");
        Toast.makeText(MainActivity.this, "on pause phase", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart invoked");
        Toast.makeText(MainActivity.this, "on restart phase",
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume invoked");
        Toast.makeText(MainActivity.this, "on resume phase", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy invoked");
        Toast.makeText(MainActivity.this, "on destroy phase",
                Toast.LENGTH_LONG).show();
    }
}
