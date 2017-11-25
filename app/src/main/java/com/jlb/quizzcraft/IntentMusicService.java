package com.jlb.quizzcraft;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class IntentMusicService extends IntentService {

    static MediaPlayer player = null;
    private float mVolume = 0.5f;

    public IntentMusicService() {
        super("com.jlb.quizzcraft.IntentMusicService");

    }

    public void onCreate() {
        super.onCreate();

        if (player == null) {
            player = MediaPlayer.create(getApplicationContext(), R.raw.c418);
            player.setLooping(true);
            //player.setVolume(0.50f,0.50f);

            Log.d("LOG", "IntentMusicService : onCreate player=" + player);
        }
    }

    // Gestion de l'intent
    @Override
    protected void onHandleIntent(Intent intent) {

        // Démarre / suspend la lecture
        if (intent.hasExtra("PLAY")) {
            if (intent.getBooleanExtra("PLAY", false)) {

                // Démarrage de la lecture
                Log.d("LOG", "MusicService : START");
                player.start();

            } else {

                // Pause de la lecture
                Log.d("LOG", "MusicService : PAUSE");
                if (player.isPlaying()) {
                    player.pause();
                }
            }
            intent.removeExtra("PLAY");
        }

        // Réglage du volume de lecture
        if (intent.hasExtra("VOLUME")) {
            mVolume = Integer.parseInt(intent.getStringExtra("VOLUME")) / 100.0f;
            Log.d("LOG", "MusicService : VOLUME " + Float.toString(mVolume));
            player.setVolume(mVolume, mVolume);
            intent.removeExtra("VOLUME");
        }
    }
}
