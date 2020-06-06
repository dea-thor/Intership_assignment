
package com.example.restaurant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreEventsNow {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iconURL")
    @Expose
    private String iconURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

}
