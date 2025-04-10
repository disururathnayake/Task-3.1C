package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText;
    private Button option1, option2, option3, submitButton;
    private ProgressBar progressBar;
    private int currentQuestionIndex = 0;
    private int score = 0;


    String[] questions = {
            "What is the capital of France?",
            "Which element has the chemical symbol 'O'?",
            "Who wrote the play 'Romeo and Juliet'?",
            "What is the largest planet in our solar system?",
            "What year did the Titanic sink?",
            "Which country is known as the Land of the Rising Sun?",
            "What is the hardest natural substance on Earth?",
            "Who painted the Mona Lisa?"
    };

    String[][] options = {
            {"Paris", "London", "Berlin"}, // Paris
            {"Oxygen", "Gold", "Iron"}, // Oxygen
            {"William Shakespeare", "Charles Dickens", "Jane Austen"}, // William Shakespeare
            {"Earth", "Jupiter", "Mars"}, // Jupiter
            {"1912", "1905", "1898"}, // 1912
            {"China", "Japan", "Thailand"}, // Japan
            {"Gold", "Diamond", "Iron"}, // Diamond
            {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso"} // Leonardo da Vinci
    };

    int[] correctAnswers = {0, 0, 0, 1, 0, 1, 1, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.question_text);
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        submitButton = findViewById(R.id.submit_button);
        progressBar = findViewById(R.id.progress_bar);

        loadQuestion();

        View.OnClickListener optionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableButtons();
                if (((Button)v).getText().toString().equals(options[currentQuestionIndex][correctAnswers[currentQuestionIndex]])) {
                    v.setBackgroundColor(Color.GREEN);
                    score++;
                } else {
                    v.setBackgroundColor(Color.RED);
                }
                submitButton.setEnabled(true);
            }
        };

        option1.setOnClickListener(optionClickListener);
        option2.setOnClickListener(optionClickListener);
        option3.setOnClickListener(optionClickListener);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    loadQuestion();
                } else {
                    // End of the quiz
                    String userName = getIntent().getStringExtra("USER_NAME");
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("SCORE", score);
                    intent.putExtra("QUESTIONS", questions.length);
                    intent.putExtra("USER_NAME", userName);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadQuestion() {
        questionText.setText(questions[currentQuestionIndex]);
        option1.setText(options[currentQuestionIndex][0]);
        option1.setBackgroundColor(Color.LTGRAY); // Reset color
        option2.setText(options[currentQuestionIndex][1]);
        option2.setBackgroundColor(Color.LTGRAY); // Reset color
        option3.setText(options[currentQuestionIndex][2]);
        option3.setBackgroundColor(Color.LTGRAY); // Reset color
        int progress = (currentQuestionIndex + 1) * 100 / questions.length; // Calculate progress
        progressBar.setProgress(progress);

        // Reset buttons to be clickable and enable the submit button
        resetButtons();
    }

    private void resetButtons() {
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        submitButton.setEnabled(false);
    }

    private void disableButtons() {
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
    }
}
