package com.jayway.alphabet;

import android.app.Application;

import com.jayway.alphabet.tracking.FirebaseTracker;

/**
 * This is the Alphabet specific super context.
 */
public class AlphabetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseTracker.setup(this);
    }

}
