package com.example.mortcalcultor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MonthlyPaymentResult extends AppCompatActivity {
    private TextView payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_payment_result);


        //Get element by ID
        payment = findViewById(R.id.payment);

        Intent intent = getIntent();
        String monthlyPayment = intent.getStringExtra("monthlyPayment");
        payment.setText("$"+monthlyPayment);
        Log.i("mon", "onCreate: " + monthlyPayment);

    }
}