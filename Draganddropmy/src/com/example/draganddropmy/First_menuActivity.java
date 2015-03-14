package com.example.draganddropmy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class First_menuActivity extends Activity {
	
	Button Play, Options, Credits, Exit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_menu);
	
		Play=(Button) findViewById(R.id.button1);
		Options=(Button) findViewById(R.id.button2);
		Credits=(Button) findViewById(R.id.button3);
		Exit=(Button) findViewById(R.id.button4);
		
		OnClickListener l = new OnClickListener(){
			@Override
			public void onClick(View arg0 ){
				//do play
				try {
					this.finalize();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				};
				//this.finish();
			
		};
		Play.setOnClickListener(l);
		
		Options.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v ){
				//do option
			}
		});
		
		Credits.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v ){
				//do credit
				Toast.makeText(getApplicationContext(),"Kto robi³,\n ten zrobi³", Toast.LENGTH_LONG).show();
			}
		});
		
		Exit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v ){
				//do exit
				System.exit(0);
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_first_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
