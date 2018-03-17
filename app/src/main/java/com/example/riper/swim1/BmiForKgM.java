package com.example.riper.swim1;

public class BmiForKgM extends BMI {

	public BmiForKgM(double mass, double height){
		super(mass, height);
	}

	public double calculateBmi() throws IllegalArgumentException{
		if(mass <= 0 || height <= 0) throw new IllegalArgumentException();
		return mass / (height * height);
	}
}
