package com.example.kudu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnLogin, btnRegister;
	private static final String URL = "http://10.0.2.2:8080/kuduServerApp/test";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView imgView;

		imgView = (ImageView) findViewById(R.id.logo);
		imgView.setImageResource(R.drawable.login_logo);

		setLoginButtonListener();
		setRegisterButtonListener();

		// checkInternetConnection
		if (checkInternetConnection()) {
		} else {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void setLoginButtonListener() {
		btnLogin = (Button) findViewById(R.id.login);
		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText usernameEditText = (EditText) findViewById(R.id.username);
				EditText passwordEditText = (EditText) findViewById(R.id.password);
				String btnUsernameStr = usernameEditText.getText().toString();
				String btnPasswordStr = passwordEditText.getText().toString();

				// if (checkInternetConnection()) {

				Login login = new Login();
				login.setUsername(btnUsernameStr);
				login.setPassword(btnPasswordStr);

				// if (validateLogin(btnUsernameStr, btnPasswordStr)) {
				// Intent myIntent = new Intent(MainActivity.this,
				// ConvoOverviewActivity.class);
				// MainActivity.this.startActivity(myIntent);
				GetXMLTask task = new GetXMLTask();
				task.execute(new String[] { URL });
				// } else {
				// passwordEditText
				// .setError("Incorrect Username or Password.");
			}
			// /} else {
			// Toast.makeText(MainActivity.this,
			// "Check Internet Connection", Toast.LENGTH_LONG)
			// .show();
			// }
			// }
		});

	}

	public void setRegisterButtonListener() {
		btnRegister = (Button) findViewById(R.id.register);
		btnRegister.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this,
						RegisterActivity.class);
				MainActivity.this.startActivity(myIntent);
			}
		});
	}

	public boolean validateLogin(String username, String password) {
		boolean isValid = false;
		if (username.equals("1")) {
			isValid = true;
		}
		// Check if Username + Password are inside the Cassandra Login
		// Column Family
		// If yes -> isValid = true
		return isValid;
	}

	private boolean checkInternetConnection() {
		ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conMgr.getActiveNetworkInfo() != null
				&& conMgr.getActiveNetworkInfo().isAvailable()
				&& conMgr.getActiveNetworkInfo().isConnected()) {
			return true;
		} else {
			return false;
		}
	}
}
