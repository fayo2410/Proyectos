package com.example.jrafaelmzg.newdatabases;

/**
 * Created by JRafaelMzG on 25/03/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_EMAIL = "email";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 2;
    static final String DATABASE_CREATE = "create table " + DATABASE_TABLE + "("
            + KEY_ROWID + " integer primary key autoincrement, " + KEY_NAME
            + " text not null, " + KEY_EMAIL + " text not null);";
    final Context context;
    DataBaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DataBaseHelper(context);
    }

    private static class DataBaseHelper extends SQLiteOpenHelper {
        DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        DBHelper.close();
    }

    public long insertContact(String name, String email) {
        ContentValues initialvalues = new ContentValues();
        initialvalues.put(KEY_NAME, name);
        initialvalues.put(KEY_EMAIL, email);
        return db.insert(DATABASE_TABLE, null, initialvalues);
    }

    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null)>0;
    }

    public Cursor getAllContacts()
    {
        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID,KEY_NAME,KEY_EMAIL}, null, null,null, null,null);
    }
    public Cursor getContact(long rowId) throws SQLException
    {
        Cursor mCursor=
                db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID,KEY_NAME,KEY_EMAIL},KEY_ROWID+"=" + rowId, null,null,null,null,null);
        if(mCursor!=null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateContact(long rowId,String name,String email)
    {
        ContentValues args= new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_EMAIL, email);
        return db.update(DATABASE_NAME, args,KEY_ROWID+"=" + rowId, null)>0;
    }

}
