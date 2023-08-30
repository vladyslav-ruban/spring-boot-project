package org.example.service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.example.configuration.WorldTimeApiConfig;
import org.example.model.WorldTimeApiResponse;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

    private final WorldTimeApiConfig worldTimeApiConfig;

    public TimeServiceImpl(WorldTimeApiConfig worldTimeApiConfig) {
        this.worldTimeApiConfig = worldTimeApiConfig;
    }

    @Override
    public String getCurrentTime(String timeZone) {
        HttpResponse<WorldTimeApiResponse> response = Unirest.get(
                        worldTimeApiConfig.getEndpoint() + worldTimeApiConfig.getContinent() + "/" + timeZone)
                .asObject(WorldTimeApiResponse.class);

        return response.getBody().getUtc_datetime();
    }
}
