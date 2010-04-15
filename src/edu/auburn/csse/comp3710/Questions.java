package edu.auburn.csse.comp3710;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Questions extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
    }
    
    public void correctAnswer(View view) {
    	Intent resultIntent = new Intent();
    	resultIntent.putExtra("result", 1);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
}
