package com.jayway.alphabet.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.jayway.alphabet.FragmentNavigationListener;
import com.jayway.alphabet.R;
import com.jayway.alphabet.tracking.FirebaseTracker;

/**
 * This Activity is responsible for orchestrating the on-boarding navigation
 * flow.
 */
public class OnBoardingActivity extends AppCompatActivity implements FragmentNavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        setSupportActionBar(findViewById(R.id.my_toolbar));

        // This should be a static initial view, hence not adding
        // it to the back stack.
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,
                        new OfferingFragment())
                .commit();
    }

    @Override
    public void onNavigationRequest(int touchedViewId) {
        switch (touchedViewId) {
            case R.id.one_ticket:
                navigateTo(new OneTicketFragment());
                FirebaseTracker.getInstance().mark("ONBOARDING.ONE_TICKET_BUTTON");
                break;
            case R.id.value_pack:
                navigateTo(new ValuePackFragment());
                FirebaseTracker.getInstance().mark("ONBOARDING.ONE_TICKET_BUTTON");
                break;
            default:
                // Don't do anything
                break;
        }
    }


    private void navigateTo(Fragment fragment) {
        if (fragment == null)
            return;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, OnBoardingActivity.class);
        context.startActivity(starter);
    }
}
