package edu.auburn.csse.comp3710;

import java.util.Arrays;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AuburnTriviaGame extends Activity {
    /** Called when the activity is first created. */
	public final String PREFS_NAME = "AuburnTrivia";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startActivity(new Intent(this, AuburnTriviaSplash.class));
    }
    
    public void highScores(View v) {
    	Log.d("HighScores", "starting high scores");
        startActivity(new Intent(this, AuburnTriviaHighScores.class));
    }
    
    public void newGame(View v) {
    	final CharSequence[] topics = {"Any", "Sports", "General"};
    	final AuburnTriviaGame that = this;
    	Log.d("newGame", "started");
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Pick a Topic");
    	builder.setSingleChoiceItems(topics, -1, new DialogInterface.OnClickListener() {
    		@Override
    	    public void onClick(DialogInterface dialog, int item) {
    	        Intent game = new Intent(that, Questions.class);
    	        game.putExtra("topic", item);
    	        dialog.dismiss();
    	        startActivityForResult(game, 1);
    	    }
    	});
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
    @Override 
    public void onActivityResult(int requestCode, int resultCode, Intent data) {     
      super.onActivityResult(requestCode, resultCode, data); 
      switch(requestCode) { 
      	case (1) : { 
      		if (resultCode == Activity.RESULT_OK) { 
      			int new_score = data.getIntExtra("result", 0);
      			
      			int[] scores = new int[6];
    	        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    	        scores[0] = settings.getInt("high1", 0);
    	        scores[1] = settings.getInt("high2", 0);
    	        scores[2] = settings.getInt("high3", 0);
    	        scores[3] = settings.getInt("high4", 0);
    	        scores[4] = settings.getInt("high5", 0);
    	        scores[5] = new_score;
    	        
    	        // Log.d("Game", "before" + Arrays.toString(scores));
    	        Arrays.sort(scores);
    	        // Log.d("Game", "before" + Arrays.toString(scores));
    	        SharedPreferences.Editor update = settings.edit();
    	            	        
    	        update.putInt("high1", scores[5]);
    	        update.putInt("high2", scores[4]);
    	        update.putInt("high3", scores[3]);
    	        update.putInt("high4", scores[2]);
    	        update.putInt("high5", scores[1]);    	        
                update.commit();
      			
      			Context context = getApplicationContext();
      			CharSequence text = "Correct Answers: " + Integer.toString(new_score);
      			int duration = Toast.LENGTH_LONG;

      			Toast toast = Toast.makeText(context, text, duration);
      			toast.show();
      		} 
      		break; 
      	} 
      } 
    }
}