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

public class AddPassangerActivity extends Activity {
	private Passanger passanger;
	private String[] idTypes;
	private Spinner sp;
	private Button addPsgBtn;
	private EditText addPsgName;
	private EditText addPsgType;
	private EditText addPsgEmail;
	private EditText addPsgPhone;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HANDLER_MSG_ADD_PASSANGER:
				String res = (String)msg.obj;
				if(res.equals("ok")){
					Toast.makeText(AddPassangerActivity.this, "添加乘机人成功", Toast.LENGTH_SHORT).show();
					finish();
				}else{
					Toast.makeText(AddPassangerActivity.this, res, Toast.LENGTH_SHORT).show();
				}
				break;

			default:
				break;
			}
		}
	};
	private static final int HANDLER_MSG_ADD_PASSANGER = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_passanger);
		setData();
		setViews();
		setListeners();
	}

	private void setListeners() {
		addPsgBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new Thread(){
					//起一个线程 添加乘机人
					public void run() {
						passanger = new Passanger();
						passanger.setPsgName(addPsgName.getText().toString());
						passanger.setPsgEmail(addPsgEmail.getText().toString());
						passanger.setPsgPhone(addPsgPhone.getText().toString());
						passanger.setCertifNum(addPsgType.getText().toString());
						passanger.setPsgCertifType((String)sp.getSelectedItem());
						String res = serviceContext.addPassanger(passanger);
						Message msg = new Message();
						msg.what = HANDLER_MSG_ADD_PASSANGER;
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
		addPsgName = (EditText) findViewById(R.id.addPsgName);
		sp = (Spinner) findViewById(R.id.addPsgType);
		addPsgEmail = (EditText) findViewById(R.id.addPsgEmail);
		addPsgType = (EditText) findViewById(R.id.addPsgTypeNum);
		addPsgBtn = (Button) findViewById(R.id.addPsgBtn);
		addPsgPhone = (EditText) findViewById(R.id.addPsgPhone);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, idTypes);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
	}

}
