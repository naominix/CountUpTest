package com.example.countup.test;

import com.example.countup.MainActivity;
import com.example.countup.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private TextView mTextView;
	private Button mButton;
	
	public MainActivityTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		MainActivity activity = getActivity();
		
		mTextView = (TextView) activity.findViewById(R.id.text_view);
		mButton = (Button) activity.findViewById(R.id.count_button);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPreConditions() {
		assertEquals(mTextView.getText(), "0");
	}
	
	private void buttonClick() {
		getActivity().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				mButton.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
	}
	
	public void testButtonClick() {
		assertEquals("0", mTextView.getText());
		buttonClick();
		assertEquals("1", mTextView.getText());
		buttonClick();
		assertEquals("2", mTextView.getText());
		buttonClick();
	}
}
