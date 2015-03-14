package com.example.draganddropmy;

import java.lang.annotation.Target;

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
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public void reaction(){
		Intent i = new Intent(this, OperationActivity.class);
		startActivity(i);
	}
	
	int total = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
		getMenuInflater().inflate(R.layout.activity_first_menu, menu);
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
					TextView target = (TextView)v;
					TextView dragged = (TextView)event.getLocalState();
					reaction();
					String result = MyEquation.Sum(dragged.getText(), target.getText());
					target.setText(result);
					
					
					break;
					
					
			}
			return true;
		}
		
	};
	
}
