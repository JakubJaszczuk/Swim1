package com.example.riper.swim1;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void for_valid_data(){
        BMI bmiCounter = new BmiForKgM(60, 1.70);
        double bmi = bmiCounter.calculateBmi();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_mass_and_height_throw_exception(){
        BMI bmiCounter = new BmiForKgM(0, 0);
        double bmi = bmiCounter.calculateBmi();
        //assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minus_mass_and_height_throw_exception(){
        BMI bmiCounter = new BmiForKgM(-10, -20);
        double bmi = bmiCounter.calculateBmi();
        //assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minus_mass_positive_height_imperial_throw_exception(){
        BMI bmiCounter = new BmiForLbIn(-20, 20);
        double bmi = bmiCounter.calculateBmi();
        //assertEquals(20.761, bmi, 0.001);
    }

	@Test(expected = IllegalArgumentException.class)
	public void mass_minus_height_imperial_throw_exception(){
		BMI bmiCounter = new BmiForLbIn(40, -0.1);
		double bmi = bmiCounter.calculateBmi();
		//assertEquals(20.761, bmi, 0.001);
	}

	@Test
	public void valid_imperial(){
		BMI bmiCounter = new BmiForLbIn(180, 80);
		double bmi = bmiCounter.calculateBmi();
		assertEquals(19.771, bmi, 0.001);
	}
}
/*
1. listview
2.
 */
