package com.jlb.quizzcraft;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
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
    public static SharedPreferences.OnSharedPreferenceChangeListener listener;
    private boolean mMenuEnabled = false;

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

        // Nettoyage des préférences
        //PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().clear().apply();

        ApplySettings();

        // Création du listener de préférences
        mPrefs.registerOnSharedPreferenceChangeListener(

                listener = new SharedPreferences.OnSharedPreferenceChangeListener() {

                    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

                        Log.d("LOG", "MainActivity : onSharePreferenceChanged " + key);
                         ApplySettings();
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("LOG", "MainActivity : onResume");
        if (mMusicEnabled) {
            musicIntent.putExtra("PLAY", true);
            startService(musicIntent);
        }
        mMenuEnabled = false;
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("LOG", "MainActivity : onPause");
        if (! mMenuEnabled) {
            musicIntent.putExtra("PLAY", false);
            startService(musicIntent);
        }
    }

    // Gestion du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration, menu);

        Log.d("LOG", "Menu: onCreate");

        return true;
    }

    // Menu
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_settings:
                // Affiche les settings
                mMenuEnabled = true;
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

    public void ApplySettings() {

        // Fixe le niveau de difficulté
        switch (mPrefs.getString("listprefLevel", "error")) {
            case "level_noob":
                new ListOfQuestions(0);
                SettingsActivity.setDiffcultyLevelStringString("Noob");
                Log.d("LOG", "ApplySettings: niveau Noob");
                break;
            case "level_normal":
                new ListOfQuestions(1);
                SettingsActivity.setDiffcultyLevelStringString("Normal");
                Log.d("LOG", "ApplySettings: niveau Normal");
                break;
            case "level_hardcore":
                new ListOfQuestions(2);
                SettingsActivity.setDiffcultyLevelStringString("Hardcore");
                Log.d("LOG", "ApplySettings: niveau Hardcore");
                break;
            default:
                new ListOfQuestions(0);
                SettingsActivity.setDiffcultyLevelStringString("Non défini");
                Log.d("LOG", "ApplySetting: erreur niveau non défini");
        }

        // Fixe le volume
        Log.d("LOG", "ApplySettings: volume = " + mPrefs.getInt("seekbarVolume", 0));
        musicIntent.putExtra("VOLUME", Integer.toString(mPrefs.getInt("seekbarVolume", 0)));
        startService(musicIntent);

        // Configure la musique on ou off en fonction du setting
        mMusicEnabled = mPrefs.getBoolean("checkBoxMusicOnOff", true);
        if (mMusicEnabled) {
            Log.d("LOG", "ApplySettings: musique ON");
            musicIntent.putExtra("PLAY", true);
        } else {
            Log.d("LOG", "ApplySettings: musique OFF");
            musicIntent.putExtra("PLAY", false);
        }
        startService(musicIntent);
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
//DONE Rémanence des options choisies
//TODO Afficher la version de l'applications dans A propos
//DONE Ajouter un contrôle du volume de la musique
//TODO Décaler le démarrage de la musique pour réduire le ramp-up
//TODO Supprimer les infos de debug du mode Release
//TODO Ajouter une signature
//TODO Publication sur le Google Play Store
//TODO Localiser en anglais
//TODO Commenter en javadoc
