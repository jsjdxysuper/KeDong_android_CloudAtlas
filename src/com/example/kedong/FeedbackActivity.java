package com.example.kedong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		LayoutInflater inflater = getLayoutInflater();
		ViewGroup feedbackActivityViewGroup = (ViewGroup)inflater.inflate(R.layout.feedback_activity_mainxml, null);
//		(ViewGroup)findViewById(R.layout.feedback_activity_mainxml);
		Button cancelButton = (Button)feedbackActivityViewGroup.findViewById(R.id.cancelInFeedbackActivity);
		cancelButton.setClickable(true);
		cancelButton.setFocusable(true);
		cancelButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
				FeedbackActivity.this.setResult(1, intent);
				FeedbackActivity.this.finish();

			}
			
		});
		
		Button sendButton = (Button)feedbackActivityViewGroup.findViewById(R.id.sendInFeedbackActivity);
		sendButton.setClickable(true);
		sendButton.setFocusable(true);
		sendButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(FeedbackActivity.this, "·¢ËÍ³É¹¦", Toast.LENGTH_SHORT).show();
				Intent intent = getIntent();
				FeedbackActivity.this.setResult(1, intent);
				FeedbackActivity.this.finish();

			}
			
		});
		
		setContentView(feedbackActivityViewGroup);
	}
}
