package si.fri.emp.series_movies;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by JURE on 06.01.2018.
 */

public class ViewSerie extends AppCompatActivity {
    private long rowId;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView ratingTextView;
    private TextView urlTextView;
    private TextView all_episodesTextView;
    private TextView current_episodeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewSerie);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        ratingTextView = (TextView) findViewById(R.id.ratingTextView);
        urlTextView = (TextView) findViewById(R.id.urlTextView);
        all_episodesTextView = (TextView) findViewById(R.id.all_episodesTextView);
        current_episodeTextView = (TextView) findViewById(R.id.current_episodeTextView);

        final Bundle extras = getIntent().getExtras();
        rowId = extras.getLong(SeriesList.ROW_ID);
    }

    protected void onResume(){
        super.onResume();
        DatabaseConnector databaseConnector = new DatabaseConnector(getApplicationContext());
        databaseConnector.open();
        Cursor result = databaseConnector.getOneSerie(rowId);
        result.moveToFirst();
        int nameIndex = result.getColumnIndex("name");
        int descriptionIndex = result.getColumnIndex("descripton");
        int ratingIndex = result.getColumnIndex("rating");
        int urlIndex = result.getColumnIndex("url");
        int allEpisodesIndex = result.getColumnIndex("all_episodes")
        int currentEpisodeIndex = result.getColumnIndex("current_episode");

        nameTextView.setText(result.getString(nameIndex));
        descriptionTextView.setText(result.getString(descriptionIndex));
        ratingTextView.setText(result.getInt(ratingIndex));
        urlTextView.setText(result.getString(urlIndex));
        all_episodesTextView.setText(result.getInt(allEpisodesIndex));
        current_episodeTextView.setText(result.getInt(currentEpisodeIndex));

        result.close();
        databaseConnector.close();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_serie_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.editItem:
               return true;
            case R.id.deleteItem:
                deleteSerie();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deleteSerie(){
        DatabaseConnector databaseConnector = new DatabaseConnector(getApplicationContext());
        databaseConnector.deleteSerie(rowId);
        databaseConnector.close();
        finish();
    }


}
