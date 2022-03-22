package com.ium.example.progetto;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ium.example.myapplication.LoggedActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class IterationLogin extends AsyncTask<String,Void,String>{

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView txtError;
    private Context context;
    private Iteration i;

    public IterationLogin(Iteration i , Context context, EditText editTextUsername, EditText editTextPassword, TextView txtError) {
        this.i = i;
        this.editTextUsername = editTextUsername;
        this.editTextPassword = editTextPassword;
        this.txtError = txtError;
        this.context = context;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        txtError.setText("Username and Password required");
    }

    @Override
    protected String doInBackground(String... strings) {

        if(editTextPassword.getText()==null || editTextPassword.getText().toString().equals("")
                || editTextUsername.getText()==null || editTextUsername.getText().toString().equals("")){
            publishProgress();  //this calls onProgressUpdate
            return null;
        }

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

    protected void onPostExecute(String loginJson) {
        if(loginJson!=null){
            Gson gson = new Gson();
            Utente u = gson.fromJson(loginJson, Utente.class);
            if(u!=null && u.getIdUtente()!=-1){
                txtError.setText("");
                Intent intent = new Intent(context, LoggedActivity.class);
                intent.putExtra("user", u);
                context.startActivity(intent);
                editTextPassword.setText("");
                editTextUsername.setText("");
            }else{
                txtError.setText("Username or Password wrong");
            }
        }
    }
}
