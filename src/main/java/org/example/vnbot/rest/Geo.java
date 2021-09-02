package org.example.vnbot.rest;

import org.example.vnbot.workingWithFiles.FileRead;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Location;

public class Geo {
    public static String geoMain(Location location) {
        String uri = "https://geocode-maps.yandex.ru/1.x?format=json&result=1&skip=1&lang=ru_RU&kind=house&geocode="
                + location.getLongitude()
                + ","
                + location.getLatitude()
                + "&apikey="
                + new FileRead().propertiesRead("geo.token", "init.properties");
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(uri, String.class);
        JSONObject jsonObject = new JSONObject(json);
        String address = jsonObject.getJSONObject("response")
                .getJSONObject("GeoObjectCollection")
                .getJSONArray("featureMember")
                .getJSONObject(0)
                .getJSONObject("GeoObject")
                .getJSONObject("metaDataProperty")
                .getJSONObject("GeocoderMetaData")
                .getJSONObject("Address")
                .get("formatted") + "";
        return address;

    }

}
