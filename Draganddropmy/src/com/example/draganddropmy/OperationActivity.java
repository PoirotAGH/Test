package com.example.draganddropmy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class OperationActivity extends Activity {
	
	
	Button b1, b2, b3, b4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_operation);
		
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		b1.setOnClickListener(new OnClickListener() {  
              @Override  
              public void onClick(View arg0) {  
                  String message="sum";  
                  Intent intent=new Intent();  
                  intent.putExtra("MESSAGE",message);  
                  setResult(2,intent);  
                  finish();//finishing activity  
              }  
          }); 
		b2.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View arg0) {  
                String message="dif";  
                Intent intent=new Intent();  
                intent.putExtra("MESSAGE",message);  
                setResult(2,intent);  
                finish();//finishing activity  
            }  
        }); 
		b3.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View arg0) {  
                String message="mult";  
                Intent intent=new Intent();  
                intent.putExtra("MESSAGE",message);  
                setResult(2,intent);  
                finish();//finishing activity  
            }  
        }); 
		b4.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View arg0) {  
                String message="div";  
                Intent intent=new Intent();  
                intent.putExtra("MESSAGE",message);  
                setResult(2,intent);  
                finish();//finishing activity  
            }  
        }); 
 		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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