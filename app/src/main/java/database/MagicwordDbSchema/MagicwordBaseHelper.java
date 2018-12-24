package database.MagicwordDbSchema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.magicwords.fragments.ListenFragment;

public class MagicwordBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATEBASE_NAME="Magicworddb";
    public MagicwordBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATEBASE_NAME,null,VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Magicworddb(" +
                "wordid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "word VARCHAR(20)," +
                "yinbiao VARCHAR(255)," +
                "mean VARCHAR(255)," +
                "example VARCHAR(255))");

        db.execSQL("CREATE TABLE Magicstencedb(" +
                "wordid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "stence VARCHAR(20)," +
                "word VARCHAR(255))" );

        db.execSQL("INSERT INTO Magicstencedb(wordid,stence,word) values(?,?,?)",new Object[] { 446,
                "  So ______ is time that we can't afford to waste it. " ,"precious"});

        db.execSQL("INSERT INTO Magicstencedb(wordid,stence,word) values(?,?,?)",new Object[] { 448,
                "  When it comes to low-carbon economy, it's advantages far outweigh ______" ,"itsdisadvantages"});

        db.execSQL("INSERT INTO Magicstencedb(wordid,stence,word) values(?,?,?)",new Object[] { 456,
                "  According to a recent survey, four million people die each year from ______ to smoking." ,"diseaseslinked"});

        db.execSQL("INSERT INTO Magicstencedb(wordid,stence,word) values(?,?,?)",new Object[] { 460,
                "   I would like to meet you there and please let me know your ______." ,"decision"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 1,
                        "A",
                        "[ə]",
                        "一,一个,一只,一件.",
                        " I don't care what a car looks like as long as it gets me from A to B." +
                                "我倒不在乎汽车的样子, 只要能把我从一处载到另一处就行了. " +
                                "Would you do me a favor?    " +
                                "你能帮我一个忙吗？"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 2,
                        "abdominal",
                        "[æb'dɑːmɪnl]",
                        "a. 腹部的",
                        " I'll have an abdominal operation tomorrow.     我明天要做个腹部手术。 She had abdominal pains yesterday.     她昨天腹痛。"});
        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 3,
                        "across", "[ə'krɔːs]", "ad. 横过<br>  prep. 穿过,横过", " The two lines cut across each other.     两条线相交。 Can you swim across the river?    你能游到河的对岸吗？"});
        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 4,
                        "bored", "[bɔːrd]", "a. 厌烦的,无聊的", " He is a bored student.     他是一位感到厌烦的学生。 The condition of being bored; ennui.     厌烦处于厌烦的状态；无聊"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 5,
                        "boring", "['bɔːrɪŋ]", "a. 令人厌烦的<br>\nn. 钻孔", " It is boring to listen to the same story.     听相同的故事是令人厌烦的。 This is one of the few gratifications of an otherwise boring job.     这是枯燥的工作中少有的一项乐趣。/r/n"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 6,
                        "born", "[bɔːrn]", "a. 天生的<br> vbl. 出生", " The baby was born on 8 o'clock.     婴儿在8点钟出生。 I've never heard such nonsense in all my born days!     我一生中从未听到过这种胡言乱语。"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }

}
