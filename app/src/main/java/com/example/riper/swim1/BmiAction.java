package com.example.riper.swim1;

public abstract class BmiAction {

	BmiStatus status;

	BmiAction(BmiStatus status){
		this.status = status;
	}

	abstract void action();
}
