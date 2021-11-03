package com.example.mortcalcultor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;

public class MonthlyPaymentCalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_payment_cal);

        //Hide support bar on the top of the app
//        getSupportActionBar().hide();

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'></font>"));


    }
}