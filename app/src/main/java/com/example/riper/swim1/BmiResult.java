package com.example.riper.swim1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResult extends AppCompatActivity {

	private static final String key = "bmiValue";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_bmi_result);
		displayBmi();
	}

	void displayBmi(){
		double bmi = this.getIntent().getExtras().getDouble(key, 0.0);
		TextView bmiTextView = (TextView) findViewById(R.id.textView_bmi_result);
		bmiTextView.setText(String.format("%.2f", bmi));
		// Wykonaj odpowiednią akcję
		BmiAction action = new BmiActionChangeBackgroundColor(new BmiInterpreter(bmi).interpret(), this);
		action.action();
	}

	public static void start(Context context, double value) {
	    Intent starter = new Intent(context, BmiResult.class);
	    starter.putExtra(key, value);
	    context.startActivity(starter);
	}
}
