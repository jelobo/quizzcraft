package com.jlb.quizzcraft;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class QuizzActivity extends AppCompatActivity {

    QA currentQA = new QA();
    //ListOfQuestions questionnaire = new ListOfQuestions();
    private int mReponse = 0;
    private int mEtoiles = 4;
    private int mNbQuestions = 1;
    private int mScore = 0;
    static private Intent musicIntent = null;

    private Button btn_next = null;
    private TextView textview_question = null;
    private RadioGroup radiogroup_reponses = null;
    private RadioButton radiobtn_reponse_1 = null;
    private RadioButton radiobtn_reponse_2 = null;
    private RadioButton radiobtn_reponse_3 = null;
    private RadioButton radiobtn_reponse_4 = null;
    private TextView textview_result = null;
    private RatingBar rating_bar = null;
    private ImageView image = null;

    // Listener des bouton radios liés aux réponses
    private View.OnClickListener clikListenerRadioBtn = new View.OnClickListener() {
        public void onClick(View v) {

            // Récupère l'ID du bouton radio coché
            switch (radiogroup_reponses.getCheckedRadioButtonId()) {
                case R.id.radiobtn_anwser_1:
                    mReponse = 1;
                    break;

                case R.id.radiobtn_anwser_2:
                    mReponse = 2;
                    break;

                case R.id.radiobtn_anwser_3:
                    mReponse = 3;
                    break;

                case R.id.radiobtn_anwser_4:
                    mReponse = 4;
                    break;

                default:
                    mReponse = 0;
            }

            // Réponse trouvée ?
            if (mReponse == currentQA.getResult()) {
                textview_result.setTextColor(Color.GREEN);
                textview_result.setText("Félicitations, tu as trouvé la bonne réponse !");

                // Mise à jour du score
                mScore += mEtoiles;

                // Fin de partie ?
                if (mNbQuestions == 5) {

                    // Création d'une boite de dialogue (pop-up)
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuizzActivity.this);
                    builder.setTitle("Partie terminée");
                    builder.setMessage("Votre score est de " + Integer.toString(mScore) + " / 20");
                    builder.setCancelable(false);

                    // Bouton "Rejouer"
                    builder.setPositiveButton("Rejouer", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            // Ré-initialisation des variables
                            mEtoiles = 4;
                            mNbQuestions = 0;
                            mScore = 0;

                            // Simule un click sur le bouton "Suivant" pour lancer une nouvelle partie
                            btn_next.callOnClick();

                            dialog.cancel();
                        }
                    });

                    // Bouton "Menu principal"
                    builder.setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            // Arrête la musique
                            //stopService(new Intent(getBaseContext(), MusicService.class));

                            finish();
                        }

                    }).show();

                }

                // Change le texte du bouton
                btn_next.setVisibility(View.VISIBLE);

            // Réponse incorrecte
            } else {
                textview_result.setTextColor(Color.RED);
                textview_result.setText("Ce n'est pas la bonne réponse, ré-essaie !");

                // Décrémente le rating bar
                if (mEtoiles > 0) mEtoiles--;
                rating_bar.setRating(mEtoiles);
            }
        }
    };

    // Listener du bouton "Suivant"
    public View.OnClickListener clickListenerNextBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // Mise à jour du compteur de questions
            mNbQuestions++;
            setTitle("Question " + Integer.toString(mNbQuestions) + "/5");

            // Pose une question
            currentQA = ListOfQuestions.askQuestion();
            textview_question.setText(Html.fromHtml(currentQA.getQuestion()));
            radiobtn_reponse_1.setText(Html.fromHtml(currentQA.getAnswer_1()));
            radiobtn_reponse_2.setText(Html.fromHtml(currentQA.getAnswer_2()));
            radiobtn_reponse_3.setText(Html.fromHtml(currentQA.getAnswer_3()));
            radiobtn_reponse_4.setText(Html.fromHtml(currentQA.getAnswer_4()));
            int imageId = getResources().getIdentifier(currentQA.getImage(), "drawable", "com.jlb.quizzcraft");
            image.setImageDrawable(getResources().getDrawable(imageId));

            // Dé-sélectionne les boutons radios
            radiogroup_reponses.clearCheck();

            // Ré-initialise le résultat
            textview_result.setText("");

            // Affiche 4 étoiles
            mEtoiles = 4;
            rating_bar.setRating(mEtoiles);

            // Désactive le bouton "Next"
            btn_next.setVisibility(View.INVISIBLE);

        }
    };

    // Cycle de vie
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        Log.d("LOG", "QuizzActivity: onCreate");

        // Récupératio des ID's
        btn_next = (Button) findViewById(R.id.button_next);
        textview_question = (TextView) findViewById(R.id.textview_question);
        radiogroup_reponses = (RadioGroup) findViewById(R.id.radiogroup_reponses);
        radiobtn_reponse_1 = (RadioButton) findViewById(R.id.radiobtn_anwser_1);
        radiobtn_reponse_2 = (RadioButton) findViewById(R.id.radiobtn_anwser_2);
        radiobtn_reponse_3 = (RadioButton) findViewById(R.id.radiobtn_anwser_3);
        radiobtn_reponse_4 = (RadioButton) findViewById(R.id.radiobtn_anwser_4);
        textview_result = (TextView) findViewById(R.id.textview_result);
        rating_bar = (RatingBar) findViewById(R.id.ratingbar);
        image = (ImageView) findViewById(R.id.image);

        // Listener des boutons radio
        radiobtn_reponse_1.setOnClickListener(clikListenerRadioBtn);
        radiobtn_reponse_2.setOnClickListener(clikListenerRadioBtn);
        radiobtn_reponse_3.setOnClickListener(clikListenerRadioBtn);
        radiobtn_reponse_4.setOnClickListener(clikListenerRadioBtn);

        // Listener du bouton "Suivante"
        btn_next.setOnClickListener(clickListenerNextBtn);

        // Pose une question
        currentQA = ListOfQuestions.askQuestion();
        textview_question.setText(Html.fromHtml(currentQA.getQuestion()));
        radiobtn_reponse_1.setText(Html.fromHtml(currentQA.getAnswer_1()));
        radiobtn_reponse_2.setText(Html.fromHtml(currentQA.getAnswer_2()));
        radiobtn_reponse_3.setText(Html.fromHtml(currentQA.getAnswer_3()));
        radiobtn_reponse_4.setText(Html.fromHtml(currentQA.getAnswer_4()));
        int imageId = getResources().getIdentifier(currentQA.getImage(), "drawable", "com.jlb.quizzcraft");
        image.setImageDrawable(getResources().getDrawable(imageId));

        // Dé-sélectionne les boutons radios
        radiogroup_reponses.clearCheck();

        // Ré-initialise le résultat
        textview_result.setText("");

        // Affiche 4 étoiles
        rating_bar.setRating(mEtoiles);

        // Désactive le bouton "Next"
        btn_next.setVisibility(View.INVISIBLE);

        // Crée un intent pour accéder au service de musique
        musicIntent = new Intent(this, IntentMusicService.class);

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("LOG", "QuizzActivity : onResume");

        if (MainActivity.mMusicEnabled) {
            musicIntent.putExtra("PLAY", true);
            startService(musicIntent);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("LOG", "QuizzActivity : onPause");
        if (MainActivity.mMusicEnabled) {
            musicIntent.putExtra("PLAY", false);
            startService(musicIntent);
        }
    }
}
