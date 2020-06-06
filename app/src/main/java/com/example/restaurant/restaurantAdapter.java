package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class restaurantAdapter  extends RecyclerView.Adapter<restaurantAdapter.restaurantViewHolder> implements Filterable{

    Context mcontext;
    private List<ExploreEventsNow> mRestaurantList;
    List<ExploreEventsNow> restaurantListAll;



    public static class restaurantViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;
        public CardView mCardView;
        public TextView mTextView;

        public restaurantViewHolder(@NonNull View itemView) {
            super(itemView);
           mImageView = itemView.findViewById(R.id.restaurantImage);
           mCardView = itemView.findViewById(R.id.restaurantCardView);
           mTextView = itemView.findViewById(R.id.restaurantName);
        }
    }



    public restaurantAdapter(List<ExploreEventsNow> restaurantList, Context context)
    {
        mcontext = context;
        mRestaurantList = restaurantList;
        restaurantListAll = new ArrayList<>(restaurantList);


    }

    @NonNull
    @Override
    public restaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurantcard,parent,false);
        restaurantViewHolder viewHolder = new restaurantViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull restaurantViewHolder holder, int position) {

        ExploreEventsNow currentRestaurant = mRestaurantList.get(position);
        Glide.with(mcontext).load(currentRestaurant.getIconURL()).into(holder.mImageView);
        String restaurantName = currentRestaurant.getName();
        char ch = '\n';
        restaurantName = restaurantName.replace(' ',ch);

        holder.mTextView.setText(restaurantName);





    }

    @Override
    public int getItemCount() {
        return mRestaurantList.size();
    }

    @Override

    public Filter getFilter() {
        return filter;
    }


    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ExploreEventsNow> filteredList = new ArrayList<>();
            if(constraint.toString().isEmpty()) {

                filteredList.addAll(restaurantListAll);
            }
            else
            {
                for(ExploreEventsNow restaurant : restaurantListAll)
                {
                    if(restaurant.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {

                        filteredList.add(restaurant);


                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;


            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

          mRestaurantList.clear();
          mRestaurantList.addAll((Collection<? extends ExploreEventsNow>) results.values);
          notifyDataSetChanged();


        }
    };








}
