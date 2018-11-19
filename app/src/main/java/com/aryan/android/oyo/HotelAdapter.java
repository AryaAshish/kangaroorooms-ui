package com.aryan.android.oyo;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin1 on 10/3/18.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelItemViewHolder> {

    private TypedArray mHotelImages;
    private List<String> mRoomIds;
    private List<Integer> mFavouriteImages;
    private List<String> mOriginalCosts;
    private List<String> mReducedCosts;
    private List<String> mDiscounts;
    private List<String> mHotelRatings;
    private List<String> mDescriptions;
    private List<String> mRatings;
    private List<String> mHotelNames;
    private List<String> mHotelLocations;
    private LayoutInflater mInflater;
    private Context context;
    public int row_index;
    public String mCity;
    private int width;

    public static final String EXTRA_IMAGE_ID = "IMAGE_ID";
    public static final String EXTRA_ROOM_ID = "ROOM_ID";
    public static final String EXTRA_FAVOURITE_IMAGE = "FAVOURITE_IMAGE";
    public static final String EXTRA_ORIGINAL_COST = "ORIGINAL_COST";
    public static final String EXTRA_REDUCED_COST = "REDUCED_COST";
    public static final String EXTRA_DISCOUNT = "DISCOUNT";
    public static final String EXTRA_HOTEL_RATING = "HOTEL_RATING";
    public static final String EXTRA_DESCRIPTION = "DESCRIPTION";
    public static final String EXTRA_RATING = "RATING";
    public static final String EXTRA_HOTEL_NAME = "HOTEL_NAME";
    public static final String EXTRA_HOTEL_LOCATION = "HOTEL_LOCATION";
    public static final String EXTRA_CITY = "CITY";

    public class HotelItemViewHolder extends RecyclerView.ViewHolder {

        public final ImageView hotelImageView;
        public final ImageView favouriteSymbol;
        final HotelAdapter mAdapter;
        public final TextView mHotelName;
        public final TextView mHotelCity;
        public final TextView mRoomId;
        public final TextView mOriginalCost;
        public final TextView mReducedCost;
        public final TextView mDiscount;
        public final TextView mHotelRating;
        public final TextView mDescription;
        public final TextView mRating;
        public final TextView mHotelLocation;
        public final LinearLayout mHotelDetailsLayout;



        public HotelItemViewHolder(View itemView,HotelAdapter adapter) {
            super(itemView);
            hotelImageView = (ImageView) itemView.findViewById(R.id.hotel_img);
            favouriteSymbol = (ImageButton) itemView.findViewById(R.id.favourite_symbol1);
            mHotelName = (TextView) itemView.findViewById(R.id.hotel_name) ;
            mAdapter = adapter;
            mHotelCity = (TextView) itemView.findViewById(R.id.hotel_city) ;
            mRoomId = (TextView) itemView.findViewById(R.id.room_id);
            mOriginalCost = (TextView) itemView.findViewById(R.id.room_original_cost);
            mReducedCost = (TextView) itemView.findViewById(R.id.room_cost_after_discount);
            mDiscount = (TextView) itemView.findViewById(R.id.discount);
            mHotelRating = (TextView) itemView.findViewById(R.id.hotel_rating);
            mDescription = (TextView) itemView.findViewById(R.id.hotel_description);
            mRating = (TextView) itemView.findViewById(R.id.rating_count);
            mHotelLocation = (TextView) itemView.findViewById(R.id.hotel_location);
            mHotelDetailsLayout = (LinearLayout) itemView.findViewById(R.id.hotel_details);
        }
    }

    public HotelAdapter(Context context,TypedArray mHotelImages,List<Integer> mFavouriteImages,String mCity,List<String> mRommIds,List<String> mHotelNames,
                        List<String> mOriginalRates,  List<String> mReducedCosts, List<String> mDiscounts, List<String> mHotelRatings,
                        List<String>  mDescriptions,  List<String> mRatings, List<String> mHotelLocations) {
        mInflater = LayoutInflater.from(context);
        this.mHotelImages = mHotelImages;
        this.context = context;
        this.mFavouriteImages = mFavouriteImages;
        this.mCity = ", "+mCity;
        this.mRoomIds = mRommIds;
        this.mHotelNames = mHotelNames;
        this.mOriginalCosts = mOriginalRates;
        this.mReducedCosts = mReducedCosts;
        this.mDiscounts = mDiscounts;
        this.mHotelRatings = mHotelRatings;
        this.mDescriptions = mDescriptions;
        this.mRatings = mRatings;
        this.mHotelLocations = mHotelLocations;
        this.width = width;
    }
    @Override
    public HotelAdapter.HotelItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.hotels_list_item, parent, false);
        return new HotelAdapter.HotelItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(final HotelAdapter.HotelItemViewHolder holder, final int position) {
        final int mCurentHotelImage = mHotelImages.getResourceId(position,-1);
        Log.d("Image id",mCurentHotelImage+"");
        final int mCurrentFavouriteImage = mFavouriteImages.get(position);
        final String mCurrentRoomId = mRoomIds.get(position);
        final String mCurrentHotelName = " " + mHotelNames.get(position) ;
        final String mCurrentOriginalCost = "Rs. " + mOriginalCosts.get(position);
        final String mCurrentReducedCost = "Rs. " + mReducedCosts.get(position);
        final String mCurrentDiscount = "" + mDiscounts.get(position) + "% OFF";
        final String mCurrentHotelRating = "" + mHotelRatings.get(position);
        final String mCurrentDescription = "" + mDescriptions.get(position);
        final String mCurrentRating = "" + mRatings.get(position);
        final String mCurrentHotelLocation = mHotelLocations.get(position);
        //ViewGroup.LayoutParams params=holder.mHotelDetailsLayout.getLayoutParams();

        holder.hotelImageView.setImageResource(mCurentHotelImage);
        holder.favouriteSymbol.setImageResource(mCurrentFavouriteImage);
        holder.mHotelCity.setText(mCity);
        holder.mRoomId.setText(mCurrentRoomId);
        holder.mHotelName.setText(mCurrentHotelName);
        holder.mOriginalCost.setText(mCurrentOriginalCost);
        holder.mReducedCost.setText(mCurrentReducedCost);
        holder.mDiscount.setText(mCurrentDiscount);
        holder.mHotelRating.setText(mCurrentHotelRating);
        holder.mDescription.setText(mCurrentDescription);
        holder.mRating.setText(mCurrentRating);
        holder.mHotelLocation.setText(mCurrentHotelLocation);
        /*if(width == 0) {
            holder.mHotelDetailsLayout.setPadding(0,0,0,0);
            params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        } else {
            holder.mHotelDetailsLayout.setPadding(10,0,10,0);
            params.width = width;
        }
        holder.mHotelDetailsLayout.setLayoutParams(params);*/

        holder.favouriteSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mFavouriteImages.get(position) == R.drawable.ic_favorite_white_24dp) {
                    mFavouriteImages.set(position, R.drawable.ic_favorite_red_24dp);
                    notifyDataSetChanged();
                }
                else {
                    mFavouriteImages.set(position, R.drawable.ic_favorite_white_24dp) ;
                    notifyDataSetChanged();
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,HotelActivity_1.class);

                intent.putExtra(EXTRA_IMAGE_ID,mCurentHotelImage);
                intent.putExtra(EXTRA_ROOM_ID,mCurrentRoomId);
                intent.putExtra(EXTRA_FAVOURITE_IMAGE,mCurrentFavouriteImage);
                intent.putExtra(EXTRA_ORIGINAL_COST,mCurrentOriginalCost);
                intent.putExtra(EXTRA_REDUCED_COST,mCurrentReducedCost);
                intent.putExtra(EXTRA_DISCOUNT,mCurrentDiscount);
                intent.putExtra(EXTRA_HOTEL_RATING,mCurrentHotelRating);
                intent.putExtra(EXTRA_DESCRIPTION,mCurrentDescription);
                intent.putExtra(EXTRA_RATING,mCurrentRating);
                intent.putExtra(EXTRA_HOTEL_NAME,mCurrentHotelName);
                intent.putExtra(EXTRA_HOTEL_LOCATION,mCurrentHotelLocation);
                intent.putExtra(EXTRA_CITY,mCity);

                (context).startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return mHotelImages.length();
    }
   /*public void setOnClick(OnItemClicked onClick)
    {
        this.onClick=onClick;
    }*/
   public interface ItemClickListener {
       void onClick(View view, int position, boolean isLongClick);
   }

}
