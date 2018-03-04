package Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 02-03-2018.
 */

public class DataBase extends SQLiteOpenHelper {

    public static final int DB_VER = 1;
    public static final String DB_NAME= "SIGNUP.db";
    public static final String TABLE_NAME = "USER";

    public static final String KEY_ID = "ID";
    public static final String COLM_1= "USERNAME ";
    public static final String COLM_2 = "password";
    public static final String COLM_3= "EMAIL";



    public DataBase(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLM_1+" TEXT,"+COLM_2+" TEXT,"+COLM_3+" TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);

    }
}

