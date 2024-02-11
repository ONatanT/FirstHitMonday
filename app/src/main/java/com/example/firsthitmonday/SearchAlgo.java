package com.example.firsthitmonday;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class SearchAlgo extends AppCompatActivity{
    private EditText editText;
    private EditText searchEditText;

    Button showSearchButton = findViewById(R.id.search_button);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.search_edit_text);
        // Set click listener for the show search button
        showSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSearchEditTextVisibility();
            }
        });
    }

    private void toggleSearchEditTextVisibility(){
        // Toggle visibility of the search EditText
        if (searchEditText.getVisibility() == View.VISIBLE) {
            searchEditText.setVisibility(View.GONE);
        } else {
            searchEditText.setVisibility(View.VISIBLE);
        }
    }

}
