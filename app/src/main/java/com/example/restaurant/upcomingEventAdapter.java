package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class upcomingEventAdapter extends RecyclerView.Adapter<upcomingEventAdapter.upComingEventViewHolder>{



    Context mcontext;
    private List<UpcomingEvent> mUpcomingEventList;



    public static class upComingEventViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView uceImageView;
        public CardView mCardView;
        public TextView dateTimeTextView;
        public TextView eventName;
        public TextView details;

        public upComingEventViewHolder(@NonNull View itemView) {
            super(itemView);
            uceImageView = itemView.findViewById(R.id.upcomingEventImage);
            mCardView = itemView.findViewById(R.id.upcomingEventCardView);
            eventName = itemView.findViewById(R.id.eventNameu);
            dateTimeTextView = itemView.findViewById(R.id.dateTimeu);
            details = itemView.findViewById(R.id.detailsu);
        }
    }

    public upcomingEventAdapter(List<UpcomingEvent> upcomingEventList, Context context)
    {
        mcontext = context;
        mUpcomingEventList = upcomingEventList;


    }

    @NonNull
    @Override
    public upComingEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcomingeventcard,parent,false);
        upcomingEventAdapter.upComingEventViewHolder viewHolder = new upcomingEventAdapter.upComingEventViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull upComingEventViewHolder holder, int position) {

        UpcomingEvent upcomingEvent = mUpcomingEventList.get(position);
        Glide.with(mcontext).load(upcomingEvent.getIconURL()).into(holder.uceImageView);


        String dtetime = upcomingEvent.getDateTime();
        char ch = '-';
        dtetime = dtetime.replace(' ',ch);
        holder.dateTimeTextView.setText(dtetime);

        holder.eventName.setText(upcomingEvent.getName());
        String dt = upcomingEvent.getType() + " : " + upcomingEvent.getLocation();
        holder.details.setText(dt);

    }

    @Override
    public int getItemCount() {
        return mUpcomingEventList.size();
    }







}

