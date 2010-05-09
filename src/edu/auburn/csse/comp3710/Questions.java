package edu.auburn.csse.comp3710;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import edu.auburn.csse.comp3710.R;
import edu.auburn.csse.comp3710.DataHelper.QuestionTypes;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends Activity {
	int score;
	QuestionTypes topic;
	public DataHelper QuestionDB;
	int difficulty = 1;
	int QuestionCount = 1;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("onCreate", "Called");
        
        Bundle extras = getIntent().getExtras();
        difficulty = extras.getInt("difficulty") + 1;
        
        // "Any", "Engineering", "Sports", "General"
        switch (extras.getInt("topic")) {
        case 0:
        	topic = QuestionTypes.Any;
        	break;
        case 1:
        	topic = QuestionTypes.Eng;
        	break;
        case 2:
        	topic = QuestionTypes.Sports;
        	break;
        case 3:
        	topic = QuestionTypes.General;
        	break;
        }
        
        Context context = getApplicationContext();
        CharSequence text = "Difficulty: " + Integer.toString(difficulty);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        
        // initialize db
        QuestionDB = new DataHelper(this);
        setContentView(R.layout.questions);
        nextQuestion(); 
        
        score = 0;  
        
        //set up lifeline listners
        
        Button HintButtom = (Button)findViewById(R.id.HintButton);
        HintButtom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView hintText = (TextView)findViewById(R.id.hint);
				hintText.setVisibility(hintText.VISIBLE);
				Button hintButton = (Button)findViewById(R.id.HintButton);
				hintButton.setVisibility(hintButton.INVISIBLE);
				
			}
		});
        
        
    }
    
    public void setCurrentQuestion(int difficulty) {
    	Question currentQuestion = new Question(QuestionDB, difficulty, topic);
    	String[] WrongAnswers = currentQuestion.getWrongAnswers();
    	//TODO: Dynamically change order so first answer is not always the correct answer 
    	try {
	    	TextView question = (TextView)findViewById(R.id.Question);
	    	question.setText(currentQuestion.getQuestion());	    	
	    	
	    	TextView hint = (TextView)findViewById(R.id.hint);
	    	hint.setText("HINT:  " + currentQuestion.getHint());
	    	hint.setVisibility(hint.INVISIBLE);
	    	
	    	ArrayList<Button> list = new ArrayList<Button>(4);
	    	list.add((Button)findViewById(R.id.Answer1));
	    	list.add((Button)findViewById(R.id.Answer2));
	    	list.add((Button)findViewById(R.id.Answer3));
	    	list.add((Button)findViewById(R.id.Answer4));
	    	
	    	
	    	
	    	Collections.shuffle(list);
	    	
	    	Button btn = list.remove(0);
	    	btn.setText(currentQuestion.getCorrectAnswer());
	    	btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					score += 1;
	    	    	updateQuestions();
				}
			});
	    	btn = list.remove(0);
	    	btn.setText(WrongAnswers[0]);
	    	btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				    endQuestions();					
				}
			});
	    	btn = list.remove(0);
	    	btn.setText(WrongAnswers[1]);
	    	btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				    endQuestions();					
				}
			});
			btn = list.remove(0);
	    	btn.setText(WrongAnswers[2]);
	    	btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				    endQuestions();					
				}
			});
    	}
    	catch(Exception EX)
    	{
    		Log.e("Questions", EX.getMessage());
    	} 	
    	
    	
	}
    
    public void endQuestions() {
    	Intent resultIntent = new Intent();
    	resultIntent.putExtra("result", score);
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
    
    public void updateQuestions() {
    	if (score == 13) {
    		endQuestions();
    	}
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
    
    public void executeHint()
    {
    	TextView hint = (TextView)findViewById(R.id.hint);
    	hint.setVisibility(1);
    }

}
