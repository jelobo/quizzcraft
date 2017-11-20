package com.jlb.quizzcraft;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class IntentMusicService extends IntentService {

    static MediaPlayer player = null;
    private static final float mVolume = 0.5f;

    public  IntentMusicService() {
        super("com.jlb.quizzcraft.IntentMusicService");

    }

    public void onCreate() {
        super.onCreate();

        if (player == null) {
            player = MediaPlayer.create(getApplicationContext(), R.raw.c418);
            player.setLooping(true);
            player.setVolume(0.50f,0.50f);

            Log.d("LOG", "IntentMusicService : onCreate player=" + player);
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
         Log.d("LOG", "MusicService : Commande " + intent.getStringExtra("PLAYER_COMMAND"));
         String mCmd = intent.getStringExtra("PLAYER_COMMAND");
         switch (mCmd) {

             case "START":
                 player.start();
                 break;

             case "STOP":
                 player.stop();
                 player.release();
                 break;

             case "PAUSE":
                 if (player.isPlaying())
                     player.pause();
                 break;

             default:
                 Log.d("LOG", "MusicService : Erreur: commande non reconnue (" + intent.getStringExtra("PLAYER_COMMAND")+ ")");
                 break;
         }
     }
}
