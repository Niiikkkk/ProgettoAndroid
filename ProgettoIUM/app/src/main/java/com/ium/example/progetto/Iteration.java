package com.ium.example.progetto;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Iteration {
    public void login(String url, String data, View view, EditText editTextUsername, EditText editTextPassword, TextView txtError) {
        new IterationLogin(this,view.getContext(), editTextUsername, editTextPassword, txtError).execute(url,data);
    }

    public void logout(String url, String data) {
        new IteratorLogout(this).execute(url,data);
    }

    public void MyRipetizioni(String url)
    {
      new IterationMyRipetizioni(this).execute(url);
    }

    public HttpURLConnection getConnection(String url){
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL("http://192.168.0.8:8080/ProgettoIUM_war_exploded/"+url).openConnection();
         //   conn = (HttpURLConnection) new URL("http://192.168.42.77:8080/ProgettoIUm2_war_exploded/"+url).openConnection();   //nik
            //Set request mode and request timeout information
            conn.setRequestMethod("POST");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            //Set operation input and output:
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //The post mode cannot be cached and needs to be manually set to false
            conn.setUseCaches(false);
            //Data we requested:
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }



}
