package com.example.task_71p;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataManager extends SQLiteOpenHelper {

//    table data and setup
    private static final String DATABASE_NAME = "lostfound.db";
    private static final String TABLE_NAME = "lostfound";
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_LOCATION = "location";


//    constructor
    public DataManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

//    when table is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_DATE + " TEXT, " + COLUMN_LOCATION + " TEXT)";
        db.execSQL(createTable);
    }

//    when table is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    get all items
    public Cursor getAllItems() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(query, null);
    }

//    add new LostFoundItem to db
    public void addLostFoundItem(LostFoundItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_DESCRIPTION + ", " + COLUMN_DATE + ", " + COLUMN_LOCATION + ") VALUES ('" + item.getName() + "', '" + item.getPhone() + "', '" + item.getDescription() + "', '" + item.getDate() + "', '" + item.getLocation() + "')";
        db.execSQL(query);
    }

//    remove LostFoundItem from db
    public void removeLostFoundItem(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = '" + name + "'";
        db.execSQL(query);
    }





}
