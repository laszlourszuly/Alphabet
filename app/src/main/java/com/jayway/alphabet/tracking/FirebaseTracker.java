package com.jayway.alphabet.tracking;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * This class implements the Firebase Google Analytics tracker.
 */
public class FirebaseTracker implements Tracker {

    private static FirebaseTracker instance;

    /**
     * Initializes the Firebase infrastructure. This method needs to be called
     * once. Application onCreate would be a good place.
     *
     * @param context The context to initialize Firebase with.
     */
    public static void setup(Context context) {
        if (instance == null) {
            instance = new FirebaseTracker(context);
        }
    }

    /**
     * Returns the initialized Firebase tracker instance.
     *
     * @return The tracker instance.
     * @throws IllegalStateException If the tracker hasn't been setup yet.
     */
    public static FirebaseTracker getInstance() throws IllegalStateException {
        if (instance == null)
            throw new IllegalStateException("FirebaseTracker hasn't been initialized yet. " +
                    "Make sure you have called 'FirebaseTracker#setup(Context)'");

        return instance;
    }


    // Local Firebase instance.
    private final FirebaseAnalytics firebaseAnalytics;


    /**
     * Intentionally hidden constructor. Used by the static setup() method.
     *
     * @param context The context to create Firebase with.
     */
    private FirebaseTracker(Context context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }


    @Override
    public void mark(String tag) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, tag);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    public void mark(int tag) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, Integer.toString(tag));
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

}
