package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private ArrayList<DataModel> dataSet;

    private CustomAdapter adapter;

    private Animation scale;

    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.res);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dataSet = new ArrayList<>();

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchView = findViewById(R.id.SearchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredList(newText);
                return true;
            }
        });

        scale = AnimationUtils.loadAnimation(this, R.anim.animations);


        for (int i = 0; i< MyData.drawableArray.length; i++)
        {
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.descriptionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }
        adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);
    }

    private void filteredList(String text) {
        ArrayList<DataModel> filteredlist = new ArrayList<>();
        for (DataModel item : dataSet) {
            if (item.getName().toLowerCase().contains(text.toLowerCase()))
            {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this,"Not found this name",Toast.LENGTH_LONG).show();
        }
        else adapter.setFilteredList(filteredlist);
    }

}