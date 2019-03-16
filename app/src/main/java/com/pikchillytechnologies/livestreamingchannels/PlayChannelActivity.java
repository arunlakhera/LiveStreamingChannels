package com.pikchillytechnologies.livestreamingchannels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayChannelActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private Button mButtonBack;
    private Button mButtonMenu;

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    YouTubePlayer mplayer;

    private Bundle mChannelBundle;
    private String mChannelId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_channel);

        mButtonBack = findViewById(R.id.button_Back);
        mButtonMenu = findViewById(R.id.button_Menu);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        mButtonBack = findViewById(R.id.button_Back);

        mChannelBundle =  getIntent().getExtras();
        mChannelId = mChannelBundle.getString("channelid");

        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent destinationChannel = new Intent(getApplicationContext(), AllChannelsActivity.class);
                startActivity(destinationChannel);
            }
        });

        mButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

        if (!wasRestored) {

            //player.cueVideo(mChannelId);
            player.loadVideo(mChannelId);
            player.play();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {

        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

}
