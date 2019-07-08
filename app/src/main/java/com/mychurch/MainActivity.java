package com.mychurch;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findChurchbutton) Button mFindChurchButton;
    @BindView(R.id.locationEditText)EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



//        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
//        mAppNameTextView.setTypeface(ostrichFont);


        mFindChurchButton.setOnClickListener(this);

        }

            @Override
            public void onClick(View v) {
                if (v == mFindChurchButton) {
                    String location = mLocationEditText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, DailyActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);

                }
            }

        }


