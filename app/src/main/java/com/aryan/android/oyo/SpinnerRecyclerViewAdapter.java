package com.aryan.android.oyo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin1 on 1/3/18.
 */

public class SpinnerRecyclerViewAdapter extends RecyclerView.Adapter<SpinnerRecyclerViewAdapter.SpinViewHolder> {

    private  List<String> mCountryCode;
    private  List<String> mCountryName;
    private  LayoutInflater mInflater;
    private  Context mContext;

    class SpinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView countryNameItemView;
        public final TextView countrCodeItemView;
        //public final ImageView wordImageView;
        final SpinnerRecyclerViewAdapter mAdapter;


        /**
         * Creates a new custom view holder to hold the view to display in the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views for the RecyclerView.
         */
        public SpinViewHolder(View itemView, SpinnerRecyclerViewAdapter adapter) {
            super(itemView);
            countrCodeItemView = (TextView) itemView.findViewById(R.id.country_code_recycler_view);
            countryNameItemView = (TextView) itemView.findViewById(R.id.country_name_recycler_view);
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {

        }
    }

    public SpinnerRecyclerViewAdapter(Context context, List<String> mCountryName,List<String> mCountryCode) {
        mInflater = LayoutInflater.from(context);
        this.mCountryName = mCountryName;
        this.mCountryCode = mCountryCode;
        mContext = context;
        //this.mWordImageList = imageList;
    }

    /**
     * Inflates an item view and returns a new view holder that contains it.
     * Called when the RecyclerView needs a new view holder to represent an item.
     *
     * @param parent The view group that holds the item views.
     * @param viewType Used to distinguish views, if more than one type of item view is used.
     * @return a view holder.
     */
    @Override
    public SpinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.spinner_recycler_view, parent, false);
        return new SpinViewHolder(mItemView, this);
    }

    /**
     * Sets the contents of an item at a given position in the RecyclerView.
     * Called by RecyclerView to display the data at a specificed position.
     *
     * @param holder The view holder for that position in the RecyclerView.
     * @param position The position of the item in the RecycerView.
     */
    @Override
    public void onBindViewHolder(SpinViewHolder holder, final int position) {
        // Retrieve the data for that position.
        final String mCurrentCountryCode = mCountryCode.get(position);
        String mCurrentCountryName = mCountryName.get(position);
        //int mCurrentImage = mWordImageList.get(position);
        // Add the data to the view holder.
        holder.countryNameItemView.setText(mCurrentCountryName);
        holder.countrCodeItemView.setText(mCurrentCountryCode);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*TextView code = view.findViewById(R.id.country_code);
                Log.d("check",code.getText().toString());
                code.setText(mCurrentCountryCode);*/
                FirstRunSecondActivity.mCountryCode.setText(mCurrentCountryCode);
                FirstRunSecondActivity.dialog.dismiss();
                FirstRunSecondActivity.mFlagImage.setImageResource(FirstRunSecondActivity.imageArray.getResourceId(position,-1));
            }
        });

        //  holder.wordImageView.setImageResource(mCurrentImage);
    }

    /**
     * Returns the size of the container that holds the data.
     *
     * @return Size of the list of data.
     */
    @Override
    public int getItemCount() {
        return mCountryName.size();
    }
}
