package com.example.riper.swim1;

public class BmiForLbIn extends BMI {

	public BmiForLbIn(double mass, double height){
		super(mass, height);
	}

	public double calculateBmi() throws IllegalArgumentException{
		if(mass <= 0 || height <= 0) throw new IllegalArgumentException();
		return mass / (height * height) * 703;
	}
}
