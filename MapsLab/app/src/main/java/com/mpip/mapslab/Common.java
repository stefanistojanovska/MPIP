package com.mpip.mapslab;

import com.mpip.mapslab.Remote.IGoogleApiService;
import com.mpip.mapslab.Remote.RetrofitClient;

public class Common {
    private static final String GOOGLE_API_URL="https://maps.googleapis.com/";
    public static IGoogleApiService getGoogleAPIServie()
    {
        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleApiService.class);
    }
}
