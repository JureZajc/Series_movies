package si.fri.emp.series_movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toolbar;

/**
 * Created by JURE on 06.01.2018.
 */

public class SeriesList extends AppCompactActivity{
    public static final String ROW_ID = "row_id";
    private ListView seriesListView;
    private CursorAdapter seriesAdapter;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seriesListView = (ListView) findViewById(R.id.listView);
        seriesListView.setOnItemClickListener(viewContactListener);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent addNewSerie = new Intent(SeriesList.this, AddEditSerie.class);
                startActivity(addNewSerie);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] from  = new String[]{"name", "current_episode"};
        int[] to = new int[]{R.id}
    }
}
