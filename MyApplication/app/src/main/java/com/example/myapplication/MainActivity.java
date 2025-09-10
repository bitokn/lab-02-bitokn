package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;


// make [ublic attribute of ''selected' item
// delete listener checks if the seleceted item public attribute is populated
// if selcted item is clicked public attribute is emptied ( so if delte button is presesed nothing happens)


public class MainActivity extends AppCompatActivity {

    // Declare the variables so that you will be able to reference it later.
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayAdapter<String> selectedCityAdapter;

    int selectedItemi = -1;
    Object selectedItemObj;

    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);



        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList); // 'adapts' the ArrayList into a ListView
        cityList.setAdapter(cityAdapter); // displays the adapter

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (selectedItemi == position) {
                    selectedItemi = -1;
                    selectedItemObj = dataList.get(position);
                    
                    cityList.setBackgroundColor(Color.WHITE); // Change an attribute of the object
                    cityList.setAdapter(cityAdapter); // displays the adapter
                } else {
                    selectedItemi = position;
                    cityList.setBackgroundColor(Color.BLUE); // Change an attribute of the object
                    cityList.setAdapter(cityAdapter); // displays the adapter
                }
            }
        });

        final Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemi != -1) {
                    String poppedElement = dataList.remove(selectedItemi);
                    selectedItemi = -1;

                }
                cityList.setAdapter(cityAdapter);
            }
        });
    }
}