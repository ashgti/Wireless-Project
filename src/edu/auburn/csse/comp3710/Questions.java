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
	int difficulty = 1;
	int QuestionCount = 1;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //initialize db
        QuestionDB = new DataHelper(this);
        setContentView(R.layout.questions);
        nextQuestion(); 
        
        score = 0;
        
    }
    
    public void wrongAnswer(View view) {
    	Intent resultIntent = new Intent();
    	resultIntent.putExtra("result", score);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
    
    public void setCurrentQuestion(int difficulty) {
    	Question currentQuestion = new Question(QuestionDB, difficulty);
    	String[] WrongAnswers = currentQuestion.getWrongAnswers();
    	//TODO: Dynamically change order so first answer is not always the correct answer 
    	
    	try{
    	TextView question = (TextView)findViewById(R.id.Question);
    	question.setText(currentQuestion.getQuestion());
    	Button correctAnswer = (Button)findViewById(R.id.Answer1);
    	correctAnswer.setText(currentQuestion.getCorrectAnswer());
    	Button wrongAnswer1 = (Button)findViewById(R.id.Answer2);
    	wrongAnswer1.setText(WrongAnswers[0]);
    	Button wrongAnswer2 = (Button)findViewById(R.id.Answer3);
    	wrongAnswer2.setText(WrongAnswers[1]);
    	Button wrongAnswer3 = (Button)findViewById(R.id.Answer4);
    	wrongAnswer3.setText(WrongAnswers[2]);
    	}
    	catch(Exception EX)
    	{
    		System.out.println(EX);
    	}
	}
    
    public void correctAnswer(View view) {
    	score += 1;
    	nextQuestion();
    }
    
    public void nextQuestion()
    {
    	
    	if(QuestionCount < 13)
    	{
    		
    	difficulty = QuestionCount/3;
    	
    	if(QuestionCount%3 != 0)
    	{
    		difficulty++;
    	}
    		
    	switch (difficulty) 
    	{
			case 1:
				setCurrentQuestion(1);
				break;

			case 2:
				setCurrentQuestion(2);
				break;
	
			case 3:
				setCurrentQuestion(3);
				break;

			case 4:
				setCurrentQuestion(4);
				break;

			
			default:
				break;
		}
    	
    	QuestionCount++;
    	
    	}
    }

}
