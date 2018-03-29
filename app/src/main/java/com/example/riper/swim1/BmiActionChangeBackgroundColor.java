package com.example.riper.swim1;

import android.app.Activity;
import android.widget.RelativeLayout;

public class BmiActionChangeBackgroundColor extends BmiAction {

	Activity activity;

	BmiActionChangeBackgroundColor(BmiStatus status, Activity activity){
		super(status);
		this.activity = activity;
	}

	void action(){
		RelativeLayout layout = activity.findViewById(R.id.layout_result);
		switch(status){
			case GOOD : layout.setBackgroundResource(R.color.bmi_result_good); break;
			case LOW_MED :
			case HI_MED : layout.setBackgroundResource(R.color.bmi_result_med); break;
			case LOW_BAD :
			case HI_BAD : layout.setBackgroundResource(R.color.bmi_result_bad); break;
		}
	}
}
