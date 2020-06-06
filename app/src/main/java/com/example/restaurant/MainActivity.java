package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView restaurantRecyclerView;
    RecyclerView onGoingEventRecyclerView;
    RecyclerView upComingEventRecyclerView;
    restaurantAdapter rAdapter;
    RecyclerView.Adapter ogeAdapter;
    RecyclerView.Adapter uceAdapter;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager ogelayoutManager;
    RecyclerView.LayoutManager ucelayoutManager;
    Toolbar toolbar;
    SearchView searchView;

    Resource list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        searchView = findViewById(R.id.searchView);




        //restaurant list recycler view
        restaurantRecyclerView = findViewById(R.id.restaurantRecyclerView);
        restaurantRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        restaurantRecyclerView.setLayoutManager(layoutManager);

        //ongoing events list recycler view intialisations
        onGoingEventRecyclerView = findViewById(R.id.ongoingEventRecyclerView);
        onGoingEventRecyclerView.setHasFixedSize(true);
        ogelayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        onGoingEventRecyclerView.setLayoutManager(ogelayoutManager);

        //upcoming event list recycler view
        upComingEventRecyclerView = findViewById(R.id.upcomingEventRecyclerView);
        upComingEventRecyclerView.setHasFixedSize(true);
        ucelayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        upComingEventRecyclerView.setLayoutManager(ucelayoutManager);


        //calling the function to make and API call
        getData();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                rAdapter.getFilter().filter(newText);


                return false;
            }
        });










    }


    // function to make api call

    void getData()
    {
        Call<Resource>  newResource = API.getDataService().getResource();

        newResource.enqueue(new Callback<Resource>() {
            @Override
            public void onResponse(Call<Resource> call, Response<Resource> response) {

                list = response.body();
                List<ExploreEventsNow> restaurantList = list.getExploreEventsNow();
                rAdapter = new restaurantAdapter(restaurantList,MainActivity.this);
                restaurantRecyclerView.setAdapter(rAdapter);

                List<OngoingEvent> ongoingEventList = list.getOngoingEvents();
                ogeAdapter = new ongoingEventAdapter(ongoingEventList,MainActivity.this);
                onGoingEventRecyclerView.setAdapter(ogeAdapter);

                List<UpcomingEvent> upcomingEvents = list.getUpcomingEvents();
                uceAdapter = new upcomingEventAdapter(upcomingEvents,MainActivity.this);
                upComingEventRecyclerView.setAdapter(uceAdapter);




            }

            @Override
            public void onFailure(Call<Resource> call, Throwable t) {

            }
        });


    }




}
