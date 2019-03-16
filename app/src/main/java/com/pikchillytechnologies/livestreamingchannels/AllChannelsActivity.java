package com.pikchillytechnologies.livestreamingchannels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AllChannelsActivity extends AppCompatActivity {

    private TextView mTextView_AajTak;
    private TextView mTextView_IndiaTv;
    private TextView mTextView_ABP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_channels);

        mTextView_AajTak = findViewById(R.id.textview_AajTak);
        mTextView_IndiaTv = findViewById(R.id.textview_IndiaTv);
        mTextView_ABP = findViewById(R.id.textview_ABP);

        mTextView_AajTak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent destinationChannel = new Intent(getApplicationContext(), PlayChannelActivity.class);
                destinationChannel.putExtra("channelid","smZRzehsXHA");
                startActivity(destinationChannel);
            }
        });

        mTextView_IndiaTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent destinationChannel = new Intent(getApplicationContext(), PlayChannelActivity.class);
                destinationChannel.putExtra("channelid","A3vC1XWOBx8");
                startActivity(destinationChannel);
            }
        });

        mTextView_ABP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent destinationChannel = new Intent(getApplicationContext(), PlayChannelActivity.class);
                destinationChannel.putExtra("channelid","qup_LamVTa8");
                startActivity(destinationChannel);
            }
        });




    }
}
