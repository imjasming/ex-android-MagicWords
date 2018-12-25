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
                "title VARCHAR(255),"+
                "sentence VARCHAR(4196)," +
                "word VARCHAR(4196))");

       /* //db.execSQL("CREATE TABLE Magicworddb(" +
                "wordid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "word VARCHAR(20)," +
                "yinbiao VARCHAR(255)," +
                "mean VARCHAR(255)," +
                "example VARCHAR(255))");*/
        db.execSQL(
                "INSERT INTO Magicreaddb(id,title,sentence,word) values(?,?,?,?)",new Object[] { 446,"For the Love of Chocolate",
                        "  Most people know that chocolate is made from cocoa and that the origins of chocolate can be traced back to Central and South America. For centuries, the natives there regarded cocoa as a gift from the gods. But how did chocolate go from being the food of the gods to being the food of love?\n" +
                                "  Around A.D. 600, the Mayas were the main aboriginal group in Central America. They established the first cocoa plantations and used the cocoa bean as the main ingredient in a dark, bitter drink that we would call “chocolate.” The Mayas believed that chocolate had mystical properties---but cocoa also had commercial value. In fact, cocoa beans were used as a form of currency that was worth its weight in gold!\n" +
                                "  Spanish conquistador Hernando Cortez was the first European explorer to realize cocoa's commercial possibilities. When he arrived in the New World in 1519, he soon established his own cocoa plantation. In 1529, Cortez returned to Spain and introduced chocolate---as a drink mixed with sugar, vanilla, and cinnamon---to European society.\n" +
                                "  It caught on---especially with the nobility, who fancied hot chocolate as an aphrodisiac. As its popularity spread, people found new ways to make and use chocolate. These days, chocolate is enjoyed as both a tasty treat and a romantic indulgence. Whether it is in delectable desserts or crunchy candy, people the world over are still in love with chocolate.",
                               "浓情巧克力\n" +
                                       "  大多数人都知道巧克力由可可制成，它起源于中南美洲。几个世纪以来，当地的居民把可可看作神的恩赐。但巧克力是怎样从神的食品变成了爱情食品的呢？\n" +
                                       "  公元600年左右，玛雅人是中美洲主要的土著居民。他们建立了第一座可可种植园，并用可可豆为主要原料，制成了一种又黑又苦的饮料，我们叫“巧克力”。玛雅人相信巧克力具有神秘的特性，也具有商业价值。实际上，可可豆曾经被当作一种与金子等值的货币形式！\n" +
                                       "  西班牙征服者赫尔南多•科蒂斯是第一位了解可可的商业潜力的欧洲探险家。他1519年抵达新大陆，不久就建立了自己的可可种植园。1529年，赫尔南多•科蒂斯回到西班牙，他将巧克力——一种混合糖、香草及肉桂的饮料引入欧洲社会。\n" +
                                       " 巧克力倍受贵族们的亲睐，他们视热巧克力为一种春药。随着巧克力广为普及，人们发现了一些制造和使用巧克力的新方法。现在，巧克力被人们当作一种可口的美食和浪漫的享受。无论是在美味的甜点里，还是在酥脆的糖果中，世界各地的人们依旧对巧克力迷恋不已。"});

        db.execSQL(
                "INSERT INTO Magicreaddb(id,title,sentence,word) values(?,?,?,?)",new Object[] { 448,"Active Play or Passive Entertainment?",
                        "Our diurnal existence is divided into two phases, as distinct as day and night. We call them work and play. We work so many hours a day. And, when we have allowed the necessary minimum for such activities as eating and shopping, the rest we spend in various activities which are known as recreations, an elegant word which disguises the fact that we usually do not even play in our hours of leisure, but spend them in various forms of passive enjoyment or entertainment―not playing football but watching football matches；not acting but theatre-going；Not walking but riding in a motor coach.\n" +
                                "  We need to make, therefore, a hard-and-fast distinction not only between work and play but equally between active play and passive entertainment. It is, I suppose, the decline of active play―of amateur sport―and the enormous growth of purely receptive entertainment which has given rise to a sociological interest in the problem. If the greater part of the population, instead of indulging in sport, spend their hours of leisure viewing television programmers, there will inevitably be a decline in health and physique.\n" +
                                "  We have to live art if we would be affected by art. We have to paint rather than look at paintings, to play instruments rather than go to concerts, to dance and sing and act ourselves, engaging all our senses in the ritual and discipline of the arts. Then something may begin to happen to us：to work upon our bodies and soul.",
                        "主动的玩乐还是被动的消遣?\n" +
                                "  人们的每天的生存状态可以一分为二，像白天和黑夜那样清晰可辨。我们将之称为工作和娱乐。每天，我们在工作上花费许多小时，再把花在诸如吃饭、购物等必不可少、无法再减的活动的时间扣除，我们把花在其他活动的剩余时间归在娱乐范围。娱乐这个词相当雅致。但掩饰了这样一个事实：即使在休闲的时光中，我们通常并没有玩乐，而是在进行各种各样被动的享乐或娱乐中——不是踢足球而只是看足球比赛，不是登台演出而是看人演戏，不是散步行走而是搭乘汽车。\n" +
                                "  因此，我们需要不仅对工作和娱乐做出严格的区别，而且要同样严格地区分主动的玩乐和被动的消遣。在我看来，正是由于主动的玩乐——业余体育运动衰退和纯粹接受性消遣的疯狂膨胀，导致了社会学家对这一问题的关注。假如人口的大多数不是参加体育活动，而是把闲暇时光花在“看”电视节目上，人们的健康和体质都会不可避免地下降。\n" +
                                "  如果我们希望受到艺术的熏陶，我们就应该当艺术的生活。不是去欣赏油画，我们自己应当去作画；不是去听音乐会，我们自己应当去演奏乐器，去跳舞，去唱歌，去演戏，让我们的感官受各个艺术门类的规矩和训练。随后，某种变化就会出现，对我们的身心都会发生影响。"});


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS diary");
        onCreate(db);
    }
}
