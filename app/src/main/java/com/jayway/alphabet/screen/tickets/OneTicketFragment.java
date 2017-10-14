package com.jayway.alphabet.screen.tickets;

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
 * This fragment is responsible for showing the one-ticket offering to the user,
 * reporting any user interaction up to the parent Activity.
 */
public class OneTicketFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_onboarding_offering_oneticket, container, false);
    }

}