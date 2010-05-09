package edu.auburn.csse.comp3710;

import edu.auburn.csse.comp3710.DataHelper.QuestionTypes;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AuburnTriviaGame extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startActivity(new Intent(this, AuburnTriviaSplash.class));
    }
    
    public void newGame(View v) {
    	final CharSequence[] items = {"Easy", "Normal", "Hard", "Very Hard"};
    	final CharSequence[] topics = {"Any", "Engineering", "Sports", "General"};
    	final AuburnTriviaGame that = this;
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Pick a difficulty");
    	builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
    		@Override
    	    public void onClick(DialogInterface dialog, int item) {
    			final int difficulty = item;
    			dialog.dismiss();
    			AlertDialog.Builder builder = new AlertDialog.Builder(that);
    	    	builder.setTitle("Pick a Topic");
    	    	builder.setSingleChoiceItems(topics, -1, new DialogInterface.OnClickListener() {
    	    		@Override
    	    	    public void onClick(DialogInterface dialog, int item) {
    	    	        Intent game = new Intent(that, Questions.class);
    	    	        game.putExtra("difficulty", difficulty);
    	    	        game.putExtra("topic", item);
    	    	        dialog.dismiss();
    	    	        startActivityForResult(game, 1);
    	    	    }
    	    	});
    	    	AlertDialog alert = builder.create();
    	    	alert.show();
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
      			int tabIndex = data.getIntExtra("result", 0);
      			Context context = getApplicationContext();
      			CharSequence text = "Correct Answers: " + Integer.toString(tabIndex);
      			int duration = Toast.LENGTH_SHORT;

      			Toast toast = Toast.makeText(context, text, duration);
      			toast.show();
      		} 
      		break; 
      	} 
      } 
    }
}