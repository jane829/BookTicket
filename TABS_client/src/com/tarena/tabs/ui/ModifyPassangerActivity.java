package com.tarena.tabs.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tarena.tabs.entity.Passanger;

public class ModifyPassangerActivity extends Activity {
	private Passanger passanger;
	private String[] idTypes;
	private Spinner sp;
	private Button modPsgBtn;
	private EditText etName;
	private EditText etTypeNum;
	private EditText etEmail;
	private EditText etPhone;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();

	private static final int HANDLER_MODIFY_PASSANGER_RESULT = 0;
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HANDLER_MODIFY_PASSANGER_RESULT:
				String res=(String)msg.obj;
				if(res.equals("ok")){
					Toast.makeText(ModifyPassangerActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(ModifyPassangerActivity.this, res, Toast.LENGTH_SHORT).show();
				}
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modify_passanger);
		setData();
		setViews();
		setListeners();
	}

	private void setListeners() {
		modPsgBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				new Thread() {
					public void run() {
						// 启动一个线程 修改联系人信息
						String res = serviceContext.updatePassangerInfo(passanger);
						Message msg = new Message();
						msg.what = HANDLER_MODIFY_PASSANGER_RESULT;
						msg.obj = res;
						handler.sendMessage(msg);
					}
				}.start();

			}
		});

	}

	private void setData() {
		idTypes = getResources().getStringArray(R.array.id_type);
	}

	private void setViews() {
		etName = (EditText) findViewById(R.id.psg_add_name);
		sp = (Spinner) findViewById(R.id.psg_add_type);
		etEmail = (EditText) findViewById(R.id.psg_add_email);
		etTypeNum = (EditText) findViewById(R.id.psg_add_typeNum);
		modPsgBtn = (Button) findViewById(R.id.modpsg_submitbtn);
		etPhone = (EditText) findViewById(R.id.etPhone);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idTypes);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);

		// 获取用户选择的乘客显示乘客信息
		passanger = (Passanger) (getIntent().getSerializableExtra("passanger"));
		if (passanger != null) {
			etName.setText(passanger.getPsgName());
			etEmail.setText(passanger.getPsgEmail());
			int selectedIndex = 0;
			for (int i = 0; i < idTypes.length; i++) {
				if (idTypes[i].equals(passanger.getPsgCertifType())) {
					selectedIndex = i;
					break;
				}
			}
			sp.setSelection(selectedIndex);
			etTypeNum.setText(passanger.getCertifNum());
			etPhone.setText(passanger.getPsgPhone());
		}

	}

}
