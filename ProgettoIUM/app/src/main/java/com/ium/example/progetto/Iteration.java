package com.ium.example.progetto;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Iteration {

    String URL = "http://192.168.0.8:8080/ProgettoIUM_war_exploded/";                                                         //cardo
    //      conn = (HttpURLConnection) new URL("http://192.168.42.77:8080/ProgettoIUm2_war_exploded/"+url).openConnection();   //nik
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client=new OkHttpClient();

    public String post(String url, String json) throws IOException {
        String ritorno = null;
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(URL+url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String ritorno = response.body().string();
            }
        });

        return ritorno;
    }
}
