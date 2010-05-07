package edu.auburn.csse.comp3710;

import edu.auburn.csse.comp3710.R;
import edu.auburn.csse.comp3710.DataHelper.QuestionTypes;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questions extends Activity {
	int score;
	public DataHelper QuestionDB;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        
        //initialize db
        QuestionDB = new DataHelper(this);
        setCurrentQuestion();
        
        score = 0;   
    }
    
    public void wrongAnswer(View view) {
    	endQuestions();
    }
    
    public void setCurrentQuestion() {
    	//String test = QuestionDB.selectQuestion(QuestionTypes.AU, 1);
    	String[] currentQuestion = QuestionDB.selectQuestion(QuestionTypes.AU, 1);
    		
    	//TODO: Dynamically change order so first answer is not always the correct answer 
    	
    	TextView question = (TextView)findViewById(R.id.Question);
    	question.setText(currentQuestion[0]);
    	Button correctAnswer = (Button)findViewById(R.id.Answer1);
    	correctAnswer.setText(currentQuestion[1]);
    	Button wrongAnswer1 = (Button)findViewById(R.id.Answer2);
    	wrongAnswer1.setText(currentQuestion[2]);
    	Button wrongAnswer2 = (Button)findViewById(R.id.Answer3);
    	wrongAnswer2.setText(currentQuestion[3]);
    	Button wrongAnswer3 = (Button)findViewById(R.id.Answer4);
    	wrongAnswer3.setText(currentQuestion[4]);
	}
    
    public void correctAnswer(View view) {
    	score += 1;
    	updateQuestions();
    }
    
    public void endQuestions() {
    	Intent resultIntent = new Intent();
    	resultIntent.putExtra("result", score);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
    
    public void updateQuestions() {
    	if (score >= 10) {
    		endQuestions();
    	}
    }

}
