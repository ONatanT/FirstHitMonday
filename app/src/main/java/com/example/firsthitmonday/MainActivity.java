package com.example.firsthitmonday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.text.TextWatcher;
import android.text.Editable;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> searchResults;

    private CustomeAdapter adapter;
    private EditText searchEditText;
    private Button showSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.res);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dataSet = new ArrayList<>();
        searchResults = new ArrayList<>();
        showSearchButton = findViewById(R.id.search_button);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for ( int i = 0 ; i < MyData.drawableArray.length ; i++){

            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.textArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }

        // Initialize searchResult with the entire dataset
        searchResults.addAll(dataSet);
        searchEditText = findViewById(R.id.search_edit_text);

        // Set up the RecyclerView adapter with the initial dataset
        adapter = new CustomeAdapter(searchResults);
        recyclerView.setAdapter(adapter);


        // Add a TextWatcher to the search EditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed before text changes
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Update the filteredData based on the search input
                searchResults(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No action needed after text changes
            }
        });

        showSearchButton.setOnClickListener(v -> toggleSearchEditTextVisibility());

    }

    private void toggleSearchEditTextVisibility(){
        // Toggle visibility of the search EditText
        if (searchEditText.getVisibility() == View.VISIBLE) {

            searchEditText.setVisibility(View.GONE);
        } else {
            searchEditText.setVisibility(View.VISIBLE);
        }
    }

    private void searchResults(String query) {
        searchResults.clear();

        // Filter the dataset based on the search query
        for (DataModel data : dataSet) {
            String name = data.getName();
            String text = data.getText();

            // Check for null values before calling toLowerCase()
            if ((name != null && name.toLowerCase().contains(query.toLowerCase())) ||
                    (text != null && text.toLowerCase().contains(query.toLowerCase()))) {
                searchResults.add(data);
            }
        }
        // Notify the adapter about the changes
        adapter.notifyDataSetChanged();

    }

//    jskdsdjlkfsjldkfj skdlfjlskjdflk
}





