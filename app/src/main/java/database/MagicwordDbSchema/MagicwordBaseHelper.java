package database.MagicwordDbSchema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 1,
                        "a",
                        "[ə]",
                        "一,一个,一只,一件.",
                        "I don't care what a car looks like as long as it gets me from a to B.\r\n我倒不在乎汽车的样子, 只要能把我从一处载到另一处就行了.\r\nWould you do me a favor?\r\n你能帮我一个忙吗？"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 2,
                        "abdominal",
                        "[æb'dɑːmɪnl]",
                        "a. 腹部的",
                        " I'll have an abdominal operation tomorrow.\r\n我明天要做个腹部手术。\r\n She had abdominal pains yesterday.\r\n她昨天腹痛。\r\n"});
        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 3,
                        "across", "[ə'krɔːs]", "ad. 横过<br>\nprep. 穿过,横过", " The two lines cut across each other.\r\n两条线相交。\r\n Can you swim across the river?\r\n你能游到河的对岸吗？\r\n"});
        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 4,
                        "bored", "[bɔːrd]", "a. 厌烦的,无聊的", " He is a bored student.\r\n他是一位感到厌烦的学生。\r\n The condition of being bored; ennui.\r\n厌烦处于厌烦的状态；无聊\r\n"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 5,
                        "boring", "['bɔːrɪŋ]", "a. 令人厌烦的<br>\nn. 钻孔", " It is boring to listen to the same story.\r\n听相同的故事是令人厌烦的。\r\n This is one of the few gratifications of an otherwise boring job.\r\n这是枯燥的工作中少有的一项乐趣。\r\n"});

        db.execSQL(
                "INSERT INTO Magicworddb(wordid,word,yinbiao,mean,example) values(?,?,?,?,?)",new Object[] { 6,
                        "born", "[bɔːrn]", "a. 天生的<br>\nvbl. 出生", " The baby was born on 8 o'clock.\r\n婴儿在8点钟出生。\r\n I've never heard such nonsense in all my born days!\r\n我一生中从未听到过这种胡言乱语。\r\n"});
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }

}