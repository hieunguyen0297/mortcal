package com.example.mortcalcultor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MonthlyPaymentCalActivity extends AppCompatActivity {
    private Button calculateM;
    private TextInputEditText homePrice;
    private TextInputEditText downPayment;
    private SeekBar interestRate;
    private TextView percentLabel;
    private RadioGroup radioGroup;
    private RadioButton lengthOfLoan;
    private static final int MONTH_IN_YEAR = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_payment_cal);
        /*

        Hide support bar on the top of the app
        getSupportActionBar().hide();
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'></font>"));

        */

        //Get all elements by ID
        calculateM = findViewById(R.id.monthlyCalculateBtn);
        homePrice = findViewById(R.id.homePrice);
        downPayment = findViewById(R.id.downPayment);
        interestRate = findViewById(R.id.seekBarInterestRate);
        percentLabel = findViewById(R.id.percent);
        radioGroup = findViewById(R.id.radioGroup);

        //Add event change for the radio group
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                lengthOfLoan = findViewById(checkID);
                //Log.i("length", "onCheckedChanged: " + lengthOfLoan.getText());
            }
        });

        //Add seekbar change listener event to the interest rate seekbar
        interestRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                double value = progress / 10.0;
                percentLabel.setText(value + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        //Add click event listener to the calculate button
        calculateM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(homePrice.getText().toString().isEmpty() || downPayment.getText().toString().isEmpty() || lengthOfLoan.getText().toString().isEmpty()){
                    return;
                }else{
                    calculateMortgage();
                }
            }
        });
    }

    public void calculateMortgage(){
        //Get home price
        double priceOfHome = Double.parseDouble(String.valueOf(homePrice.getText()));
        //Get down payment price
        double downPaymentAmount = Double.parseDouble(String.valueOf(downPayment.getText()));
        //Get the total length of loan
        int theLengthOfLoan = Integer.parseInt(String.valueOf(lengthOfLoan.getText())) * MONTH_IN_YEAR;
        //Get interest rate
        double theAnnualInterestRate = (interestRate.getProgress() / 10.0) / 100;
        //Calculate the monthly interest rate
        double theMonthlyInterestRate;
        if(theAnnualInterestRate == 0.0){
            theMonthlyInterestRate = 0.0000001;
        }else{
            theMonthlyInterestRate = theAnnualInterestRate / MONTH_IN_YEAR;
        }
        //Calculate monthly payment
        double principle = priceOfHome - downPaymentAmount;
        double monthlyPayment = principle * (
                (theMonthlyInterestRate * (Math.pow(1 + theMonthlyInterestRate, theLengthOfLoan))) / ((Math.pow(1 + theMonthlyInterestRate, theLengthOfLoan)) - 1)
                );
        String monthlyPaymentString = String.valueOf(Math.round(monthlyPayment));
        Intent intent = new Intent(MonthlyPaymentCalActivity.this, MonthlyPaymentResult.class);
        intent.putExtra("monthlyPayment", monthlyPaymentString);
        startActivity(intent);

    }
}