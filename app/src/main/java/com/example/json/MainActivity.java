package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


RecyclerView rv;
    ArrayList<String>names = new ArrayList<>();
    ArrayList<String> house = new ArrayList<>();
    ArrayList<String> science = new ArrayList<>();
    ArrayList<String> extra = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {

            JSONObject obj = new JSONObject(loadJsonfromAssets());
            JSONArray studarray = obj.getJSONArray("students");


            for (int i = 0; i < studarray.length(); i++) {

                JSONObject details = studarray.getJSONObject(i);
                names.add(details.getString("name"));
                house.add(details.getString("house"));
                JSONObject sci = details.getJSONObject("subjects");
                science.add(sci.getString("science"));
               // System.out.println("123" + details.getString("extras"));

                extra.add(details.getString("extras"));


                }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        CustomAdapter customAdapter = new CustomAdapter(names , house, science, extra , MainActivity.this);
        rv.setAdapter(customAdapter);



    }

    private String loadJsonfromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("users.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

           json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }




}