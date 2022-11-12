package com.example.android_hw_3;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;


import de.hdodenhof.circleimageview.CircleImageView;


public class Activity_game extends AppCompatActivity {

    private CircleImageView game_IMG_picture;
    private MaterialTextView game_LBL_score;
    private ArrayList<MaterialButton> game_BTN_answers;

    GameManager gameManager;


    public void openScorePage() {
        Intent intent = new Intent(this, Activity_score.class);
        intent.putExtra(Activity_score.KEY_SCORE, gameManager.getScore());
        long duration = gameManager.getEndTime() - gameManager.getStartTime();
        intent.putExtra(Activity_score.KEY_DURATION, (gameManager.getEndTime() - gameManager.getStartTime()));
        startActivity(intent);
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void refreshUI() {
        if (gameManager.isEndGame()) {
            gameManager.setEndTime();
            openScorePage();
        } else {
            game_IMG_picture.setImageResource(gameManager.getCurrentImg());
            game_LBL_score.setText("" + gameManager.getScore());
            gameManager.setTextButtons(game_BTN_answers);
        }
    }


    private void clicked(String answer) {
        gameManager.checkAnswer(answer);
        refreshUI();
    }

    private void initViews() {

        gameManager.setTextButtons(game_BTN_answers);

        game_BTN_answers.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(game_BTN_answers.get(0).getText().toString());
            }
        });
        game_BTN_answers.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(game_BTN_answers.get(1).getText().toString());
            }
        });
        game_BTN_answers.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(game_BTN_answers.get(2).getText().toString());
            }
        });
        game_BTN_answers.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked(game_BTN_answers.get(3).getText().toString());
            }
        });
    }


    private void findViews() {
        game_IMG_picture = findViewById(R.id.game_IMG_picture);
        game_LBL_score = findViewById(R.id.game_LBL_score);


        game_BTN_answers = new ArrayList<>();
        game_BTN_answers.add(findViewById(R.id.game_BTN_answer_a));
        game_BTN_answers.add(findViewById(R.id.game_BTN_answer_b));
        game_BTN_answers.add(findViewById(R.id.game_BTN_answer_c));
        game_BTN_answers.add(findViewById(R.id.game_BTN_answer_d));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameManager = new GameManager();
        findViews();
        initViews();
        refreshUI();
    }


}