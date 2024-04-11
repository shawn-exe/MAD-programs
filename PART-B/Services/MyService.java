package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    MediaPlayer music;
    @Override
    public void onCreate()
    {
        super.onCreate();
        music=MediaPlayer.create(this,R.raw.a);
    }
    @Override
    public  void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
        music.start();
    }
    @Override
    public  void onDestroy()
    {
        super.onDestroy();
        music.stop();
    }

    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}