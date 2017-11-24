package aac.g148argentina.activities;

import aac.g148argentina.DeveloperKey;
import aac.g148argentina.R;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContentActivity extends AppCompatActivity {

    private static final int G148 = 0;
    private static final int MOMENTOS = 1;
    private static final int DESAFIOS = 2;
    private static final int MUSICA = 3;
    private static final int REAVIVADOS = 4;
    private static final int CHAT = 5;
    private static final int REDES = 6;
    private static final int ARTICULOS = 7;
    private static final int GESTION = 8;

    private ImageView banner;
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        banner = findViewById(R.id.banner_content);
        container = findViewById(R.id.frameLayout);

        if (getIntent().hasExtra("id")) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final int id = getIntent().getIntExtra("id", 0);
            switch (id) {
                case G148:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_g148));
                    inflater.inflate(R.layout.layout_g148, container);
                    TextView text = container.findViewById(R.id.textview_layout);
                    text.setText(Html.fromHtml(getString(R.string.g148_text)));
                    break;
                case MOMENTOS:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_5mom));
                    inflater.inflate(R.layout.layout_momentos, container);
                    MomentsAdapter adapter = new MomentsAdapter();
                    ViewPager pager = container.findViewById(R.id.viewpager);
                    pager.setAdapter(adapter);
                    pager.setOffscreenPageLimit(6);
                    break;
                case DESAFIOS:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_desafios));
                    break;
                case MUSICA:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_musica));
                    break;
                case REAVIVADOS:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_reavivados));
                    inflater.inflate(R.layout.layout_reavivados, container);
                    YouTubePlayerView youTubeView = findViewById(R.id.youtube_view);
                    youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(final YouTubePlayer.Provider provider,
                            final YouTubePlayer youTubePlayer, final boolean b) {
                            if (!b) {
                                youTubePlayer.cueVideo("dRQAmKoWH7E");
                            }
                        }

                        @Override
                        public void onInitializationFailure(final YouTubePlayer.Provider provider,
                            final YouTubeInitializationResult youTubeInitializationResult) {

                        }
                    });
                    break;
                case CHAT:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_chat));
                    break;
                case REDES:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_redes));
                    inflater.inflate(R.layout.layout_redes, container);
                    TextView instagram = container.findViewById(R.id.instagram_tv);
                    instagram.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView facebook = container.findViewById(R.id.facebook_tv);
                    facebook.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView youtube = container.findViewById(R.id.youtube_tv);
                    youtube.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView twitter = container.findViewById(R.id.twitter_tv);
                    twitter.setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case ARTICULOS:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_g148));
                    break;
                case GESTION:
//                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_gestion));
                    banner.setVisibility(View.GONE);
                    inflater.inflate(R.layout.layout_gestion, container);
                    WebView webView = container.findViewById(R.id.webview);
                    webView.loadUrl("https://sad-us-fm-1.sgc.live.apps.sdasystems.org/ymms/login.php?lang=esp");
                    break;
                default:
                    banner.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ban_g148));
                    break;
            }
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("reavidados");

        leerLink(myRef);

        setTitle("");
    }

    private void leerLink(DatabaseReference myRef) {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("VALUE", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("VALUE", "Failed to read value.", error.toException());
            }
        });
    }

    public class MomentsAdapter extends PagerAdapter {

        public Object instantiateItem(ViewGroup collection, int position) {

            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.id.page_one;
                    break;
                case 1:
                    resId = R.id.page_two;
                    break;
                case 2:
                    resId = R.id.page_three;
                    break;
                case 3:
                    resId = R.id.page_four;
                    break;
                case 4:
                    resId = R.id.page_five;
                    break;
                case 5:
                    resId = R.id.page_six;
                    break;

            }
            return findViewById(resId);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(final View view, final Object object) {
            return view == ((View) object);
        }
    }

}
