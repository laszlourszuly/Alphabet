package com.jayway.alphabet.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayway.alphabet.FragmentNavigationListener;
import com.jayway.alphabet.R;

/**
 * This fragment is responsible for showing the value-pack offering to the user,
 * reporting any user interaction up to the parent Activity.
 */
public class ValuePackFragment extends Fragment {

    private FragmentNavigationListener navigationListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            navigationListener = (FragmentNavigationListener) context;
        } catch (Exception e) {
            throw new IllegalStateException("Make sure you activity implements the " +
                    "'FragmentNavigationListener' interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_onboarding_offering_valuepack, container, false);
    }

}
