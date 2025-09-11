package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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

// Notes:
// make public attribute of 'selected' item
// delete listener checks if the seleceted item public attribute is populated
// if selcted item is clicked public attribute is emptied ( so if delte button is presesed nothing happens)


public class MainActivity extends AppCompatActivity {

    // Declare the variables so that you will be able to reference it later.
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    int selectedItemi = -1;
    long list_content;
    View selectedItemView;


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
                // Reset previous selection (if any)
                if (selectedItemView != null) {
                    selectedItemView.setBackgroundColor(Color.WHITE);
                }
                // Set new selection
                //view.setBackgroundColor(Color.BLUE);
                //selectedItemView = view; // Store the currently selected view
                if (selectedItemi == position) {
                    selectedItemi = -1;
                    // selectedItemView.setBackgroundColor(Color.WHITE);
                } else {
                    selectedItemi = position;
                    view.setBackgroundColor(Color.LTGRAY);
                    selectedItemView = view;

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
