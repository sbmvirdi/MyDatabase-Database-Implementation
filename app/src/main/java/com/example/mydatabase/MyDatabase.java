package com.example.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {

    private static final String TABLENAME = "USERS";
    private static final String COLUMN_NAME = "NAME";
    private static final String DBNAME = "MYDB";
    private static int DB_VERSION = 1;
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_MOBILE = "MOBILE";
    private static final String QUERY = "CREATE TABLE "+ TABLENAME +"("+COLUMN_NAME+" TEXT,"+COLUMN_EMAIL+" TEXT,"+COLUMN_MOBILE+" INTEGER)";
    private Context context;


    public MyDatabase(Context context) {
        super(context, DBNAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
    }
    private void insertdata(String name,int mob,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",name);
        cv.put("EMAIL",email);
        cv.put("MOBILE",mob);

        db.insert(TABLENAME,null,cv);
        Toast.makeText(context, "Insert Complete", Toast.LENGTH_SHORT).show();



    }

    public ArrayList<String> showValues(){
        Toast.makeText(context, "inside show", Toast.LENGTH_SHORT).show();
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String s = "select * from "+TABLENAME;
        Cursor c = db.rawQuery(s,null);
        while (c.moveToNext()){
           String name = c.getString(0);
           long mob = c.getLong(2);
           String email = c.getString(1);
           String s1 = name +","+email+","+mob;
           list.add(s1);
        }

        return list;


    }


    public void doDelete(String s){
        SQLiteDatabase db = this.getReadableDatabase();
        String where = "name = ?";
        String[] ss = {s};
        db.delete(TABLENAME,where,ss);
        Toast.makeText(context, "Delete Complete", Toast.LENGTH_SHORT).show();
    }

}
