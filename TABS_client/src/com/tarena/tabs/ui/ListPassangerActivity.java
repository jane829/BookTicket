package com.tarena.tabs.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.tarena.tabs.entity.Passanger;

public class ListPassangerActivity extends Activity {

	private ImageView addPassangerView;
	private ListView psgsListView;
	private ServiceContext serviceContext = ServiceContext.getServiceContext();
	private List<Passanger> passangers;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case HANDLER_DELPASSANGER:
				String res=(String)msg.obj;
				if(res.equals("ok")){
					Toast.makeText(ListPassangerActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(ListPassangerActivity.this, res, Toast.LENGTH_SHORT).show();
				}
				break;
			case LOAD_PASSENGERS_OK:
				setAdapter();
				break;
			default:
				break;
			}
		}
	};
	
	private static final int HANDLER_DELPASSANGER=0;
	private static final int LOAD_PASSENGERS_OK=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_passanger);
		setData();
		setViews();
		setListeners();
	}

	private void setListeners() {
		addPassangerView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(ListPassangerActivity.this, AddPassangerActivity.class));
			}
		});

		psgsListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Passanger passanger = passangers.get(position);
				Intent intent = new Intent(ListPassangerActivity.this, ModifyPassangerActivity.class);
				intent.putExtra("passanger", passanger);
				startActivity(intent);
			}
		});
		
		psgsListView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int position, long arg3) {
				final AlertDialog ad = new AlertDialog.Builder(ListPassangerActivity.this).setTitle("注意").setMessage("确认删除吗？")
						.setNeutralButton("确定", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Passanger p = passangers.get(position);
								final List<Integer> ps = new ArrayList<Integer>();
								ps.add(p.getPsgId());

								//起一个线程删除该联系人
								new Thread(){
									public void run() {
										String res = serviceContext.removeMyPassangers(ps);
										Message msg = new Message();
										msg.what = HANDLER_DELPASSANGER;
										msg.obj = res;
										handler.sendMessage(msg);
									}
								}.start();
								
							}
						}).setPositiveButton("取消", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								
							}
						}).create();
				ad.show();

				return false;
			}
		});
	}

	private void setAdapter() {
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		for (int i = 0; i < passangers.size(); i++) {
			Map<String, String> dm = new HashMap<String, String>();
			dm.put("data", passangers.get(i).toString());
			data.add(dm);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.activity_passanger_item,
				new String[] { "data" }, new int[] { R.id.psgMsgTv });
		psgsListView.setAdapter(adapter);

	}

	private void setData() {
		new Thread(){
			public void run() {
				passangers = serviceContext.getMyPassangers();
				Message msg=new Message();
				msg.what=LOAD_PASSENGERS_OK;
				handler.sendMessage(msg);
			}
		}.start();
	}

	private void setViews() {
		addPassangerView = (ImageView) findViewById(R.id.addPassanger);
		psgsListView = (ListView) findViewById(R.id.passangerListView);
	}

	protected void reg() {

	}

	protected void onResume() {
		super.onResume();
		new Thread(){
			public void run() {
				passangers = serviceContext.getMyPassangers();
				handler.sendEmptyMessage(LOAD_PASSENGERS_OK);
			}
		}.start();
	}
}
