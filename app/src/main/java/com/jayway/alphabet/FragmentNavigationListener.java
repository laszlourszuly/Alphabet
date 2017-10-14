package com.jayway.alphabet;

/**
 * This interface describes how fragments can deliver navigation requests from
 * the user to their corresponding Activity. It helps isolating the navigation
 * concern in the Activity.
 */
public interface FragmentNavigationListener {

    void onNavigationRequest(int touchedViewId);

}
