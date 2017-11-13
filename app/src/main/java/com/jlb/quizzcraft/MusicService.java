package com.jlb.quizzcraft;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    private MediaPlayer player = null;
    private static final float mVolume = 0.5f;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Active la musique
        player = MediaPlayer.create(getApplicationContext(), R.raw.c418);
        player.start();
        player.setLooping(true);
        player.setVolume(mVolume, mVolume);
        //return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }
}
