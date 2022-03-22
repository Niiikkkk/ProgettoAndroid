package com.ium.example.progetto;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Iteration {
    public HttpURLConnection getConnection(String url){
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL("http://192.168.0.8:8080/ProgettoIUM_war_exploded/"+url).openConnection();             //cardo
            //        conn = (HttpURLConnection) new URL("http://192.168.42.77:8080/ProgettoIUm2_war_exploded/"+url).openConnection();     //nik

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

    public String login(String url,String data){
        try{

            HttpURLConnection conn = getConnection(url);

            //Get output stream
            OutputStream out = conn.getOutputStream();
            out.write(data.getBytes());
            out.flush();
            if (conn.getResponseCode() == 200) {
                //Gets the input stream object of the response
                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuffer response = new StringBuffer();

                String line=null;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
