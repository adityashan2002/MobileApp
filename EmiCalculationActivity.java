package com.example.emionwheels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmiCalculationActivity extends AppCompatActivity {

    private EditText principalAmountEditText, downPaymentEditText, loanTermEditText;
    private Button checkEligibilityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calculation);

        principalAmountEditText = findViewById(R.id.principalAmountEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermEditText = findViewById(R.id.loanTermEditText);
        checkEligibilityButton = findViewById(R.id.checkEligibilityButton);

        checkEligibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input from the EditText fields
                String principalAmountString = principalAmountEditText.getText().toString();
                String downPaymentString = downPaymentEditText.getText().toString();
                String loanTermString = loanTermEditText.getText().toString();

                // Validate input
                if (principalAmountString.isEmpty() || downPaymentString.isEmpty() || loanTermString.isEmpty()) {
                    Toast.makeText(EmiCalculationActivity.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double principalAmount = Double.parseDouble(principalAmountString);
                    double downPayment = Double.parseDouble(downPaymentString);
                    int loanTerm = Integer.parseInt(loanTermString);

                    // Calculate the interest rate, you can change the calculation logic as per your requirements
                    double interestRate = calculateInterestRate(principalAmount, downPayment, loanTerm);

                    // Start BankSelectionActivity and pass the necessary values
                    Intent intent = new Intent(EmiCalculationActivity.this, BankSelectionActivity.class);
                    intent.putExtra("principalAmount", principalAmount-downPayment);
                    intent.putExtra("loanTerm", loanTerm);
                    intent.putExtra("interestRate", interestRate);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(EmiCalculationActivity.this, "Invalid input values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private double calculateInterestRate(double principalAmount, double downPayment, int loanTerm) {
        // Perform your interest rate calculation logic here
        // You can modify this method based on your requirements
        double interestRate = 0.0;

        // Example calculation
        interestRate = (principalAmount - downPayment) / loanTerm;

        return interestRate;
    }
}
