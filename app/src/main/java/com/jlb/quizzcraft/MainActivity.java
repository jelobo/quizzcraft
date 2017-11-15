package com.jlb.quizzcraft;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
    static public Intent musicIntent = null;

     // Cycle de vie
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");

        // Démarre la musique
        musicIntent = new Intent(this, MusicService.class);

        // Init de la liste de questions
        new ListOfQuestions(0);

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

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("MainActivity", "onResume");
        if (mMusicEnabled) {
            startService(musicIntent);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("MainActivity", "onPause");
        if (mMusicEnabled ) {
            stopService(musicIntent);
        }
    }

    // Gestion du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration, menu);
        return true;
    }

    // Menu

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_level_noob:
                // Niveau de difficulté Noob
                new ListOfQuestions(0);
                item.setChecked(true);
                return true;

            case R.id.menu_level_average:
                // Niveau de difficulté Moyen
                new ListOfQuestions(1);
                item.setChecked(true);
                return true;

            case R.id.menu_level_hardcore:
                // Niveau de difficulté Hardcore
                new ListOfQuestions(2);
                item.setChecked(true);
                return true;

            case R.id.menu_music_enabled:
                if (item.isChecked()) {
                    // Met en pause la musique
                     stopService(musicIntent);

                    mMusicEnabled = false;
                    item.setChecked(false);
                } else {
                    // Re-démarre la musique
                    startService(musicIntent);

                    mMusicEnabled = true;
                    item.setChecked(true);
                }
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
