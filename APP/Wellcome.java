package com.example.activity1;

import android.app.Activity;
import android.app.Notification.Action;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Wellcome extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		final Intent intent = new Intent(Wellcome.this,setting.class);
		intent.putExtra("pass", "IPµÿ÷∑£∫");
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startActivity(intent);
				finish();
			}
		}, 5000);
		
	}

}
