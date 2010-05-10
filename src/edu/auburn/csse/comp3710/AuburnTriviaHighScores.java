package edu.auburn.csse.comp3710;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AuburnTriviaHighScores extends Activity {
	public final String PREFS_NAME = "AuburnTrivia";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	Log.e("HighScores", "Loading...");
    	setContentView(R.layout.highscores);
        try {
	        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	        int high1 = settings.getInt("high1", 0);
	        int high2 = settings.getInt("high2", 0);
	        int high3 = settings.getInt("high3", 0);
	        int high4 = settings.getInt("high4", 0);
	        int high5 = settings.getInt("high5", 0);
	        
	        String scores = Integer.toString(high1) + "\n" + Integer.toString(high2) + "\n" + Integer.toString(high3) + "\n" + Integer.toString(high4) + "\n" + Integer.toString(high5);
	        
	        TextView score_listings = (TextView)findViewById(R.id.ScoresListing);
	        score_listings.setText(scores);
	        
	    	Log.d("HighScores", "high scores loaded");
        }
    	catch(Exception ex) {
        	Log.e("HighScores", "error");
        }
    }
}
