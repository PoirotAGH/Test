package com.example.draganddropmy;

import android.R.integer;

public class MyEquation 
{

	public static String Sum(CharSequence sum1, CharSequence sum2)
	{
		String result = new String();
		int current = Integer.parseInt((String) sum1);
		int after = Integer.parseInt((String) sum2);
		after = current + after;
		result = String.valueOf(after);
		return result;
	}
	public static String Diff(CharSequence diff1, CharSequence diff2)
	{
		String result = new String();
		int current = Integer.parseInt((String) diff1);
		int after = Integer.parseInt((String) diff2);
		after = current - after;
		result = String.valueOf(after);
		return result;
	}
	public static String Mult(CharSequence mult1, CharSequence mult2)
	{
		String result = new String();
		int current = Integer.parseInt((String) mult1);
		int after = Integer.parseInt((String) mult2);
		after = current * after;
		result = String.valueOf(after);
		return result;
	}
	public static String Div(CharSequence div1, CharSequence div2)
	{
		String result = new String();
		int current = Integer.parseInt((String) div1);
		int after = Integer.parseInt((String) div2);
		double result1  = current / after;
		if(result1 >= 0.0 && result1 < 1.0)
		{
			after = (int)result1 + 1;
		}
		else 
		{
			after = (int)result1;
		}
		result = String.valueOf(after);
		return result;
	}
	
	
}
