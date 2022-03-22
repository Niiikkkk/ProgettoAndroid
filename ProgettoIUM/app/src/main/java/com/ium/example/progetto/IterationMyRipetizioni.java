package com.ium.example.progetto;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;

public class IterationMyRipetizioni extends AsyncTask<String, Void, String> {

private Iteration i;

    public IterationMyRipetizioni (Iteration i)
    {
      this.i=i;
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            String url = strings[0];
            String data = strings[1];

            HttpURLConnection conn = i.getConnection(url);

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

    @Override
    protected void onPostExecute(String result) {

    }
}
