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
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IterationLogin extends AsyncTask<String,Void, ArrayList<String>>{

    static final String COOKIES_HEADER = "Set-Cookie";

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView txtError;
    private Context context;
    private Iteration i;

    public IterationLogin(Iteration i ,Context context, EditText editTextUsername, EditText editTextPassword, TextView txtError) {
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
    protected ArrayList<String> doInBackground(String... strings) {

        ArrayList<String> returns;

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
                returns = new ArrayList<>();
                Map<String, List<String>> headerFields = conn.getHeaderFields();
                List<String> cookiesHeader = headerFields.get(COOKIES_HEADER);
                for(String s:cookiesHeader){
                    if(s.startsWith("JSESSIONID")){
                        returns.add(s.split(";")[0]);
                    }
                }
                //Gets the input stream object of the response
                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuffer response = new StringBuffer();

                String line=null;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                returns.add(response.toString());
                return returns;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(ArrayList<String> loginJson) {
        if(loginJson!=null){
            Gson gson = new Gson();
            Utente u = gson.fromJson(loginJson.get(1), Utente.class);
            if(u!=null && u.getIdUtente()!=-1){
                txtError.setText("");
                Intent intent = new Intent(context, LoggedActivity.class);
                intent.putExtra("user",u);
                intent.putExtra("cookie",loginJson.get(0));
                context.startActivity(intent);
                editTextPassword.setText("");
                editTextUsername.setText("");
            }else{
                txtError.setText("Username or Password wrong");
            }
        }
    }
}
