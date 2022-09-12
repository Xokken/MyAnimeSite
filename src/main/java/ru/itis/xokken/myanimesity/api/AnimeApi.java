package ru.itis.xokken.myanimesity.api;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.stereotype.Component;
import ru.itis.xokken.myanimesity.api.entity.QuoteResponse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class AnimeApi {


    private Gson gson = new Gson();
    private static String baseUrl="https://animechan.vercel.app/api";
    private static Interceptor interceptor = chain -> {
        Request original = chain.request();
        HttpUrl buffer = chain.request().url().newBuilder()
                .addPathSegment("random")
                .build();
        return chain.proceed(original.newBuilder().url(buffer).build());
    };


    public QuoteResponse getQuoteResponse(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(baseUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            QuoteResponse quoteResponse = gson.fromJson(response.body().string(), QuoteResponse.class);
            return quoteResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}