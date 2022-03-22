package com.ium.example.progetto;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ium.example.myapplication.LoggedActivity;
import com.ium.example.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IterationLogin extends AsyncTask<String,Void,String>{

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView txtError;
    private Context context;

    public IterationLogin(Context context, EditText editTextUsername, EditText editTextPassword, TextView txtError) {
        this.editTextUsername = editTextUsername;
        this.editTextPassword = editTextPassword;
        this.txtError = txtError;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        if(editTextPassword.getText()==null || editTextPassword.getText().toString().equals("")
                || editTextUsername.getText()==null || editTextUsername.getText().toString().equals("")){
            txtError.setText("Username and Password required");
            return;
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            String url = strings[0];
            String data = strings[1];

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

    protected void onPostExecute(String loginJson) {
        Gson gson = new Gson();
        Utente u = gson.fromJson(loginJson, Utente.class);
        if(u!=null && u.getIdUtente()!=-1){
            txtError.setText("");
            Intent intent = new Intent(context, LoggedActivity.class);
            intent.putExtra("user",u);
            context.startActivity(intent);
        }else{
            txtError.setText("Username or Password wrong");
        }
    }


    public HttpURLConnection getConnection(String url){
        HttpURLConnection conn = null;
        try {
            //conn = (HttpURLConnection) new URL("http://192.168.0.8:8080/ProgettoIUM_war_exploded/"+url).openConnection();
            conn = (HttpURLConnection) new URL("http://192.168.42.77:8080/ProgettoIUm2_war_exploded/"+url).openConnection();   //nik
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
