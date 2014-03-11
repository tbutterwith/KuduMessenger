package com.example.kudu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnLogin;
	private Button btnRegister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ImageView imgView;
		
		imgView=(ImageView)findViewById(R.id.logo);
		imgView.setImageResource(R.drawable.xxhdpi_logo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void setLoginButtonListener(){
		btnLogin = (Button) findViewById(R.id.login);
		btnLogin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this,"Get Tae Fuck",Toast.LENGTH_LONG).show();		
		}
		});
	}
	
	public void setRegisterButtonListener(){
		btnLogin = (Button) findViewById(R.id.register);
		btnLogin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this,"Get Yoor Tits Oot",Toast.LENGTH_LONG).show();		
		}
		});
	}
	
}