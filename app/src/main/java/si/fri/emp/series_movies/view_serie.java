package si.fri.emp.series_movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class view_serie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_serie);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        ratingTextView = (TextView) findViewById(R.id.ratingTextView);
        urlTextView = (TextView) findViewById(R.id.urlTextView);
        all_episodesTextView = (TextView) findViewById(R.id.all_episodesTextView);
        current_episodeTextView = (TextView) findViewById(R.id.current_episodeTextView);

        final Bundle extras = getIntent().getExtras();
        rowId = extras.getLong(SeriesList.ROW_ID);
    }
}
