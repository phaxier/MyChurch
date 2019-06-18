package com.mychurch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] readings = new String[] {"Our daily reading today Comes from the Book of Mark"};
    private String[] prayers = new String[]{"Add Your prayers"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        MyChurchArrayAdapter adapter = new MyChurchArrayAdapter(this, android.R.layout.simple_list_item_1, readings, prayers);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener((adapterView, view, i, l) -> {
            String readings = ((TextView)view).getText().toString();
            Toast.makeText(DailyActivity.this, readings, Toast.LENGTH_LONG).show();
        });
        mLocationTextView.setText("Here are the daily readings: " + location);
    }
}
