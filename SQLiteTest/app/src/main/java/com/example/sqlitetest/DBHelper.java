package com.example.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "MYDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors("+
                "id integer primary key,"+
                "name text,"+
                "address text,"+
                "email text);");
        sqLiteDatabase.execSQL("CREATE TABLE Books("+
                "id integer primary key,"+
                "title text,"+
                "id_author integer not null constraint id_author references Authors(id) ON DELETE CASCADE ON UPDATE CASCADE );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    public int InsertAuthor(Author author){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",author.getId());
        contentValues.put("name",author.getName());
        contentValues.put("address",author.getAddress());
        contentValues.put("email",author.getEmial());
        int result = (int) database.insert("Authors",null,contentValues);
        database.close();
        return result;
    }


    public int InsertBook(Book book){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",book.getId());
        contentValues.put("title",book.getTitle());
        contentValues.put("id_author",book.getId_author());
        int result = (int) database.insert("Books",null,contentValues);
        database.close();
        return result;
    }

    public Author getAuthor(int theAuthorId){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Authors where id ="+
                theAuthorId,null);
        if (cursor != null)
            cursor.moveToFirst();
        Author author = new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        database.close();
        return author;
    }

    public ArrayList<Book> getBook(int theBookId){
        ArrayList<Book> books = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Books where id ="+
                theBookId,null);
        if (cursor != null)
            cursor.moveToFirst();
        Book book = new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
        books.add(book);
        database.close();
        return books;
    }

    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Authors",null);
        if (cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast()){
            list.add(new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return  list;
    }

    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Books",null);
        if (cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast()){
            list.add(new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return  list;
    }
    public ArrayList<Book> getAllBook_TG(){
        ArrayList<Book> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Books",null);
        if (cursor!=null)
            cursor.moveToFirst();
        while (cursor.isAfterLast()){
            list.add(new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return  list;
    }

    //XOA
    public Boolean deleteAuthor(int theAuthorId){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("delete from Authors where id ="+
                theAuthorId,null);
        if (cursor == null){
            return true;}
        return false;
    }

    //UPDATE
    public Boolean updateAuthor(Author theAuthor,int theAuthorId){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("update Authors set id ="+
                theAuthor.getId()+",name="+theAuthor.getName()+",address="+theAuthor.getAddress()+
                ",emial"+theAuthor.getEmial()+"where"+theAuthorId,null);
        if (cursor != null)
            return true;
        return false;
    }
}
