package com.aryan.android.oyo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by admin1 on 27/2/18.
 */

public class FirstRunAdapter extends RecyclerView.Adapter<FirstRunAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
   // private final LinkedList<Integer> mWordImageList;
    private final LayoutInflater mInflater;
    private final int[] mImages;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView wordItemView;
        //public final ImageView wordImageView;
        final FirstRunAdapter mAdapter;

        /**
         * Creates a new custom view holder to hold the view to display in the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views for the RecyclerView.
         */
        public WordViewHolder(View itemView, FirstRunAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.description);
           // wordImageView = (ImageView) itemView.findViewById(R.id.img) ;
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {

        }
    }

    public FirstRunAdapter(Context context, LinkedList<String> wordList,int[] mImages/*,LinkedList<Integer> imageList*/) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.mImages = mImages;
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
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.a_scene, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    /**
     * Sets the contents of an item at a given position in the RecyclerView.
     * Called by RecyclerView to display the data at a specificed position.
     *
     * @param holder The view holder for that position in the RecyclerView.
     * @param position The position of the item in the RecycerView.
     */
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        // Retrieve the data for that position.
        String mCurrent = mWordList.get(position);
        int mCurrentImage = mImages[position];
        //int mCurrentImage = mWordImageList.get(position);
        // Add the data to the view holder.
        holder.wordItemView.setText(mCurrent);
        holder.wordItemView.setCompoundDrawablesWithIntrinsicBounds(mCurrentImage,0 , 0, 0);
      //  holder.wordImageView.setImageResource(mCurrentImage);
    }

    /**
     * Returns the size of the container that holds the data.
     *
     * @return Size of the list of data.
     */
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
