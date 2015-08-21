package com.tarena.tabs.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModpwdActivity extends Activity {

	private EditText oldpwd;
	private EditText newpwd;
	private EditText newpwd2;
	private Button submitBtn;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();

	private static final int HANDLER_MODIFYPWD_RESULT = 0;
	private static final int HANDLER_MODIFYPWD_SAMEPWD = 1;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case HANDLER_MODIFYPWD_RESULT:
					String res = (String) msg.obj;
					if (res.equals("ok")) {
						Toast.makeText(ModpwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
						finish();
					} else {
						Toast.makeText(ModpwdActivity.this, res, Toast.LENGTH_SHORT).show();
					}
				break;
				case HANDLER_MODIFYPWD_SAMEPWD:
					Toast.makeText(ModpwdActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modpwd);

		setViews();
		setListeners();
	}

	private void setListeners() {
		submitBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new Thread() {
					public void run() {
						String op = oldpwd.getText().toString();
						String np1 = newpwd.getText().toString();
						String np2 = newpwd2.getText().toString();
						if (np1.equals(np2)) {
							// 提交请求修改密码
							String res = serviceContext.modifyPwd(op, np1);
							Message msg = new Message();
							msg.what = HANDLER_MODIFYPWD_RESULT;
							msg.obj = res;
							handler.sendMessage(msg);
						} else {
							Message msg = new Message();
							msg.what = HANDLER_MODIFYPWD_SAMEPWD;
							msg.obj = "两次密码输入不一致";
							handler.sendMessage(msg);
						}
					}
				}.start();

				startActivity(new Intent(ModpwdActivity.this, MenuActivity.class));
			}
		});
	}

	private void setViews() {
		oldpwd = (EditText) findViewById(R.id.oldpwd);
		newpwd = (EditText) findViewById(R.id.newpwd);
		newpwd2 = (EditText) findViewById(R.id.newpwd2);
		submitBtn = (Button) findViewById(R.id.modpwdBtn);
	}

}
