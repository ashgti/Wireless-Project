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
   private static final int DATABASE_VERSION = 2;

   public enum QuestionTypes {AU, Sports, Eng};
   
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
	   Cursor cursor = this.db.rawQuery("select * from AUQuestions", null);
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
	this.db.execSQL(" insert into AUQuestions (question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, difficulty, used) values ('What year did Auburn open?', '1856', '1808', '1890', '2005', 1, 0);");
	
}

   public String[] selectQuestion(QuestionTypes type, int difficulty)
   {
	   Cursor question = null;
	   
	   try
	   {
		   String[] columns = {"question", "correctAnswer"};
		   //question = this.db.query(type + "Questions", columns, null, null, null, null, null);
		   question = this.db.rawQuery("select question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3 from " + type + "Questions where difficulty = " + difficulty + " and used = 0;", null);
		   
	   }
	   catch(Exception ex)
	   {
		   System.out.println(ex);
	   }
	   
	   String result[] = new String[5];
	   
	   
	   question.moveToFirst();
	   
	   for(int iterator = 0; iterator < 5; iterator++ )
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
         db.execSQL("CREATE TABLE EngQuestions(id INTEGER PRIMARY KEY, question TEXT, correctAnswer TEXT, wrongAnswer1 TEXT, wrongAnswer2 TEXT, wrongAnswer3 TEXT, difficulty INTEGER, used INTEGER)");
         db.execSQL("CREATE TABLE SportsQuestions(id INTEGER PRIMARY KEY, question TEXT, correctAnswer TEXT, wrongAnswer1 TEXT, wrongAnswer2 TEXT, wrongAnswer3 TEXT, difficulty INTEGER, used INTEGER)");
         db.execSQL("CREATE TABLE AUQuestions(id INTEGER PRIMARY KEY, question TEXT, correctAnswer TEXT, wrongAnswer1 TEXT, wrongAnswer2 TEXT, wrongAnswer3 TEXT, difficulty INTEGER, used INTEGER)");
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         Log.w("Example", "Upgrading database, this will drop tables and recreate.");
         db.execSQL("DROP TABLE IF EXISTS EngQuestions");
         db.execSQL("DROP TABLE IF EXISTS SportsQuestions");
         db.execSQL("DROP TABLE IF EXISTS AUQuestions");
         onCreate(db);
      }
   }
}

