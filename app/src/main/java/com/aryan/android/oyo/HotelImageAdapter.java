package com.aryan.android.oyo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by admin1 on 13/3/18.
 */

public class HotelImageAdapter extends RecyclerView.Adapter<HotelImageAdapter.HotelImageViewHolder> {

    private int[] mHotelImages;
    private LayoutInflater mInflater;
    private Context context;

    public class HotelImageViewHolder extends RecyclerView.ViewHolder {
        final HotelImageAdapter mAdapter;
        public final ImageView hotelImageView;
        public HotelImageViewHolder(View itemView,HotelImageAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            hotelImageView = (ImageView) itemView.findViewById(R.id.hotel_image_view);
        }
    }

    public HotelImageAdapter(Context context, int[] mHotelImages) {
        mInflater = LayoutInflater.from(context);
        this.mHotelImages = mHotelImages;
        this.context = context;
    }
    @Override
    public HotelImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.hotel_images_list_item, parent, false);
        return new HotelImageAdapter.HotelImageViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(HotelImageViewHolder holder, int position) {
        final int mCurrentHotelImage = mHotelImages[position];
        holder.hotelImageView.setImageResource(mCurrentHotelImage);
    }

    @Override
    public int getItemCount() {
        return mHotelImages.length;
    }


}
