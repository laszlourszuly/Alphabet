package com.jayway.alphabet.screen.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jayway.alphabet.R;
import com.jayway.alphabet.api.ApiClient;
import com.jayway.alphabet.api.ApiInterface;
import com.jayway.alphabet.model.Attendee;
import com.jayway.alphabet.model.Order;
import com.jayway.alphabet.screen.checkout.CheckoutActivity;
import com.jayway.alphabet.tracking.FirebaseTracker;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
  private static final String NBR_OF_ATTENDEES = "nbrOfAttendees";
  private int nrbOfAttendees = 1;

  @BindView(R.id.input_name) EditText mName1;
  @BindView(R.id.input_address) EditText mAddress1;
  @BindView(R.id.input_postalCode) EditText mPostalCode1;
  @BindView(R.id.input_city) EditText mCity1;
  @BindView(R.id.input_country) EditText mCountry1;
  @BindView(R.id.input_email) EditText mEmail1;
  @BindView(R.id.input_phone) EditText mPhone1;

  @BindView(R.id.attende2) LinearLayout mAttendee2;
  @BindView(R.id.input_name2) EditText mName2;
  @BindView(R.id.input_addres2) EditText mAddress2;
  @BindView(R.id.input_postalCode2) EditText mPostalCode2;
  @BindView(R.id.input_city2) EditText mCity2;
  @BindView(R.id.input_country2) EditText mCountry2;
  @BindView(R.id.input_email2) EditText mEmail2;
  @BindView(R.id.input_phone2) EditText mPhone2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    ButterKnife.bind(this);
    Intent intent = getIntent();
    nrbOfAttendees = intent.getIntExtra(NBR_OF_ATTENDEES, 1);
    if (nrbOfAttendees != 1) {
      mAttendee2.setVisibility(View.VISIBLE);
    }

    View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FirebaseTracker.getInstance().send("REGISTRATION_ON_FIELD_CLICKED_" + view.getTag());
      }
    };
    mName1.setOnClickListener(listener);
    mAddress1.setOnClickListener(listener);
    mPostalCode1.setOnClickListener(listener);
    mCity1.setOnClickListener(listener);
    mCountry1.setOnClickListener(listener);
    mEmail1.setOnClickListener(listener);
    mPhone1.setOnClickListener(listener);
    mName2.setOnClickListener(listener);
    mAddress2.setOnClickListener(listener);
    mPostalCode2.setOnClickListener(listener);
    mCity2.setOnClickListener(listener);
    mCountry2.setOnClickListener(listener);
    mEmail2.setOnClickListener(listener);
    mPhone2.setOnClickListener(listener);
  }

  public static void showActivity(Context context, int attendees) {
    Intent launchIntent = new Intent(context, RegisterActivity.class);
    launchIntent.putExtra(NBR_OF_ATTENDEES, attendees);
    context.startActivity(launchIntent);
  }

  @OnClick(R.id.submitBtn)
  public void submit() {
    String address = mAddress1.getText() + ", " + mPostalCode1.getText() + " " + mCity1.getText() + ", " + mCountry1.getText();
    Attendee attendee = new Attendee(mName1.getText().toString(), mPhone1.getText().toString(), mEmail1.getText().toString(), address);
    ArrayList<Attendee> attendees = new ArrayList<>();
    attendees.add(attendee);
    if (nrbOfAttendees == 2) {
      String address2 = mAddress2.getText() + ", " + mPostalCode2.getText() + " " + mCity2.getText() + ", " + mCountry2.getText();
      Attendee attendee2 = new Attendee(mName2.getText().toString(), mPhone2.getText().toString(), mEmail2.getText().toString(), address2);
      attendees.add(attendee2);
    }
    Order order = new Order(attendees);
    FirebaseTracker.getInstance().send("REGISTRATION_SUBMIT");
    CheckoutActivity.showActivity(this);
  }
}
