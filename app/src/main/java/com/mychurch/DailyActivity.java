package com.mychurch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class DailyActivity extends AppCompatActivity {
    public static final String TAG = DailyActivity.class.getSimpleName();
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;
    private String[] dailies = new String[]{"Genesis", "Exodus", "Numbers", "Deuteronomy", "Daniel"};
    private String[] prayer = new String[]{"", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        ButterKnife.bind(this);
        

        ChurchArrayAdapter adapter = new ChurchArrayAdapter(this, android.R.layout.simple_list_item_1, dailies, prayer);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String dailies = ((TextView) view).getText().toString();
                Toast.makeText(DailyActivity.this, dailies, Toast.LENGTH_SHORT).show();
                Log.v("DailyActivity", "In the onItemClickListener");
            }
        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the churches near: " + location);
    }

    private void getDailies(String holyBook, String bookChapter, String bookVerseFrom, String bookVerseTo) {
        final ChurchService churchService = new ChurchService();
        churchService.findDailies(holyBook, bookChapter, bookVerseFrom, bookVerseTo, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mDailies =
                try {
                    String jsonData = response.body().string();

                    if (response.isSuccessful()) {
                        Log.v(TAG, jsonData);
                        mChurch = churchService.processResults(response);
                    }

                    }catch(IOException e){
                        e.printStackTrace();

                }
            }
        });

    }
}