package com.jayway.alphabet.screen.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jayway.alphabet.R;
import com.jayway.alphabet.onboarding.OnBoardingActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBoardingActivity.start(this);
        finish();
    }
}