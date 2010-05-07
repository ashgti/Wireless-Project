package edu.auburn.csse.comp3710;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class DataHelper {

   private static final String DATABASE_NAME = "AuburnTrivia.db";
   private static final int DATABASE_VERSION = 8;

   public enum QuestionTypes {Auburn, Sports, Eng};
   
   private Context context;
   private SQLiteDatabase db;

   private SQLiteStatement insertStmt;

   public DataHelper(Context context) {
      this.context = context;
      OpenHelper openHelper = new OpenHelper(this.context);
      this.db = openHelper.getWritableDatabase();
      //this.insertStmt = this.db.compileStatement(INSERT);
      checkData();
   }

   private void checkData() 
   {
	   Cursor cursor = this.db.rawQuery("select * from AuburnQuestions", null);
	   cursor.moveToFirst();
	   
	   try
	   {
		   cursor.isNull(0);
	   }
	   catch(Exception ex)
	   {
		   populateDatabase();
	   }
	
   }

private void populateDatabase() {
	// TODO create insert statements for all questions
	
	try{
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who is the current head Football Coach?', 'Gene Chizik', 'Tommy Tuberville', 'Trooper Taylor', 'Will Muschamp', 'No Troop',1,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES (' What is the name of the official Auburn fight song?', 'War Eagle', 'Auburn Fight!', 'Bodagetta', 'Aubies Song', 'No Tiger',1,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('In what year did Auburn win the AP National Championship?', '1957', '2004', '1998', '1902', 'Only',2,0)");
	this.db.execSQL(" INSERT INTO AuburnQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('When was Auburn Founded?', '1856', '1902', '1735', '1954', 'Even',2,0)");
	this.db.execSQL(" INSERT INTO AuburnQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What was Auburn's original name when it was founded?', 'Auburn Polytechnic Institute ', 'University of Auburn', 'Auburn Agriculture and Engineering University', 'Auburn College', 'Not a College',3,0)");
	this.db.execSQL(" INSERT INTO AuburnQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What country music star made a surprise visit to the Auburn Campus in the spring of 2010?', 'Taylor Swift', 'Tim Mcgraw', 'Brad Paisley', 'Miranda Lambert', 'Female',3,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What is the name of Auburn's mascot?', 'Aubie', 'Spirit', 'War Eagle', 'Bo', 'Doesnt Fly',1,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who drafted Bo Jackson in the 1985 NFL draft?', 'Tampa Bay', 'Oakland', 'Dallas', 'San Diego', 'Sailing',4,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What year did Bo Jackson win the Heisman trophy?', '1985', '1988', '1981', '1978', 'odd',3,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('How many yards did Carnell Williams amass as a Tiger?', '3831', '3765', '4098', '3984', 'odd',4,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who has scored the most touchdowns in Auburn's history?', 'Carnell Williams', 'Bo Jackson', 'Ben Tate', 'Stephen Davis', 'No Bo',4,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who has thrown for the most yards in school history?', 'Stan White', 'Jason Campbell', 'Brandon Cox', 'Pat Sullivan', 'Really?',4,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who was the quarterback for the 2004 undefeated team?', 'Jason Campbell', 'Brandon Cox', 'Ben Leard', 'Pat Sullivan', 'No Heisman',2,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who has the most career receptions in school history?', 'Courtney Taylor', 'Terry Beasley', 'Ben Obomanu', 'Frank Sanders', 'Girl?',3,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who is the all time sack leader at Auburn?', 'Quentin Groves', 'Tracy Rocker', 'Reggie Torbor', 'Stanley McClover', 'Not Coach',3,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('When was the first Iron Bowl played?', '1893', '1902', '1910', '1921', 'Old',3,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who is Auburn's opponent in the Iron Bowl?', 'Alabama', 'Georgia', 'Georgia Tech', 'LSU', 'No Jackets',1,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Who is Auburn's opponent in the Deep South's oldest rivarly?', 'Georgia', 'Alabama', 'Georgia Tech', 'Ole Miss', 'Hedges',1,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('Auburn has won the Southeastern Conference how many times?', '6', '3', '4', '8', 'not the most',2,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What Auburn player won the Outland and Lombardi Trophies in 1988?', 'Tracy Rocker', 'Zeke Smith', 'Matt Land', 'Reggie Slack', 'No Slack',3,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What Auburn player won the Jim Thorpe award in 2004?', 'Carlos Rogers', 'Ronnie Brown', 'Jason Campbell', 'Courtney Taylor', 'DB',2,0)");
	this.db.execSQL(" INSERT INTO SportsQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What was Auburn's first bowl game?', 'Bacardi Bowl', 'Cotton Bowl', 'Orange Bowl', 'Gator Bowl', 'No Big D',3,0)");
	this.db.execSQL(" INSERT INTO AuburnQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What architectural detail is used as the emblem representing the College of Engineering?', 'Cupola', 'Arch', 'Dormer', 'Buttress', 'No Butts',2,0)");
	this.db.execSQL(" INSERT INTO AuburnQuestions (Question, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3, Hint, Difficulty, Used) VALUES ('What is the name of the iconic building that houses the President's Office?', 'Samford', 'Shelby ', 'Thach', 'Haley', 'no Shelby',1,0)");
	}
	catch(Exception EX)
	{
		System.out.println(EX);
	}

}

   public String[] selectQuestion(QuestionTypes type, int difficulty)
   {
	   Cursor question = null;
	   
	   //TODO: set used bit in DB for selected question
	   
	   try
	   {
		   String[] columns = {"question", "correctAnswer"};
		   //TODO: deal with when select doesnt exist
		   question = this.db.rawQuery("select question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, hint from " + type + "Questions where difficulty = " + difficulty + " and used = 0;", null);
		   
	   }
	   catch(Exception ex)
	   {
		   System.out.println(ex);
	   }
	   
	   String result[] = new String[6];
	   
	   
	   question.moveToFirst();
	   
	   for(int iterator = 0; iterator < 6; iterator++ )
	   {
		   result[iterator] = question.getString(iterator);
	   }
	   
	   
	   return result;
	   
   }

   private static class OpenHelper extends SQLiteOpenHelper {

      OpenHelper(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE EngQuestions(id INTEGER PRIMARY KEY, question TEXT, correctAnswer TEXT, wrongAnswer1 TEXT, wrongAnswer2 TEXT, wrongAnswer3 TEXT, hint TEXT, difficulty INTEGER, used INTEGER)");
         db.execSQL("CREATE TABLE SportsQuestions(id INTEGER PRIMARY KEY, question TEXT, correctAnswer TEXT, wrongAnswer1 TEXT, wrongAnswer2 TEXT, wrongAnswer3 TEXT, hint TEXT, difficulty INTEGER, used INTEGER)");
         db.execSQL("CREATE TABLE AuburnQuestions(id INTEGER PRIMARY KEY, question TEXT, correctAnswer TEXT, wrongAnswer1 TEXT, wrongAnswer2 TEXT, wrongAnswer3 TEXT, hint TEXT, difficulty INTEGER, used INTEGER)");
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         Log.w("Example", "Upgrading database, this will drop tables and recreate.");
         db.execSQL("DROP TABLE IF EXISTS EngQuestions");
         db.execSQL("DROP TABLE IF EXISTS SportsQuestions");
         db.execSQL("DROP TABLE IF EXISTS AuburnQuestions");
         onCreate(db);
      }
   }
}

