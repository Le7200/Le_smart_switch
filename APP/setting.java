package com.example.activity1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class setting extends Activity {
	TextView tx1 = null;
	EditText tx2 = null;
	Button   bt1 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_layout);
		tx1 = (TextView) findViewById(R.id.text1);
		tx2 = (EditText) findViewById(R.id.editText1);
		bt1 = (Button) findViewById(R.id.OK);
		final Intent intent = new Intent(setting.this,MainActivity.class);
		
		bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent.putExtra("IP", tx2.getText().toString());
				startActivity(intent);
				finish();
			}
		});
		
		
	}

}
