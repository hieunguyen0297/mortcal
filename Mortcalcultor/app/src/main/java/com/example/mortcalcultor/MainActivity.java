package com.example.mortcalcultor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button monthlyPaymentBtn;
    private Button loanBudgetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //Get the two button
        monthlyPaymentBtn = findViewById(R.id.monthlyPayment);
        loanBudgetBtn = findViewById(R.id.loanBudget);



        //Change style for btn
        //monthlyPaymentBtn.setBackgroundColor(Color.parseColor("red"));

        //Add event on the buttons
        monthlyPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set button color to different color when selected based on btn state
                //monthlyPaymentBtn.setSelected(!monthlyPaymentBtn.isSelected());

                //To another page
                Intent intent = new Intent(MainActivity.this, MonthlyPaymentCalActivity.class);
                startActivity(intent);

            }
        });
    }
}