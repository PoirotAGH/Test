package com.example.draganddropmy;

import java.lang.annotation.Target;
import java.util.concurrent.Semaphore;

import android.R.integer;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	


	int total = 0;
	int res = 0;
	Semaphore mutex = new Semaphore(1); 
	Object target = new Object();
	Object dragged = new Object();
	Object bout = new Object();
	Button Play, Options, Credits, Exit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
		
		findViewById(R.id.but1).setOnTouchListener(touchListen);
		findViewById(R.id.but2).setOnTouchListener(touchListen);
		findViewById(R.id.but3).setOnTouchListener(touchListen);
		findViewById(R.id.but4).setOnTouchListener(touchListen);
		findViewById(R.id.but5).setOnTouchListener(touchListen);
		findViewById(R.id.but6).setOnTouchListener(touchListen);
		findViewById(R.id.but7).setOnTouchListener(touchListen);
		findViewById(R.id.but8).setOnTouchListener(touchListen);
		findViewById(R.id.but9).setOnTouchListener(touchListen);
		findViewById(R.id.but1).setOnDragListener(DropListener);
		findViewById(R.id.but2).setOnDragListener(DropListener);
		findViewById(R.id.but3).setOnDragListener(DropListener);
		findViewById(R.id.but4).setOnDragListener(DropListener);
		findViewById(R.id.but5).setOnDragListener(DropListener);
		findViewById(R.id.but6).setOnDragListener(DropListener);
		findViewById(R.id.but7).setOnDragListener(DropListener);
		findViewById(R.id.but8).setOnDragListener(DropListener);
		findViewById(R.id.but9).setOnDragListener(DropListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data)  
    {  
              super.onActivityResult(requestCode, resultCode, data);  
               // check if the request code is same as what is passed  here it is 2  
                if(requestCode==2)  
                      {  
                         String message=data.getStringExtra("MESSAGE");
                         String s1 = "sum";
                         String s2 = "dif";
                         String s3 = "mult";
                         String s4 = "div";		 
                         if (message.equals(s1))
                       	     res = 1; 
                         else if (message.equals(s2))
                             res = 2;
                         else if (message.equals(s3))
                       	     res = 3;
                         else if (message.equals(s4))
                             res = 4;
                         else {
                        	 Log.i("Nie ma", "Mnie");
						}
                         
                      } 
                String result = new String();
                TextView target2 = (TextView)target;
                TextView dragged2 = (TextView)dragged;
                Log.i("Pocz¹tek", "Obliczeñ");
        		switch(res){
        			case 1: 
        				Log.i("Suma", "Obliczone");
        				result = MyEquation.Sum(dragged2.getText(), target2.getText());
        			break;
        			case 2: result = MyEquation.Diff(dragged2.getText(), target2.getText());
        			break;
        			case 3: result = MyEquation.Mult(dragged2.getText(), target2.getText());
        			break;
        			case 4: result = MyEquation.Div(dragged2.getText(), target2.getText());
        		    break;
        			default:
        		    	break;
        		}
        		target2.setText(result);
        		target = (Object)target2;
        		Button submit = (Button) bout;
        		submit.setEnabled(false);
                
  } 
	OnTouchListener touchListen = new OnTouchListener()
	{

		

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			DragShadow dragShadow = new DragShadow(v);
			ClipData data = ClipData.newPlainText("", "");
			
			v.startDrag(data, dragShadow, v, 0);
			return false;
		}
		
		
	};
	
	private class DragShadow extends View.DragShadowBuilder
	{
		ColorDrawable greyBox;

		@Override
		public void onProvideShadowMetrics(Point shadowSize,Point shadowTouchPoint) 
		{
			View v = getView();
			int height = (int)v.getHeight()/2;
			int width = (int)v.getWidth()/2;
			
			greyBox.setBounds(0, 0, width, height);
			
			shadowSize.set(width, height);
			
			shadowTouchPoint.set(width, height);
			
		}

		@Override
		public void onDrawShadow(Canvas canvas) 
		{
			greyBox.draw(canvas);
		}

		public DragShadow(View view) 
		{
			super(view);
			greyBox = new ColorDrawable(Color.LTGRAY);
		}
		
	}
	OnDragListener DropListener = new OnDragListener()
	{
		

		@Override
		public boolean onDrag(View v, DragEvent event) 
		{
			int dragEvent = event.getAction();
			
			switch(dragEvent)
			{
				case DragEvent.ACTION_DRAG_ENTERED:
					Log.i("Drag Event", "Entered");
					break;
				case DragEvent.ACTION_DRAG_EXITED:
					Log.i("Drag Event", "Exited");
					break;
				case DragEvent.ACTION_DROP:
					
					target = (TextView)v;
					dragged = (TextView)event.getLocalState();
					bout = (Button)event.getLocalState();
					reaction();
				
					
					//ViewGroup layout = (ViewGroup) bout.getParent();
					//if(null!=layout) //for safety only  as you are doing onClick
					//	  layout.removeView(bout);
					
					
					break;
					
					
			}
			return true;
		}
		
	};
	public void reaction(){
		Intent i = new Intent(this, OperationActivity.class);
		startActivityForResult(i,2); 
	}
	
	
	
}
