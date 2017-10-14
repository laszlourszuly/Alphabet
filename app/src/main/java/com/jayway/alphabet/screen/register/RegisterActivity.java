package com.jayway.alphabet.screen.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.jayway.alphabet.R;
import com.jayway.alphabet.screen.checkout.CheckoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
  private static final String NBR_OF_ATTENDEES = "nbrOfAttendees";

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
    int nbrOfAttendees = intent.getIntExtra(NBR_OF_ATTENDEES, 1);
    if (nbrOfAttendees != 1) {
      mAttendee2.setVisibility(View.VISIBLE);
    }


  }

  public static void showActivity(Context context, int attendees) {
    Intent launchIntent = new Intent(context, RegisterActivity.class);
    launchIntent.putExtra(NBR_OF_ATTENDEES, attendees);
    context.startActivity(launchIntent);
  }

  @OnClick(R.id.submitBtn)
  public void submit() {
    CheckoutActivity.showActivity(this);
  }
}
