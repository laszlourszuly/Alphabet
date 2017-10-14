package com.jayway.alphabet.screen.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jayway.alphabet.screen.tickets.TicketActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TicketActivity.start(this);
        finish();
    }
}