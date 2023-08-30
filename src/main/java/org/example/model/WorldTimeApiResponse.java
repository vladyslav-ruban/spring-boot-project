package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class WorldTimeApiResponse {
    private String utc_datetime;

    public WorldTimeApiResponse(String utc_datetime) {
        this.utc_datetime = utc_datetime;
    }

    public String getUtc_datetime() {
        return utc_datetime;
    }

    public void setUtc_datetime(String utc_datetime) {
        this.utc_datetime = utc_datetime;
    }
}
