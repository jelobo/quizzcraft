package com.jlb.quizzcraft;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_new_game = null;
    static public boolean mMusicEnabled = true;
    static private Intent musicIntent = null;
    private SharedPreferences mPrefs = null;
    //public static MediaPlayer player = null;
    public static SharedPreferences.OnSharedPreferenceChangeListener listener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LOG", "MainActivity: onCreate");

        // Crée un intent pour accéder au service de musique
        musicIntent = new Intent(this, IntentMusicService.class);

        btn_new_game = (Button) findViewById(R.id.btn_new_game);

        // Listener du bouton 'nouvelle partie'
        btn_new_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Lance l'activité Quizz
                Intent quizzActivityIntent = new Intent(MainActivity.this, QuizzActivity.class);
                startActivity(quizzActivityIntent);

                //finish();
            }
        });

        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Set le niveau de difficulté
        switch (mPrefs.getString("listprefLevel", "error")) {
            case "level_noob":
                new ListOfQuestions(0);
                break;
            case "level_normal":
                new ListOfQuestions(1);
                break;
            case "level_hardcore":
                new ListOfQuestions(2);
                break;
            default:
                new ListOfQuestions(0);
                Log.d("LOG", "MainActivity : listprefLevel error");
        }

        // Configure la musique on ou off en fonction du setting
        mMusicEnabled = mPrefs.getBoolean("checkBoxMusicOnOff", true);
        if (mMusicEnabled) {
            musicIntent.putExtra("PLAYER_COMMAND", "START");
        } else {
            musicIntent.putExtra("PLAYER_COMMAND", "PAUSE");

        }
        startService(musicIntent);

        mPrefs.registerOnSharedPreferenceChangeListener(
                //new SharedPreferences.OnSharedPreferenceChangeListener() {
                listener = new SharedPreferences.OnSharedPreferenceChangeListener() {

                    public void onSharedPreferenceChanged(
                            SharedPreferences prefs, String key) {

                        Log.d("LOG", "MainActivity : onSharePreferenceChanged " + key);

                        switch (key) {
                            case "checkBoxMusicOnOff":
                                if (!mPrefs.getBoolean("checkBoxMusicOnOff", true)) {
                                    // Met en pause la musique
                                    //musicIntent.putExtra("PLAYER_COMMAND", "PAUSE");

                                    Log.d("LOG", "MainActivity : Music disabled " + key);
                                    mMusicEnabled = false;
                                } else {
                                    // Re-démarre la musique
                                    //musicIntent.putExtra("PLAYER_COMMAND", "START");

                                    Log.d("LOG", "MainActivity : Music enabled " + key);
                                    mMusicEnabled = true;
                                }
                                //startService(musicIntent);

                                break;

                            case "listprefLevel":
                                switch (mPrefs.getString("listprefLevel", "error")) {
                                    case "level_noob":
                                        new ListOfQuestions(0);
                                        break;
                                    case "level_normal":
                                        new ListOfQuestions(1);
                                        break;
                                    case "level_hardcore":
                                        new ListOfQuestions(2);
                                        break;
                                    default:
                                            Log.d("LOG", "MainActivity : listprefLevel error");
                                }

                        }

                    }
                });

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("LOG", "MainActivity : onResume");
        if (mMusicEnabled) {
            musicIntent.putExtra("PLAYER_COMMAND", "START");
            startService(musicIntent);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("LOG", "MainActivity : onPause");
        //if (mMusicEnabled) {
        musicIntent.putExtra("PLAYER_COMMAND", "PAUSE");
        startService(musicIntent);
        //}
    }

    // Gestion du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration, menu);

        Log.d("LOG", "MainActivity : Menu: onCreate");

        return true;
    }

    // Menu
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_settings:
                // Affiche les settings
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);

                return true;

            case R.id.menu_apropos:
                // Création d'une boite de dialogue (pop-up)
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("A propos");
                builder.setMessage("Nombre de questions: " + ListOfQuestions.getNbOfQuestions() + "\nDéveloppeurs: Jelobo & Rombol");
                builder.setCancelable(false);

                // Bouton "OK"
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();

                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}

//DONE En fin de partie, ajouter un bouton pour revenir au premier écran
//TODO En fin de partie, afficher le nobmre de parties jouées et le total des points
//TODO Emettre un son lorsque bonne ou mauvaise répoonse
//TODO Ajouter des icônes dans les menus
//DONE Suspendre la musisque lorsque l'application n'est plus active
//TODO Libérer explicitement les ressources en sortie
//TODO Support d'Android Froyo
//TODO Adapter les images pour de petits écrans
//TODO Ajouter un effet sur le bouton "Nouvelle partie"
//TODO Modifier l'image du bouton "Nouvelle partie"
//TODO Rémanence des options choisies
//TODO Afficher la version de l'applications dans A propos
//TODO Ajouter un contrôle du volume de la musique
//TODO Décaler le démarrage de la musique pour réduire le ramp-up
//TODO Supprimer les infos de debug du mode Release
//TODO Ajouter une signature
//TODO Publication sur le Google Play Store
//TODO Localiser en anglais
//TODO Commenter en javadoc
