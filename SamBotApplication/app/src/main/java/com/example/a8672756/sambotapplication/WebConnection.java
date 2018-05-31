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
/**
 * @author  DONNET Marie
 * @author PHAM TRAN Toan
 * @author LATOUR Rodolphe
 * Class to connect the smartphone to the cloud server
 * Create on may 23 2018
 *
 */
public class WebConnection extends AsyncTask<String, Void, String> {

    //Variable declaration
    //Variable str
    private String str;

    /**
     * @param params
     */
    @Override
    protected String doInBackground(String... params) {
        this.str = params[0];
        return null;
    }
    /**
     * @param s
     */

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        str = s;
    }


    /**
     *Method to execute a request
     * @param url
     */
    public void executeRequest (final URL url) {
        // try to connect

        Thread tryConnection = new Thread() {
            public void run() {
                String webcontent =null;
                try {
                    //Initiate the url connection
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    try {
                        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                        webcontent = generateString(in);
                        //if the server respond the webcontent will send Ok
                        if (webcontent != "OK") {

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        tryConnection.start();
    }
    /**
     * Method generate String
     * @param stream
     */
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
