package edu.auburn.csse.comp3710;

import edu.auburn.csse.comp3710.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questions extends Activity {
	int score;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        setCurrentQuestion();
        score = 0;
    }
    
    public void wrongAnswer(View view) {
    	Intent resultIntent = new Intent();
    	resultIntent.putExtra("result", score);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
    
    public void setCurrentQuestion() {
    	//in future will be pulled from database
    	Button correctAnswer = (Button)findViewById(R.id.Answer1);
    	correctAnswer.setText("Gene Chizik");
    	Button wrongAnswer1 = (Button)findViewById(R.id.Answer2);
    	wrongAnswer1.setText("Tommy Tuberville");
    	Button wrongAnswer2 = (Button)findViewById(R.id.Answer3);
    	wrongAnswer2.setText("Will Muschamp");
    	Button wrongAnswer3 = (Button)findViewById(R.id.Answer4);
    	wrongAnswer3.setText("Trooper Taylor");
	}
    
    public void correctAnswer(View view) {
    	score += 1;
    }

}
