package com.example.riper.swim1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.Toast;

public class BmiActivity extends AppCompatActivity {

	double BMI = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bmi_main);
        //Pasek menu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	    setSupportActionBar(toolbar);
	    //Ustaw Listenery dla przycisków
	    setButtonsListeners();
    }

    void setButtonsListeners(){
	    //Przycisk count
	    OnClickListener countButtonListener = new OnClickListener(){
		    public void onClick(View view){
			    moveToResultActivity();
		    }
	    };
	    Button buttonCount = findViewById(R.id.button_compute);
	    buttonCount.setOnClickListener(countButtonListener);
	    //Zmiana jednostek
	    final Switch switchUnits = (Switch) findViewById(R.id.switch_units);
	    switchUnits.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			    if (isChecked) {
				    switchUnits.setText(R.string.switch_units_imperial);
			    } else {
				    switchUnits.setText(R.string.switch_units_SI);
			    }
		    }
	    });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.bmi_activity_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.main_menu_item_about:
				moveToAboutActivity();
				return true;
			case R.id.main_menu_item_save:
				sharedPrefs();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void moveToAboutActivity(){
    	AboutActivity.start(this);
	}

	private void moveToResultActivity(){
		try{
			double bmi = parseInputAndCompute();
			BMI = bmi;
			BmiResult.start(this, bmi);
		}
		catch(IllegalArgumentException e){
			Toast.makeText(getApplicationContext(), R.string.error_message, Toast.LENGTH_SHORT).show();
		}
	}

	private double parseInputAndCompute() throws IllegalArgumentException{
		EditText weightText = (EditText) findViewById(R.id.editText_weight);
		EditText heightText = (EditText) findViewById(R.id.editText_height);
		double mass = 0, height = 0;
		BMI bmi;
		mass = Double.parseDouble(weightText.getText().toString());
		height = Double.parseDouble(heightText.getText().toString());
		// Rzuć wyjątek dalej jeżeli jest
		Switch switchUnits = (Switch) findViewById(R.id.switch_units);
		if(switchUnits.isChecked()){
			bmi = new BmiForLbIn(mass, height);
		}
		else{
			bmi = new BmiForKgM(mass, height);
		}
		return bmi.calculateBmi();
	}

	private void sharedPrefs(){
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putFloat(getResources().getString(R.string.shared_pref_key), (float)BMI);
		editor.apply();
		Toast.makeText(getApplicationContext(), R.string.shared_pref_saved, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStop(){
    	super.onStop();
    	// Daj wartości wpisane w pola tekstowe
		EditText weightText = (EditText) findViewById(R.id.editText_weight);
		EditText heightText = (EditText) findViewById(R.id.editText_height);
		String mass = weightText.getText().toString();
		String height = heightText.getText().toString();
		// Zapisanie tych wartości przy wychodzeniu z aktywności
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(getResources().getString(R.string.shared_pref_mass), mass);
		editor.putString(getResources().getString(R.string.shared_pref_height), height);
		editor.apply();
	}

	@Override
	protected void onStart(){
		super.onStart();
		// Odczytanie wartości przy wchodzeniu do aktywności
		SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		String mass = sharedPref.getString(getResources().getString(R.string.shared_pref_mass), null);
		String height = sharedPref.getString(getResources().getString(R.string.shared_pref_height), null);
		editor.apply();
		// Pobierz ID pól tekstowych by ustawić teksty na nich
		EditText weightText = (EditText) findViewById(R.id.editText_weight);
		EditText heightText = (EditText) findViewById(R.id.editText_height);
		weightText.setText(mass);
		heightText.setText(height);
	}

}
