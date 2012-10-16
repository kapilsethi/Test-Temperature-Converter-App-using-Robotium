package com.example.com.android.temperatureconverter.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.example.com.android.temperatureconverter.MainActivity;
import com.jayway.android.robotium.solo.Solo;

public class TemperatureConverterTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private Solo solo;
	
	@SuppressWarnings("deprecation")
	public TemperatureConverterTest() {
		super("com.example.com.android.temperatureconverter",MainActivity.class);
	}
	
	protected void setUp() throws Exception {
		//super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	//Test for Fahrenheit to Celsius conversion functionality
	public void testFahrenheitToCelsiusConversion(){
		solo.enterText(0, "77");
		solo.clickOnRadioButton(0);
		solo.clickOnButton("Convert");
		assertTrue(solo.searchText("25.0"));
		Assert.assertEquals(false, solo.isRadioButtonChecked(0));
		Assert.assertEquals(true, solo.isRadioButtonChecked(1));
	}
	
	//Test for Celsius to Fahrenheit conversion functionality
	public void testCelsiusToFahrenheitConversion(){
		solo.enterText(0, "25");
		solo.clickOnRadioButton(1);
		solo.clickOnButton("Convert");
		EditText textView = solo.getEditText(0);
		String actualOutput = textView.getText().toString();
		Assert.assertEquals("13.0", actualOutput);
		Assert.assertEquals(true, solo.isRadioButtonChecked(0));
		Assert.assertEquals(false, solo.isRadioButtonChecked(1));
	}
	
	//Test for Clear functionality
	public void testClearFunctionality(){
		solo.enterText(0, "25.00");
		solo.clickOnButton("Clear");
		EditText textView = solo.getEditText(0);
		Assert.assertEquals("", textView.getText().toString());
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
