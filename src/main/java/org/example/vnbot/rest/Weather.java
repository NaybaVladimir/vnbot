package org.example.vnbot.rest;

import org.example.vnbot.workingWithFiles.FileRead;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Location;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    public static List<String> weatherMain(Location location) {
        String uri = "https://api.weather.yandex.ru/v2/informers?lat="
                + location.getLatitude()
                + "&lon="
                + location.getLongitude()
                + "&lang=ru_RU";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", new FileRead().propertiesRead("weather.token", "init.properties"));
        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        String json = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(json);

        String fact = "\uD83C\uDF1EПогода за бортом:\n---------------------------------------\n\uD83E\uDD76<b>Темература(℃):</b> "
                + jsonObject.getJSONObject("fact").get("temp")
                + "\n\uD83D\uDCA8<b>Ветер: Скорость(Средняя/Порывы):</b> "
                + jsonObject.getJSONObject("fact").get("wind_speed")
                + "/"
                + jsonObject.getJSONObject("fact").get("wind_gust")
                + "\n\uD83C\uDF26<b>Состояние погоды:</b> "
                + jsonObject.getJSONObject("fact").get("condition")
                + "\n<b>Время года:</b> "
                + jsonObject.getJSONObject("fact").get("season");

        String message = "Прогнозируется:";
        String weatherForecast = "\uD83C\uDF13" + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(0)
                .get("part_name")
                + ":\n\uD83E\uDD76<b>Температура(℃)(min/max):</b> "
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(0).get("temp_min")
                + "/"
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(0).get("temp_max")
                + "\n\uD83D\uDCA8<b>Ветер: Скорость(Средняя/Порывы):</b> "
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(0).get("wind_speed")
                + "/"
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(0).get("wind_gust")
                + "\n\uD83C\uDF26<b>Состояние погоды:</b> "
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(0).get("condition");

        String weatherForecastNext = "\uD83C\uDF13" + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(1)
                .get("part_name")
                + ":\n\uD83E\uDD76<b>Температура(℃)(min/max):</b> "
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(1).get("temp_min")
                + "/"
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(1).get("temp_max")
                + "\n\uD83D\uDCA8<b>Ветер: Скорость(Средняя/Порывы):</b> "
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(1).get("wind_speed")
                + "/"
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(1).get("wind_gust")
                + "\n\uD83C\uDF26<b>Состояние погоды:</b> "
                + jsonObject.getJSONObject("forecast").getJSONArray("parts").getJSONObject(1).get("condition");
        List<String> weatherList = new ArrayList<>();
        weatherList.add(fact);
        weatherList.add(message);
        weatherList.add(weatherForecast);
        weatherList.add(weatherForecastNext);
        return weatherList;

    }
}
