package org.example.service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.example.model.WorldTimeApiResponse;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    public TimeServiceImpl() {
    }

    @Override
    public String getCurrentTime(String timeZone) {
        HttpResponse<WorldTimeApiResponse> response = Unirest.get("http://worldtimeapi.org/api/timezone/Europe/" + timeZone).asObject(WorldTimeApiResponse.class);

        return response.getBody().getUtc_datetime();
    }
}
