package database.MagicwordDbSchema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MagicstenceBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION=1;
    private static final String DATEBASE_NAME="Magicworddb1";
    public MagicstenceBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATEBASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Magicsentencedb(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sentence VARCHAR(255)," +
                "word VARCHAR(255))");

       /* //db.execSQL("CREATE TABLE Magicworddb(" +
                "wordid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "word VARCHAR(20)," +
                "yinbiao VARCHAR(255)," +
                "mean VARCHAR(255)," +
                "example VARCHAR(255))");*/
        db.execSQL(
                "INSERT INTO Magicsentencedb(id,sentence,word) values(?,?,?)",new Object[] { 446,
                        "So ________ is time that we can't afford to waste it",
                        "precious"});

        db.execSQL(
                "INSERT INTO Magicsentencedb(id,sentence,word) values(?,?,?)",new Object[] { 448,
                        "When it comes to low-carbon economy, it's advantages far outweigh ________________.",
                        "itsdisadvantages"});
        db.execSQL(
                "INSERT INTO Magicsentencedb(id,sentence,word) values(?,?,?)",new Object[] { 460,
                        "I would like to meet you there and please let me know your ________.",
                        "decision"});
        db.execSQL(
                "INSERT INTO Magicsentencedb(id,sentence,word) values(?,?,?)",new Object[] { 456,
                        "According to a recent survey, four million people die each year from ______________ to smoking.",
                        "diseaseslinked"});



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }
}
