package com.tarena.tabs.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button btLogin;
	private Button btRegist;
	private EditText etPwd;
	private EditText etName;
	private ServiceContext context = ServiceContext.getServiceContext();

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				login(msg.obj);
			}
		}
	};

	private void login(Object msg) {
		if(msg.equals("ok")){
			showMenu();
			finish();
		}else{
			new AlertDialog.Builder(MainActivity.this).setMessage(msg.toString()).setTitle("失败").show();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setViews();
		setListeners();
	}

	private void setViews() {
		etName = (EditText) findViewById(R.id.etUsername);
		etPwd = (EditText) findViewById(R.id.etPwd);
		btLogin = (Button) findViewById(R.id.btLogin);
		btRegist = (Button) findViewById(R.id.btRegist);
	}

	private void setListeners() {
		btLogin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				login();
			}
		});
		
		btRegist.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showReg();
			}
		});
	}

	protected void login() {
		new Thread() {
			public void run() {
				String name = etName.getText().toString();
				String pwd = etPwd.getText().toString();
				String result=context.login(name, pwd);
				Message msg = new Message();
				msg.what=0;
				msg.obj=result;
				handler.sendMessage(msg);
			}
		}.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showReg() {
		Intent intent = new Intent(this, RegestActivity.class);
		startActivity(intent);
	}
	
	public void showMenu(){
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
		finish();
	}

}
