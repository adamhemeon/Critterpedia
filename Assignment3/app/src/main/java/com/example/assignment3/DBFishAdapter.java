package com.example.assignment3;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.util.Log;

public class DBFishAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_CATCH_PHRASE = "catch_phrase";
    public static final String KEY_ICON = "icon";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_PRICE = "price";
    public static final String KEY_SHADOW_SIZE = "shadow_size";
    public static final String KEY_LOCATION = "location";
    public static final String TAG = "DBAdapter";
    public static final String DATABASE_NAME = "critterpedia";
    public static final String DATABASE_TABLE = "fish";
    public static final int DATABASE_VERSION = 3;

    private static final String DATABASE_CREATE =
            "CREATE TABLE fish(" +
                    "_id integer primary key autoincrement," +
                    "name text NOT NULL," +
                    "catch_phrase text NOT NULL," +
                    "icon integer NOT NULL," +
                    "image integer NOT NULL," +
                    "price integer NOT NULL," +
                    "location text NOT NULL," +
                    "shadow_size integer NOT NULL);";

    private Context context = null;
    private DatabaseHelper DBFishHelper;
    private SQLiteDatabase db;

    public DBFishAdapter(Context context){
        this.context = context;
        DBFishHelper = new DatabaseHelper(context);
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {

            try{
                db.execSQL(DATABASE_CREATE);
            } catch(SQLException e){
                e.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }

        } // end OnCreate

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w(TAG,"Upgrade database from version " + oldVersion + " to " + newVersion + " which will destroy all old data.");
            db.execSQL("DROP TABLE IF EXISTS fish");
            onCreate(db);

        } // end OnUpgrade

    } // end DatabaseHelper


    // Open database
    public DBFishAdapter open() throws SQLException {

        db = DBFishHelper.getWritableDatabase();
        return this;

    }

    // Close database
    public void close()
    {
        DBFishHelper.close();
    }

    // insert a single fish into the database
    public long insertFish(String name, String catchPhrase, int icon, int image, int price,
                           String location, int shadowSize){

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME,name);
        initialValues.put(KEY_CATCH_PHRASE,catchPhrase);
        initialValues.put(KEY_ICON,icon);
        initialValues.put(KEY_IMAGE,image);
        initialValues.put(KEY_PRICE,price);
        initialValues.put(KEY_LOCATION,location);
        initialValues.put(KEY_SHADOW_SIZE,shadowSize);

        return db.insert(DATABASE_TABLE,null,initialValues);

    }

    // delete a single fish from the database
    public boolean deleteFish(long rowId){

        return db.delete(DATABASE_TABLE,KEY_ROWID+"="+rowId,null) > 0;

    }

    // retrieve all fish
    public Cursor getFish(long rowId) throws SQLException {

        Cursor mCursor = db.query(true,DATABASE_TABLE,
                new String[]{KEY_ROWID,KEY_NAME},
                KEY_ROWID+"="+rowId,
                null,null,null,null,
                null, null);

        if(mCursor!=null){
            mCursor.moveToFirst();
        }

        return mCursor;
    } // end getFish

    public Cursor getAllFish() {

        return db.query(DATABASE_TABLE,new String[]{KEY_ROWID,KEY_NAME},
                null,null,null,null,null);
    }

    // update a single fish
    public boolean updateFish(long rowId, String name, String catchPhrase, int icon,
                                 int image, int price, String location, int shadowSize){

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_CATCH_PHRASE,catchPhrase);
        values.put(KEY_ICON,icon);
        values.put(KEY_IMAGE,image);
        values.put(KEY_PRICE,price);
        values.put(KEY_LOCATION,location);
        values.put(KEY_SHADOW_SIZE,shadowSize);

        return db.update(DATABASE_TABLE,values,KEY_ROWID+"="+rowId,null) > 0;

    }// end updateFish

} //end DBAdapter class
