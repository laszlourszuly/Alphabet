package com.jayway.alphabet.screen.tickets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

import com.jayway.alphabet.R;
import com.jayway.alphabet.screen.register.RegisterActivity;
import com.jayway.alphabet.tracking.FirebaseTracker;

/**
 * This Activity is responsible for orchestrating the on-boarding navigation
 * flow.
 */
public class TicketActivity extends AppCompatActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, TicketActivity.class);
        context.startActivity(starter);
    }


    private ImageButton oneTicket;
    private ImageButton valuePack;
    private ImageButton twoDays;
    private ImageButton threeDays;
    private Button workshop;
    private Button firstTwoDays;
    private Button lastTwoDays;
    private Button hotel;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        setSupportActionBar(findViewById(R.id.my_toolbar));

        oneTicket = findViewById(R.id.one_ticket);
        oneTicket.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("ONE_TICKET_BUTTON");
            pickOneTicket();
        });

        valuePack = findViewById(R.id.value_pack);
        valuePack.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("MULTI_TICKET_BUTTON");
            pickValuePack();
        });

        twoDays = findViewById(R.id.two_days);
        twoDays.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("TWO_DAYS_BUTTON");
            twoDays.setSelected(!twoDays.isSelected());
        });

        threeDays = findViewById(R.id.three_days);
        threeDays.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("THREE_DAYS_BUTTON");
            threeDays.setSelected(!threeDays.isSelected());
        });

        workshop = findViewById(R.id.workshop);
        workshop.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("WORKSHOP_BUTTON");
            workshop.setSelected(!workshop.isSelected());
        });

        firstTwoDays = findViewById(R.id.first_two_days);
        firstTwoDays.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("FIRST_TWO_DAYS_BUTTON");
            firstTwoDays.setSelected(!firstTwoDays.isSelected());
        });

        lastTwoDays = findViewById(R.id.last_two_days);
        lastTwoDays.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("LAST_TWO_DAYS_BUTTON");
            lastTwoDays.setSelected(!lastTwoDays.isSelected());
        });

        hotel = findViewById(R.id.hotel);
        hotel.setOnClickListener(v -> {
            FirebaseTracker.getInstance().send("HOTEL_BUTTON");
            hotel.setSelected(!hotel.isSelected());
        });

        next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            int attendees = 0;
            if (oneTicket.isSelected())
                attendees = 1;
            if (valuePack.isSelected())
                attendees = 2;

            RegisterActivity.showActivity(this, attendees);
        });

        pickValuePack();
    }

    private void pickOneTicket() {
        oneTicket.setSelected(true);
        valuePack.setSelected(false);
        twoDays.setSelected(false);
        twoDays.setEnabled(true);
        threeDays.setSelected(true);
        threeDays.setEnabled(true);
        workshop.setSelected(true);
        workshop.setEnabled(true);
        hotel.setSelected(true);
        hotel.setEnabled(true);
    }

    private void pickValuePack() {
        oneTicket.setSelected(false);
        valuePack.setSelected(true);
        twoDays.setSelected(false);
        twoDays.setEnabled(false);
        threeDays.setSelected(true);
        threeDays.setEnabled(false);
        workshop.setSelected(false);
        workshop.setEnabled(false);
        hotel.setSelected(true);
        hotel.setEnabled(false);
    }
}
