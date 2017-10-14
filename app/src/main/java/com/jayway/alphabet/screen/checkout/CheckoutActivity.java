package com.jayway.alphabet.screen.checkout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jayway.alphabet.R;
import com.jayway.alphabet.screen.register.RegisterActivity;

public class CheckoutActivity extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_checkout);

	}

	public static void showActivity(Context context) {
		Intent launchIntent = new Intent(context, CheckoutActivity.class);
		context.startActivity(launchIntent);
	}


}
