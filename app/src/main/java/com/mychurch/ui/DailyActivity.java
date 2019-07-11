package com.mychurch.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import com.mychurch.R;
import com.mychurch.adapater.ChurchListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mychurch.models.Church;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import com.mychurch.services.ChurchService;


public class DailyActivity extends AppCompatActivity {
    public static final String TAG = DailyActivity.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

private ChurchListAdapter mAdapter;

    private ArrayList<Church> churches=new ArrayList<>();
;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church);

        ButterKnife.bind(this);
        


        Intent intent = getIntent();
        String readings = intent.getStringExtra("readings");

        getChurch("","", "","");
    }

    private void getChurch(String holyBook, String bookChapter, String bookVerseFrom, String bookVerseTo) {
        final ChurchService churchService = new ChurchService();
        churchService.findChurch(holyBook, bookChapter, bookVerseFrom, bookVerseTo, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) {
                churches = churchService.processResults(response);
                DailyActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ChurchListAdapter(getApplicationContext(), churches);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DailyActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });


            }
        });
    }

}