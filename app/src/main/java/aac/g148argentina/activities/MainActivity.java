package aac.g148argentina.activities;

import aac.g148argentina.R;
import aac.g148argentina.adapters.ImageAdapter;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.thefinestartist.finestwebview.FinestWebView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        gridView = findViewById(R.id.gridview_buttons);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int i, final long l) {
                if (i == 5) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://chat.whatsapp.com/JOaAd8THaoa6mmXriXxNGH"));
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(MainActivity.this, YoutubeActivity.class);
                    startActivity(intent);
                } else if (i == 8) {
                    new FinestWebView.Builder(MainActivity.this).titleDefault("Sistema de Gestión JA")
                        .titleColorRes(R.color.white).toolbarColorRes(R.color.black).iconDefaultColorRes(R.color.white)
                        .webViewBuiltInZoomControls(true).webViewDisplayZoomControls(true).statusBarColorRes(R.color.black)
                        .show("https://sad-us-fm-1.sgc.live.apps.sdasystems.org/ymms/login.php?lang=esp");
                } else {
                    Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                    intent.putExtra("id", i);
                    startActivity(intent);
                }
            }
        });
    }
}
