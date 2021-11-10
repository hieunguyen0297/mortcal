package com.example.mortcalcultor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MonthlyPaymentResult extends AppCompatActivity {
    private TextView payment;
    private Button recalculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_payment_result);

        //Get element by ID
        payment = findViewById(R.id.payment);
        recalculateBtn= findViewById(R.id.recalculate);
        //Get data from intent
        Intent intent = getIntent();
        String monthlyPayment = intent.getStringExtra("monthlyPayment");
        //Set text for payment view
        payment.setText("$"+monthlyPayment);

        //Add click event to recalculate button
        recalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MonthlyPaymentResult.this, MonthlyPaymentCalActivity.class);
                startActivity(intent1);
            }
        });

    }
}