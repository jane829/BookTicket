package com.tarena.tabs.ui;

import com.tarena.tabs.entity.User;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegestActivity extends Activity {

	private String[] idTypes;
	private Spinner sp;
	private Button btReg;
	private EditText etNum;
	private EditText etEmail;
	private EditText etPwd2;
	private EditText etPwd;
	private EditText etName;
	private EditText etRealName;
	private EditText etType;
	private EditText etPhone;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case HANDLER_REGIST_MSG:
				String res = (String)msg.obj;
				if(res.equals("ok")){
					Toast.makeText(RegestActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
					finish();
				}else{
					Toast.makeText(RegestActivity.this, res, Toast.LENGTH_SHORT).show();
				}
				break;
			}
		};
	};
	
	private static final int HANDLER_REGIST_MSG = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regest);
		
		setData();
		setViews();
		setListeners();
	}

	private void setListeners() {
		btReg.setOnClickListener(new OnClickListener() {public void onClick(View v) {
			new Thread(){
				public void run() {
					User user = new User();
					user.setUserEmail(etEmail.getText().toString());
					if(!etPwd.getText().toString().equals(etPwd2.getText().toString())){
						//两次密码输入不一致
						Message msg = new Message();
						msg.what = HANDLER_REGIST_MSG;
						msg.obj = "两次密码输入不一致";
						handler.sendMessage(msg);
						return;
					}
					user.setPassword(etPwd.getText().toString());
					user.setUserCertifType(sp.getSelectedItem().toString());
					user.setUserCertifNum(etNum.getText().toString());
					user.setUserName(etRealName.getText().toString());
					user.setUserLoginName(etName.getText().toString());
					user.setUserTelephone(etPhone.getText().toString());
					
					String res=serviceContext.regist(user);
					
					Message msg = new Message();
					msg.what = HANDLER_REGIST_MSG;
					msg.obj = res;
					handler.sendMessage(msg);
					
				}
			}.start();
		}});
	}


	private void setData() {
		idTypes = 
			getResources()
			 .getStringArray(
			   R.array.id_type);
	}

	private void setViews() {
		etName = (EditText) findViewById(R.id.regist_name);
		etRealName = (EditText) findViewById(R.id.regist_realname);
		etPwd = (EditText) findViewById(R.id.regist_pwd1);
		etPwd2 = (EditText) findViewById(R.id.regist_pwd2);
		etEmail = (EditText) findViewById(R.id.regist_email);
		sp = (Spinner) findViewById(R.id.regist_cerifType);
		etNum = (EditText) findViewById(R.id.regist_cerifNum);
		btReg = (Button) findViewById(R.id.regist_btn);
		etPhone = (EditText) findViewById(R.id.regist_phone);
		
		ArrayAdapter<String> adapter = 
		  new ArrayAdapter<String>(
		  this,
		  android.R.layout.simple_spinner_item,
		  idTypes);
		adapter.setDropDownViewResource(
		  android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.regest, menu);
		return true;
	}

}












