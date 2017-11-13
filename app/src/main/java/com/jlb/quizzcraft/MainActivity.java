package com.jlb.quizzcraft;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_new_game = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuItem menuMusicEnabled = (MenuItem) findViewById(R.menu.menu_configuration);

        // Démarre la musique
        startService(new Intent(this, MusicService.class));

        // Init de la liste de questions
        new ListOfQuestions();

        btn_new_game = (Button) findViewById(R.id.btn_new_game);

        // Listener du bouton 'nouvelle partie'
        btn_new_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Lance l'activité Quizz
                Intent quizzActivityIntent = new Intent(MainActivity.this, QuizzActivity.class);
                startActivity(quizzActivityIntent);

                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration, menu);
        return true;
    }

    // Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_level:
                return true;

            case R.id.menu_music_enabled:
                if (item.isChecked()) {
                    // Met en pause la musique
                    stopService(new Intent(this, MusicService.class));

                    item.setChecked(false);
                } else {
                    // Re-démarre la musique
                    startService(new Intent(this, MusicService.class));

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
                       }}).show();

                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}

