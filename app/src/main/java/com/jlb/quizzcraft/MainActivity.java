package com.jlb.quizzcraft;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.jlb.quizzcraft.R.string.btn_play_question;

public class MainActivity extends AppCompatActivity {

    QA currentQA = new QA();
    ListOfQuestions questionnaire = new ListOfQuestions();
    private int reponse = 0;

    private Button btn_play = null;
    private TextView textview_question = null;
    private RadioGroup radiogroup_reponses = null;
    private RadioButton radiobtn_reponse_1 = null;
    private RadioButton radiobtn_reponse_2 = null;
    private RadioButton radiobtn_reponse_3 = null;
    private RadioButton radiobtn_reponse_4 = null;
    private TextView textview_result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = (Button) findViewById(R.id.button_start);
        textview_question = (TextView) findViewById(R.id.textview_question);
        radiogroup_reponses = (RadioGroup) findViewById(R.id.radiogroup_reponses);
        radiobtn_reponse_1 = (RadioButton) findViewById(R.id.radiobtn_anwser_1);
        radiobtn_reponse_2 = (RadioButton) findViewById(R.id.radiobtn_anwser_2);
        radiobtn_reponse_3 = (RadioButton) findViewById(R.id.radiobtn_anwser_3);
        radiobtn_reponse_4 = (RadioButton) findViewById(R.id.radiobtn_anwser_4);
        textview_result = (TextView) findViewById(R.id.textview_result);

        // Listener du bouton 'play'
        btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (btn_play.getText().equals(getResources().getString(R.string.btn_play_question))) {
                    // Pose une question
                    currentQA = questionnaire.askQuestion();
                    textview_question.setText(currentQA.getQuestion());
                    radiobtn_reponse_1.setText(currentQA.getAnswer_1());
                    radiobtn_reponse_2.setText(currentQA.getAnswer_2());
                    radiobtn_reponse_3.setText(currentQA.getAnswer_3());
                    radiobtn_reponse_4.setText(currentQA.getAnswer_4());

                    // Dé-sélectionne les boutons radios
                    radiogroup_reponses.clearCheck();

                    // Ré-initialise le résultat
                    textview_result.setText("");

                    // Change le texte du bouton
                    btn_play.setText(R.string.btn_play_verify);

                } else {
                    switch (radiogroup_reponses.getCheckedRadioButtonId()) {
                        case R.id.radiobtn_anwser_1:
                            reponse = 1;
                            break;
                        case R.id.radiobtn_anwser_2:
                            reponse = 2;
                            break;
                        case R.id.radiobtn_anwser_3:
                            reponse = 3;
                            break;
                        case R.id.radiobtn_anwser_4:
                            reponse = 4;
                            break;

                        default:
                            reponse = 0;
                    }
                    if (reponse == currentQA.getResult()) {
                        textview_result.setTextColor(Color.GREEN);
                        textview_result.setText("Félicitations, vous avez trouvé la bonne réponse !");

                        // Change le texte du bouton
                        btn_play.setText(R.string.btn_play_question);

                    } else {
                        textview_result.setTextColor(Color.RED);
                        textview_result.setText("Désolé, ce n'était pas la bonne réponse !");

                    }
                }
            }
        });

    }
}
