package si.fri.emp.series_movies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JURE on 06.01.2018.
 */

public class DatabaseConnector extends SQLiteOpenHelper {
    private static final String DATASBASE_NAME = "Series_movies";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase database;

    public DatabaseConnector(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE Series ("
                + "_id integer primary key autoincrement,"
                + "name TEXT, description TEXT, rating INT, url TEXT, all_episodes INT, current_episode INT);";
        String createQuery2 = "CREATE TABLE Movies ("
                + "_id integer primary key autoincrement,"
                + "name TEXT, description TEXT, rating INT, url TEXT, watched BOOL);";
        db.execSQL(createQuery);
        db.execSQL(createQuery2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void open() throws SQLException{
        database = this.getWritableDatabase();
    }

    public void close(){
        if(database != null){
            database.close();
        }
    }

    public void insertSeries(String name, String description, Integer rating, String url, Integer
            all_episodes, Integer current_episode){
        ContentValues newSerie = new ContentValues();
        newSerie.put("name", name);
        newSerie.put("descripton", description);
        newSerie.put("rating", rating);
        newSerie.put("url", url);
        newSerie.put("all_episodes", all_episodes);
        newSerie.put("current_episode", current_episode);
        open();
        database.insert("Series", null, newSerie);
        close();
    }

    public void insertMovies(String name, String description, Integer rating, String url, Boolean watched){
        ContentValues newMovie = new ContentValues();
        newMovie.put("name", name);
        newMovie.put("descripton", description);
        newMovie.put("rating", rating);
        newMovie.put("url", url);
        newMovie.put("watched", watched);
        open();
        database.insert("Movies", null, newMovie);
        close();
    }

    public void updateSerie(long id, String name, String description, Integer rating, String url, Integer
            all_episodes, Integer current_episode){
        ContentValues editSerie = new ContentValues();
        ContentValues.put("name", name);
        ContentValues.put("descripton", description);
        ContentValues.put("rating", rating);
        ContentValues.put("url", url);
        ContentValues.put("all_episodes", all_episodes);
        ContentValues.put("current_episode", current_episode);
        open();
        database.update("Series", editSerie,"_id", null);
        close();
    }

    public void updateMovie(long id, String name, String description, Integer rating, String url, Boolean watched){
        ContentValues editMovie = new ContentValues();
        ContentValues.put("name", name);
        ContentValues.put("descripton", description);
        ContentValues.put("rating", rating);
        ContentValues.put("url", url);
        ContentValues.put("watched", watched);
        open();
        database.update("Movies", editMovie,"_id", null);
        close();
    }

    public Cursor getAllSeries(){
        return database.query("Series", new String[]{"_id", "name", "current_episode"}, null, null, null, null,
                "name");
    }

    public Cursor getAllMovies(){
        return database.query("Movies", new String[]{"_id", "name", "rating"}, null, null, null, null,
                "name");
    }

    public Cursor getOneSerie(){
        return database.query("Series", null, "_id=" + id, null, null, null, null);
    }

    public Cursor getOneMovie(){
        return database.query("Movies", null, "_id=" + id, null, null, null, null);
    }

    public void deleteSerie{
        open();
        database.delete("Series", "_id", null);
        close();
    }

    public void deleteMovie{
        open();
        database.delete("Movies", "_id", null);
        close();
    }



}
