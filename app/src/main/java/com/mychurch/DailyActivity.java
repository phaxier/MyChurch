package com.mychurch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;

public class DailyActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] restaurants = new String[] {"Our daily reading today Comes from the Book of Mark"};
    private String[] cuisines = new String[]{"Add Your prayers"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

    }
}
