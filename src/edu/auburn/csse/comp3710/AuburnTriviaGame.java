package edu.auburn.csse.comp3710;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AuburnTriviaGame extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
      			// TODO Switch tabs using the index.
      		} 
      		break; 
      	} 
      } 
    }
}