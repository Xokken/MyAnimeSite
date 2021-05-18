package ru.itis.xokken.myanimesity.api;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.stereotype.Component;
import ru.itis.xokken.myanimesity.api.entity.QuoteResponse;
import ru.itis.xokken.myanimesity.api.entity.WeatherResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class WeatherApi {

    public static String baseUrl="https://api.openweathermap.org/data/2.5/";
    public static String API_KEY="a9c5074f7a3453debb7a93f17648e43e";
    public static String QUERY_API_KEY = "appid";
    public static String QUERY_LANG = "lang";
    public static String QUERY_UNITS = "units";

    public static Interceptor apiKeyInterceptor = chain -> {
        Request original = chain.request();
        HttpUrl buffer = chain.request().url().newBuilder()
                .addQueryParameter(QUERY_API_KEY, API_KEY)
                .addQueryParameter(QUERY_UNITS, "metric")
                .addQueryParameter(QUERY_LANG, "ru")
                .build();
        return chain.proceed(original.newBuilder().url(buffer).build());
    };

    public WeatherResponse getWeatherResponse(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(baseUrl + "weather?q=kazan")
                .build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            WeatherResponse weatherResponse = gson.fromJson(response.body().string(), WeatherResponse.class);
            return weatherResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
