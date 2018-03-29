package com.example.riper.swim1;

public class BmiInterpreter {

	private double bmi;

	protected double mass = 0;
	protected double height = 0;
	private final static double GOOD_LOW = 18.5;
	private final static double GOOD_HI = 25;
	private final static double MED_LOW = 16;
	private final static double MED_HI = 30;

	BmiInterpreter(double bmi){
		this.bmi = bmi;
	}

	BmiStatus interpret(){
		if(bmi < MED_LOW) return BmiStatus.LOW_BAD;
		else if(bmi < GOOD_LOW) return BmiStatus.LOW_MED;
		else if(bmi < GOOD_HI) return BmiStatus.GOOD;
		else if(bmi < MED_HI) return BmiStatus.HI_MED;
		else return BmiStatus.HI_BAD;
	}

}
