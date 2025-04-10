package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText firstNumberInput, secondNumberInput;
    Button additionButton, subtractionButton;
    TextView displayResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberInput = findViewById(R.id.firstNumberInput);
        secondNumberInput = findViewById(R.id.secondNumberInput);
        additionButton = findViewById(R.id.additionButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        displayResult = findViewById(R.id.displayResult);

        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(firstNumberInput.getText().toString());
                double num2 = Double.parseDouble(secondNumberInput.getText().toString());
                double result = num1 + num2;
                displayResult.setText("Result: " + result);
            }
        });

        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(firstNumberInput.getText().toString());
                double num2 = Double.parseDouble(secondNumberInput.getText().toString());
                double result = num1 - num2;
                displayResult.setText("Result: " + result);
            }
        });
    }
}
