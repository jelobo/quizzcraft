package com.jlb.quizzcraft;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.jlb.quizzcraft.R.id.image;

public class QuizzActivity extends AppCompatActivity {

    QA currentQA = new QA();
    ListOfQuestions questionnaire = new ListOfQuestions();
    private int mReponse = 0;
    private int mEtoiles = 4;
    private int mNbQuestions = 1;

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

    private View.OnClickListener clikListenerRadioBtn = new View.OnClickListener() {
        public void onClick(View v) {

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

            if (mReponse == currentQA.getResult()) {
                textview_result.setTextColor(Color.GREEN);
                textview_result.setText("Félicitations, tu as trouvé la bonne réponse !");

                // Change le texte du bouton
                btn_next.setVisibility(View.VISIBLE);
            } else {
                textview_result.setTextColor(Color.RED);
                textview_result.setText("Ce n'est pas la bonne réponse, ré-essaie !");

                if (mEtoiles > 0) mEtoiles--;
                rating_bar.setRating(mEtoiles);
            }
        }
    };

    public View.OnClickListener clickListenerNextBtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // Mise à jour du compteur de questions
            mNbQuestions++;
            setTitle("Question "+Integer.toString(mNbQuestions)+"/5");

            // Pose une question
            currentQA = questionnaire.askQuestion();
            textview_question.setText(currentQA.getQuestion());
            radiobtn_reponse_1.setText(currentQA.getAnswer_1());
            radiobtn_reponse_2.setText(currentQA.getAnswer_2());
            radiobtn_reponse_3.setText(currentQA.getAnswer_3());
            radiobtn_reponse_4.setText(currentQA.getAnswer_4());
            int imageId=getResources().getIdentifier(currentQA.getImage(), "drawable", "com.jlb.quizzcraft");
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

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
        currentQA = questionnaire.askQuestion();
        textview_question.setText(currentQA.getQuestion());
        radiobtn_reponse_1.setText(currentQA.getAnswer_1());
        radiobtn_reponse_2.setText(currentQA.getAnswer_2());
        radiobtn_reponse_3.setText(currentQA.getAnswer_3());
        radiobtn_reponse_4.setText(currentQA.getAnswer_4());
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


    }
}
