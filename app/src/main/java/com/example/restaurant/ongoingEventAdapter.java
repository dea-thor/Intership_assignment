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

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ongoingEventAdapter extends RecyclerView.Adapter<ongoingEventAdapter.onGoingEventtViewHolder>  {



    Context mcontext;
    private List<OngoingEvent> mOngoingEventList;




    public static class onGoingEventtViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;
        public CardView mCardView;
        public TextView dateTimeTextView;
        public TextView eventName;
        public TextView details;

        public onGoingEventtViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.ongoingImage);
            mCardView = itemView.findViewById(R.id.OnGoingEventCardView);
            dateTimeTextView = itemView.findViewById(R.id.dateTime);
            eventName = itemView.findViewById(R.id.eventName);
            details = itemView.findViewById(R.id.details);
        }
    }

    public ongoingEventAdapter(List<OngoingEvent> ongoingEventList, Context context)
    {
        mcontext = context;
        mOngoingEventList = ongoingEventList;


    }
    @NonNull
    @Override
    public onGoingEventtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoingeventcard,parent,false);
        ongoingEventAdapter.onGoingEventtViewHolder viewHolder = new ongoingEventAdapter.onGoingEventtViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull onGoingEventtViewHolder holder, int position) {

        OngoingEvent ongoingEvent = mOngoingEventList.get(position);
        Glide.with(mcontext).load(ongoingEvent.getIconURL()).into(holder.mImageView);

        String dtetime = ongoingEvent.getDateTime();
        char ch = '-';
        dtetime = dtetime.replace(' ',ch);
        holder.dateTimeTextView.setText(dtetime);

        holder.eventName.setText(ongoingEvent.getName());
        String dt = ongoingEvent.getType() + " : " + ongoingEvent.getLocation();
        holder.details.setText(dt);


    }

    @Override
    public int getItemCount() {
        return mOngoingEventList.size();
    }







}
