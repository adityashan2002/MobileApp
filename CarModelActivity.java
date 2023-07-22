package com.example.emionwheels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CarModelActivity extends AppCompatActivity {

    private Button car1Button, car2Button, car3Button, car4Button, car5Button, backButton;
    private double principalAmount;
    private int loanTerm;
    private double interestRate;
    private double emi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model);

        car1Button = findViewById(R.id.car1Button);
        car2Button = findViewById(R.id.car2Button);
        car3Button = findViewById(R.id.car3Button);
        car4Button = findViewById(R.id.car4Button);
        car5Button = findViewById(R.id.car5Button);
        backButton = findViewById(R.id.backButton);

        principalAmount = getIntent().getDoubleExtra("principalAmount", 0.0);
        loanTerm = getIntent().getIntExtra("loanTerm", 0);
        interestRate = getIntent().getDoubleExtra("interestRate", 0.0);
        emi = getIntent().getDoubleExtra("emi", 0.0); // Retrieve the emi value from the intent

        car1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCongratulationsActivity("Skoda", emi); // Pass the emi value to the method
            }
        });

        car2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCongratulationsActivity("Mercedes", emi); // Pass the emi value to the method
            }
        });

        car3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCongratulationsActivity("Ford", emi); // Pass the emi value to the method
            }
        });

        car4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCongratulationsActivity("B.M.W", emi); // Pass the emi value to the method
            }
        });

        car5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToCongratulationsActivity("Ferrari", emi); // Pass the emi value to the method
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Go back to the previous activity
            }
        });
    }

    private void navigateToCongratulationsActivity(String carModel, double emi) {
        Intent intent = new Intent(CarModelActivity.this, CongratulationsActivity.class);
        intent.putExtra("carModel", carModel);
        intent.putExtra("emi", emi); // Pass the emi value to the CongratulationsActivity
        startActivity(intent);
    }
}
