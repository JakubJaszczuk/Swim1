package com.example.riper.swim1;

abstract public class BMI {

	protected double mass = 0;
	protected double height = 0;

	public BMI(double mass, double height){
		this.mass = mass;
		this.height = height;
	}

	abstract public double calculateBmi() throws IllegalArgumentException;

}
