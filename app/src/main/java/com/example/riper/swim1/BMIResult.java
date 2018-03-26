package com.example.riper.swim1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMIResult extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_bmi_result);
		displayBmi();
	}

	void displayBmi(){
		Intent getBmiIntent = getIntent();
		double bmi = getBmiIntent.getDoubleExtra("Result", -1);
		TextView bmiTextView = (TextView) findViewById(R.id.textView_bmi_result);
		DecimalFormat format = new DecimalFormat("#.00");
		bmiTextView.setText(format.format(bmi));
		changeBackgroundColour(bmi);
	}

	void changeBackgroundColour(double bmi){
		RelativeLayout layout = findViewById(R.id.layout_result);
		if(bmi > BMI.GOOD_LOW && bmi < BMI.GOOD_HI){
			layout.setBackgroundResource(R.color.bmi_result_good);
		}
		else if(bmi > BMI.MED_LOW && bmi < BMI.MED_HI){
			layout.setBackgroundResource(R.color.bmi_result_med);
		}
		else{
			layout.setBackgroundResource(R.color.bmi_result_bad);
		}
	}

	/*
	public static void start(Context context) {
	    Intent starter = new Intent(context, BMIResult.class);
	    starter.putExtra();
	    context.startActivity(starter);
	}
	*/
}
