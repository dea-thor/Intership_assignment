
package com.example.restaurant;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("statusMessage")
    @Expose
    private String statusMessage;
    @SerializedName("Explore Events Now")
    @Expose
    private List<ExploreEventsNow> exploreEventsNow = null;
    @SerializedName("Ongoing Events")
    @Expose
    private List<OngoingEvent> ongoingEvents = null;
    @SerializedName("Upcoming Events")
    @Expose
    private List<UpcomingEvent> upcomingEvents = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<ExploreEventsNow> getExploreEventsNow() {
        return exploreEventsNow;
    }

    public void setExploreEventsNow(List<ExploreEventsNow> exploreEventsNow) {
        this.exploreEventsNow = exploreEventsNow;
    }

    public List<OngoingEvent> getOngoingEvents() {
        return ongoingEvents;
    }

    public void setOngoingEvents(List<OngoingEvent> ongoingEvents) {
        this.ongoingEvents = ongoingEvents;
    }

    public List<UpcomingEvent> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<UpcomingEvent> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

}
