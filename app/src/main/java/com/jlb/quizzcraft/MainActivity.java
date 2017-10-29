package com.jlb.quizzcraft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//   QA currentQA = new QA();
//   ListOfQuestions questionnaire = new ListOfQuestions();
//    private int reponse = 0;

    private Button btn_new_game = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_new_game = (Button) findViewById(R.id.btn_new_game);

        // Listener du bouton 'nouvelle partie'
        btn_new_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent quizzActivityIntent = new Intent(MainActivity.this, QuizzActivity.class);
                startActivity(quizzActivityIntent);

                finish();
            }
        });

    }
}

