package com.goodwill.getwell;
import java.util.Calendar;

import com.goodwill.getwell.databasemgr.DatabaseManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

 
public class CurrentGoalScreen extends Activity {
 
	ImageButton todaysChallengeButton; 
	Button findFriendsButton;
	TextView time;
	TextView challengeDesc;
	Challenge c;
	
	
	
	//Boolean to decide if Challenge was Accepted
	boolean challengeAccepted = false;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.current_goal_screen);
		setUpVars();
	}
	
	private void setUpVars(){
		c = DatabaseManager.fetchDailyChallenge();
		todaysChallengeButton = (ImageButton) findViewById(R.id.todaysChallengeButton);
		findFriendsButton = (Button) findViewById(R.id.findFriendsButton);
		challengeDesc = (TextView) findViewById(R.id.textView1);
		challengeDesc.setText(c.getChallengeName());
		//If $ Button pressed, go to description
		todaysChallengeButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(CurrentGoalScreen.this, TodaysChallenge.class);
				CurrentGoalScreen.this.startActivity(intent);
				
			}
		});
		
		findFriendsButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				//Show Multiple Choice Dialog Box

				
			}
		});
		
		//Set the left time
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int timeLeft = 24-hour;
		String timeleft = Integer.toString(timeLeft);
		time = (TextView)findViewById(R.id.time);
		time.setText(timeleft);
		
		
		
		
		
		
	}
 
	//Override Back Button
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK ) {
	        //do your stuff
	    	Intent intent = new Intent(CurrentGoalScreen.this, WelcomeScreen.class);
			CurrentGoalScreen.this.startActivity(intent);
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	
	public void welcomeOnClick(View view){
		Intent intent = new Intent(CurrentGoalScreen.this, WelcomeScreen.class);
		CurrentGoalScreen.this.startActivity(intent);
				
	}
 
}
