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

/*
1. Testy mają być
2. Ma się poprawnie obracać i dobrze po tym wyglądać


5. Wynik ma być zapisywany sharedPrefs, ikonka obok "3 kropki"



 */
