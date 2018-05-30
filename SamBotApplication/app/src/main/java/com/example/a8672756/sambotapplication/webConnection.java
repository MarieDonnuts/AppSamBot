package com.example.a8672756.sambotapplication;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class webConnection extends AsyncTask<String, Void, String> {

    String str;

    @Override
    protected String doInBackground(String... params) {
        this.str = params[0];
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        str = s;
    }

    public static String executeRequest(URL url) {
        HttpURLConnection urlConnection = null;
        String webcontent = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            webcontent = generateString(in);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }
        return webcontent;
    }

    private static String generateString(InputStream stream){
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        try {
            String cur;
            while ((cur = buffer.readLine()) != null){
                sb.append(cur + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
