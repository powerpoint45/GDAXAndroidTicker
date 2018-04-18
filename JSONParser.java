package com.powerpoint45.gdaxtest;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONParser {

    public static JSONArray getJSONOArrayFromURL(String urlString) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);

            connection = (HttpURLConnection) url.openConnection();

            connection.connect();
            Log.d("GDAX","RES CODE:" + connection.getResponseCode());


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            JSONArray jObj = null;
            try {
                jObj = new JSONArray(buffer.toString());
            } catch (JSONException e) {
                Log.e("draw", "Error parsing data " + e.toString());
            }


            // return JSON Object
            return jObj;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    public static JSONObject getJSONObjectFromURL(String urlString) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);

            connection = (HttpURLConnection) url.openConnection();

            connection.connect();
            Log.d("GDAX","RES CODE:" + connection.getResponseCode());


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            JSONObject jObj = null;
            try {
                jObj = new JSONObject(buffer.toString());
            } catch (JSONException e) {
                Log.e("draw", "Error parsing data " + e.toString());
            }


            // return JSON Object
            return jObj;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}