package com.example.riper.swim1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMIResult extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_bmi_result);
		Intent getBmiIntent = getIntent();
		double bmi = getBmiIntent.getDoubleExtra("Result", -1);
		TextView bmiTextView = (TextView) findViewById(R.id.textView_bmi_result);
		DecimalFormat format = new DecimalFormat("#.00");
		bmiTextView.setText(format.format(bmi));
	}
}
