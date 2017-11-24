package aac.g148argentina.adapters;

import aac.g148argentina.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by apredazzi on 11/20/17.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    // Keep all Images in array
    public Integer[] mButtons = {
        R.drawable.ico_g148, R.drawable.ico_5mom,
        R.drawable.ico_desafios, R.drawable.ico_musica,
        R.drawable.ico_reavivados, R.drawable.ico_chat,
        R.drawable.ico_redes, R.drawable.ico_5momentos,
        R.drawable.ico_gestion
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mButtons.length;
    }

    @Override
    public Object getItem(int position) {
        return mButtons[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mButtons[position]);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return imageView;
    }
}
