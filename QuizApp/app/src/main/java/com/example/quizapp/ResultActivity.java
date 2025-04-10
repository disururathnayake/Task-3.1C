package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView scoreText;
    private Button retakeButton, finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        scoreText = findViewById(R.id.score_text);
        retakeButton = findViewById(R.id.retake_quiz_button);
        finishButton = findViewById(R.id.finish_button);


        int score = getIntent().getIntExtra("SCORE", 0);
        int questions = getIntent().getIntExtra("QUESTIONS", 0);
        String userName = getIntent().getStringExtra("USER_NAME");  // Retrieve the user's name


        scoreText.setText("Score: " + score + "/" + questions + " - " + userName);


        retakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.putExtra("USER_NAME", userName);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}
