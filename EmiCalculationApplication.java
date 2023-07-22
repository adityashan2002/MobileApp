package com.example.emionwheels;
import android.app.Application;

public class EmiCalculationApplication extends Application {

    private static double interestRate;
    private static double bankInterestRate;

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static double getBankInterestRate() {
        return bankInterestRate;
    }

    public static void setBankInterestRate(double rate) {
        bankInterestRate = rate;
    }
}
