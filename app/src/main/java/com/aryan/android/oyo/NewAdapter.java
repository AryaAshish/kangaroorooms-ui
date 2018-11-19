package com.aryan.android.oyo;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin1 on 3/3/18.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ItemViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    String[] items;
    int[] city_imgs;
    Resources r;

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView itemName;
        public final ImageView city_img;
        //public final ImageView wordImageView;
        final NewAdapter mAdapter;
        public ItemViewHolder(View itemView, NewAdapter adapter) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.city_name);
            city_img = (ImageView) itemView.findViewById(R.id.city_img);
            mAdapter = adapter;
        }
    }

    public NewAdapter(Context context, String[] items, int[] city_imgs, Resources r) {
        this.context = context;
        this.items = items;
        this.city_imgs = city_imgs;
        this.r = r;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.img_recycler_view, parent, false);
        return new ItemViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String mCurrent = items[position];
        int mCurrentImg = city_imgs[position];
        holder.itemName.setText(mCurrent);
        holder.city_img.setImageResource(mCurrentImg);

    }

    @Override
    public int getItemCount() {
        return items.length;
    }


}
