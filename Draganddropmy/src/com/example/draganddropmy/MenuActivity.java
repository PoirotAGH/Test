package com.example.draganddropmy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MenuActivity extends Activity implements OnClickListener{
@Override
public void onCreate (Bundle savedInstanceState)

{
super.onCreate(savedInstanceState);	
setContentView(R.layout.main);

View aboutButtonView = findViewById(R.id.button1);
aboutButtonView.setOnClickListener(this);
}

public void onClick(View view) {
	Intent i = new Intent(this, MainActivity.class);
	startActivity(i);
}

public boolean onCreateOptionsMenu(Menu menu) 
{
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}

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


}
