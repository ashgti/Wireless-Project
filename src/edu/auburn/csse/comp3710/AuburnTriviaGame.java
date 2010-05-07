package edu.auburn.csse.comp3710;

import edu.auburn.csse.comp3710.DataHelper.QuestionTypes;
import android.app.Activity;
import android.content.Context;
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
    	Intent game = new Intent(this, Questions.class);
    	startActivityForResult(game, 1);
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