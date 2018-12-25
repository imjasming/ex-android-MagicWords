package database.MagicwordDbSchema;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MagicreadBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION=1;
    private static final String DATEBASE_NAME="Magicworddb3";
    public MagicreadBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATEBASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Magicreaddb(" +
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
                "INSERT INTO Magicreaddb(id,sentence,word) values(?,?,?)",new Object[] { 446,
                        "In the past, it was unimaginable for most Chinese people to travel by air. Nowadays, with the economic development and the improvement of living standard, an increasing number of Chinese including many farmers and migrant workers can take plane to travel. They can fly to all big cities. Besides, many cities are preparing to build airports. The air service is constantly improved and the special air-tickets are often offered. In recent years, the number of people choosing to travel by air has constantly increased during holidays.",
                        "过去，乘飞机出行对大多数中国人来说是难以想象的。如今随着经济的发展和生活水平的提高，越来越多的中国人包括许多农民和外出务工人员都能乘飞机出行。他们可以乘飞机到达所有大城市，还有许多城市也在筹建机场。航空服务不断改进，而且经常会有特价机票。近年来，节假日期间选择乘飞机外出旅游的人不断增加。"});

        db.execSQL(
                "INSERT INTO Magicreaddb(id,sentence,word) values(?,?,?)",new Object[] { 448,
                        "In recent years, more and more cities in China begin to build subways. Developing the subway is good for reducing the traffic jam and air pollution in cities. A growing number of people choose subway as their main means of transportation to go to work or school every day for its advantages of safety, fast speed and comfort. Nowadays, taking the subway is becoming more and more convenient in China. In some cities, passengers can use a card or a mobile phone to take the subway. Many elderly local citizens can also take the subway for free.",
                        "近年来，中国有越来越多的城市开始建造地铁。发展地铁有助于减少城市的交通拥挤和空气污染。地铁具有安全、快捷和舒适的优点，越来越多的人选择地铁作为每天上班或上学的主要交通工具。如今，在中国乘坐地铁正变得越来越方便。在有些城市里，乘客只需用卡或手机就可以乘坐地铁。许多当地老年市民还可以免费乘坐地铁。"});
        db.execSQL(
                "INSERT INTO Magicreaddb(id,sentence,word) values(?,?,?)",new Object[] { 460,
                        "Due to the rapid development of communication networks， the number of Chinese smartphone users has grown at an alarming rate in recent years。 This has dramatically changed the ways of reading for many people.They now often read news and articles on their smartphones instead of buying traditional newspapers。 The development of a large number of mobile apps enables people to read novels and other forms of literature works on their mobile phones。 Therefore， the sale of paper books has been affected。 But the survey shows that despite the steady growth of the mobile phone reading market， more than half of adults still like to read paper books。",
                        "由于通信网络的快速发展，中国智能手机用户数量近年来以惊人度增长。这极大地改变了许多人的阅读方式。他们现在经常智能手机上看新闻和文章，而不买传统报刊。大量移动应用程序的开发使人们能用手机读小说和其他形式的文学作品。因此，纸质书籍的销售受到了影响。但调查显示，尽管能手机阅读市场稳步增长，超半数成年人仍喜欢读纸质书。"});




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }
}
