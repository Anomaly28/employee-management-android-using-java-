package com.example.project14crudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, "ems10jan25", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table emp(eid int primary key, ename text, esalary real)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addEmployee(int eid, String ename, double esalary)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eid",eid);
        contentValues.put("ename",ename);
        contentValues.put("esalary",esalary);
        long res = sqLiteDatabase.insert("emp",null,contentValues);
        return res;
    }

    public String viewEmployee() {
        String data = "";
        String sql = "select * from emp";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                int eid = cursor.getInt(0);
                String ename = cursor.getString(1);
                double esalary = cursor.getDouble(2);
                data = data + "eid " + eid + "\nename " + ename + "\nesalary" + esalary + "\n**************\n";
            }
            while (cursor.moveToNext());
        }
        return data;
    }

    public long deleteEmployee(int eid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long res = sqLiteDatabase.delete("emp","eid=?",new String[]{String.valueOf(eid)});
        return res;
    }
}
