package edu.auburn.csse.comp3710;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Questions extends Activity {
	int score;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        score = 0;
    }
    
    public void wrongAnswer(View view) {
    	Intent resultIntent = new Intent();
    	resultIntent.putExtra("result", score);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
    
    public void correctAnswer(View view) {
    	score += 1;
    }
}
