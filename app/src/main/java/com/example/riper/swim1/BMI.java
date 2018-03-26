package com.example.riper.swim1;

abstract public class BMI {

	protected double mass = 0;
	protected double height = 0;
	final static double GOOD_LOW = 18.5;
	final static double GOOD_HI = 25;
	final static double MED_LOW = 16;
	final static double MED_HI = 30;


	public BMI(double mass, double height){
		this.mass = mass;
		this.height = height;
	}

	abstract public double calculateBmi() throws IllegalArgumentException;

}
