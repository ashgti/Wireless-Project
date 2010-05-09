package edu.auburn.csse.comp3710;

import java.util.Random;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import edu.auburn.csse.comp3710.DataHelper.QuestionTypes;

public class Question {
	private String Question;
	private String CorrectAnswer;
	private String[] WrongAnswer = new String[3];
	private String QuestionHint;
	
	public Question(DataHelper QuestionDB, int difficulty, QuestionTypes topic) {		
    	String[] currentQuestion = QuestionDB.selectQuestion(topic, difficulty); 
    	
    	Question = currentQuestion[0];
    	CorrectAnswer = currentQuestion[1];
    	WrongAnswer[0] = currentQuestion[2];
    	WrongAnswer[1] = currentQuestion[3];
    	WrongAnswer[2] = currentQuestion[4];
    	QuestionHint = currentQuestion[5];
	}
	
	public String getCorrectAnswer()
	{
		return CorrectAnswer;
	}
	
	public String[] getWrongAnswers()
	{
		
		return WrongAnswer;
	}
	
	public void removeWrongAnswer()
	{
		Random generator = new Random();
		int randomQuestionNum = generator.nextInt();
		int questionSelect = randomQuestionNum % 3;
	}
	
	public String[] executeFiftyFifty()
	{
		removeWrongAnswer();
		removeWrongAnswer();
		
		return WrongAnswer;
	}
	
	public String executeCram()
	{
		int iterator = 0;
		
		//calculate random to see if it will pick correct or not
		Random generator = new Random();
		int generatedRandom = generator.nextInt(100);
		if(generatedRandom < 75)
		{
			return CorrectAnswer; 
		}
		else
		{
			
			
			while(iterator < 3)
			{
				if(WrongAnswer[iterator] != null)
				{
					return WrongAnswer[iterator];
				}
			}
		}		
		
		return CorrectAnswer;
	}
	
	public String getHint()
	{
		return QuestionHint;
	}
	
	public String getQuestion()
	{
		return Question;
	}
}
