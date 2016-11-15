package com.example.tubaabbasi.db_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tubaabbasi on 11/11/16.
 */
public class AccountsDBHelper extends SQLiteOpenHelper {

    public static final String ACCOUNTS_DATABASE = "AccountsDB.db";
    public static final String ACCOUNTS_TABLE_NAME = "accounts";
    public static final String ACCOUNTS_COLUMN_ID = "id";
    public static final String ACCOUNTS_COLUMN_NAME = "accountName";
    public static final String ACCOUNTS_COLUMN_USERNAME = "username";
    public static final String ACCOUNTS_COLUMN_PASSWORD = "password";
    private HashMap hp;

    public AccountsDBHelper(Context context)
    {
        super(context, ACCOUNTS_DATABASE , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table accounts " +
                        "(id integer primary key, accountName text,username text,password text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertAccount  (String accountName, String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("accountName", accountName);
        contentValues.put("username", username);
        contentValues.put("password", password);
        db.insert("accounts", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from accounts where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, ACCOUNTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateAccount (Integer id, String accountName, String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("accountName", accountName);
        contentValues.put("username", username);
        contentValues.put("password", password);
        db.update("accounts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteAccount (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("accounts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllAccounts()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from accounts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(ACCOUNTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}

