package com.example.emionwheels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CongratulationsActivity extends AppCompatActivity {

    private TextView congratulationsTextView;
    private Button backButton;

    private double emi; // Declare the emi variable at the class level

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        congratulationsTextView = findViewById(R.id.congratulationsTextView);
        backButton = findViewById(R.id.backButton);

        // Retrieve the selected car model from the intent
        String carModel = getIntent().getStringExtra("carModel");

        // Retrieve the EMI from the intent
        emi = getIntent().getDoubleExtra("emi", 0.0);

        // Display the congratulations message with the selected car model and EMI
        String congratulationsMessage = "Congratulations! Your EMI application for " + carModel +" has been passed!"+
                "\n\nEMI: " + (int)emi;
        congratulationsTextView.setText(congratulationsMessage);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Go back to the previous activity
            }
        });
    }

    // Override the onBackPressed method to pass the emi value back to the previous activity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("emi", emi);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
