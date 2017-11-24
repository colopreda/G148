package aac.g148argentina.activities;

/**
 * Created by apredazzi on 11/20/17.
 */

import aac.g148argentina.DeveloperKey;
import aac.g148argentina.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;

/**
 * A simple YouTube Android API demo application which shows how to create a simple application that
 * displays a YouTube Video in a {@link YouTubePlayerView}.
 * <p>
 * Note, to use a {@link YouTubePlayerView}, your activity must extend {@link YouTubeBaseActivity}.
 */
public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_reavivados);

        YouTubePlayerView youTubeView = findViewById(R.id.youtube_view);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo("dRQAmKoWH7E");
        }
    }

    @Override
    public void onInitializationFailure(final YouTubePlayer.Provider provider,
        final YouTubeInitializationResult youTubeInitializationResult) {

    }

}

