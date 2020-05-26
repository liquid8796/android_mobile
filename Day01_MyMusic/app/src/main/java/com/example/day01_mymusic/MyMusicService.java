package com.example.day01_mymusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicService extends Service {
    MediaPlayer mp_Object;
    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp_Object = MediaPlayer.create(this, R.raw.sail);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(flags == 0){
            mp_Object.start();
        }else{
            mp_Object.pause();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp_Object.release();
    }
}
