package com.example.emionwheels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BankSelectionActivity extends AppCompatActivity {

    private Button bank1Button, bank2Button, bank3Button, bank4Button, bank5Button,backButton;

    private double principalAmount;
    private int loanTerm;
    private double interestRate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_selection);

        bank1Button = findViewById(R.id.bank1Button);
        bank2Button = findViewById(R.id.bank2Button);
        bank3Button = findViewById(R.id.bank3Button);
        bank4Button = findViewById(R.id.bank4Button);
        bank5Button = findViewById(R.id.bank5Button);
        backButton = findViewById(R.id.backButton);

        // Retrieve the values passed from EmiCalculationActivity
        principalAmount = getIntent().getDoubleExtra("principalAmount", 0.0);
        loanTerm = getIntent().getIntExtra("loanTerm", 0);
        interestRate = getIntent().getDoubleExtra("interestRate", 0.0);

        bank1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the interest rate for Bank 1 (modify the value as per your requirement)
                double bankInterestRate = 5.0;

                // Calculate the EMI
                double emi = calculateEmi(principalAmount, bankInterestRate, loanTerm);

                // Start CarModelActivity and pass the necessary values
                Intent intent = new Intent(BankSelectionActivity.this, CarModelActivity.class);
                intent.putExtra("principalAmount", principalAmount);
                intent.putExtra("loanTerm", loanTerm);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("emi", emi);
                startActivityForResult(intent, 1);
            }
        });

        bank2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the interest rate for Bank 2 (modify the value as per your requirement)
                double bankInterestRate = 7.5;

                // Calculate the EMI
                double emi = calculateEmi(principalAmount, bankInterestRate, loanTerm);

                // Start CarModelActivity and pass the necessary values
                Intent intent = new Intent(BankSelectionActivity.this, CarModelActivity.class);
                intent.putExtra("principalAmount", principalAmount);
                intent.putExtra("loanTerm", loanTerm);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("emi", emi);
                startActivityForResult(intent, 1);
            }
        });

        bank3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the interest rate for Bank 3 (modify the value as per your requirement)
                double bankInterestRate = 8.5;

                // Calculate the EMI
                double emi = calculateEmi(principalAmount, bankInterestRate, loanTerm);

                // Start CarModelActivity and pass the necessary values
                Intent intent = new Intent(BankSelectionActivity.this, CarModelActivity.class);
                intent.putExtra("principalAmount", principalAmount);
                intent.putExtra("loanTerm", loanTerm);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("emi", emi);
                startActivityForResult(intent, 1);
            }
        });

        bank4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the interest rate for Bank 4 (modify the value as per your requirement)
                double bankInterestRate = 10.0;

                // Calculate the EMI
                double emi = calculateEmi(principalAmount, bankInterestRate, loanTerm);

                // Start CarModelActivity and pass the necessary values
                Intent intent = new Intent(BankSelectionActivity.this, CarModelActivity.class);
                intent.putExtra("principalAmount", principalAmount);
                intent.putExtra("loanTerm", loanTerm);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("emi", emi);
                startActivityForResult(intent, 1);
            }
        });

        bank5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the interest rate for Bank 5 (modify the value as per your requirement)
                double bankInterestRate = 15.0;

                // Calculate the EMI
                double emi = calculateEmi(principalAmount, bankInterestRate, loanTerm);

                // Start CarModelActivity and pass the necessary values
                Intent intent = new Intent(BankSelectionActivity.this, CarModelActivity.class);
                intent.putExtra("principalAmount", principalAmount);
                intent.putExtra("loanTerm", loanTerm);
                intent.putExtra("interestRate", interestRate);
                intent.putExtra("emi", emi);
                startActivityForResult(intent, 1);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Go back to the previous activity
            }
        });


    }

    private double calculateEmi(double principalAmount, double interestRate, int loanTerm) {
        // Perform your EMI calculation logic here
        // You can modify this method based on your requirements
        double emi = 0.0;

        // Example calculation
        double r = interestRate/100;
                // 12 / 100; // Monthly interest rate
        double n = loanTerm; // Loan tenure in months

        emi = (principalAmount*(1+r))/n;
        //principalAmount * r * Math.pow((1 + r), n) / (Math.pow((1 + r), n) - 1);

        return emi;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            double updatedEmi = data.getDoubleExtra("emi", 0.0);
            // Do something with the updatedEmi value if needed
        }
    }
}
