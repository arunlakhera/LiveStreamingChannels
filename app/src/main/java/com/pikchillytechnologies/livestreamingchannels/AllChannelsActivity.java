package com.pikchillytechnologies.livestreamingchannels;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AllChannelsActivity extends AppCompatActivity {

    private TextView mTextView_AajTak;
    private TextView mTextView_IndiaTv;
    private TextView mTextView_ABP;
    private TextView mTextView_IndiaToday;

    private List<ChannelModel> mChannelModelList;
    private RecyclerView mRecyclerViewChannel;
    private ChannelAdadpter mChannelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_channels);

        mChannelModelList = new ArrayList<>();
        mRecyclerViewChannel = findViewById(R.id.recyclerview_Channel);

        mChannelAdapter = new ChannelAdadpter(getApplicationContext(),mChannelModelList);
        mRecyclerViewChannel.setHasFixedSize(true);

        RecyclerView.LayoutManager m_Layout_Manager = new LinearLayoutManager(getApplicationContext());
        mRecyclerViewChannel.setLayoutManager(m_Layout_Manager);

        mRecyclerViewChannel.setItemAnimator(new DefaultItemAnimator());
        mRecyclerViewChannel.setAdapter(mChannelAdapter);

        prepareData();

        mRecyclerViewChannel.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerViewChannel, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                ChannelModel c = mChannelModelList.get(position);
                startChannelActivity(c.getmChannelId());

            }

            @Override
            public void onLongClick(View view, int position) {
                // Nothing
                Log.d("LongClick","Long Click");
            }
        }));

    }

    public void startChannelActivity(String channelId){

        Intent destinationChannel = new Intent(getApplicationContext(), PlayChannelActivity.class);
        destinationChannel.putExtra("channelid",channelId);
        startActivity(destinationChannel);

    }

    public void prepareData(){

        ChannelModel channel1 = new ChannelModel("AAj Tak","smZRzehsXHA",R.drawable.aajtak);
        ChannelModel channel2 = new ChannelModel("India TV","A3vC1XWOBx8",R.drawable.indiatv);
        ChannelModel channel3 = new ChannelModel("ABP","qup_LamVTa8",R.drawable.abp);
        ChannelModel channel4 = new ChannelModel("India Today","WmutmzNRIx8",R.drawable.indiatoday);
        ChannelModel channel5 = new ChannelModel("News 18","MO_qmUjbnwE",R.drawable.news18);

        mChannelModelList.add(channel1);
        mChannelModelList.add(channel2);
        mChannelModelList.add(channel3);
        mChannelModelList.add(channel4);
        mChannelModelList.add(channel5);

        mChannelAdapter.notifyDataSetChanged();

    }
}
