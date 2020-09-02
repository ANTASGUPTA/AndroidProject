package com.antasgupta.Programming_Languages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class Programming_Languages extends AppCompatActivity {

    String text[]= {"C","C SHARP", "JAVA", "JAVASCRIPT", "KOTLIN", "PYTHON", "R", "RUBY",
            "HTML", "CSS", "ANGULAR JS", "SQL", "SWIFT", "PERL", "RUST", "TYPESCRIPT", "FLUTTER"};

//    String text1[]= {"C","C SHARP", "JAVA", "JAVASCRIPT", "KOTLIN", "PYTHON", "R", "RUBY",
//            "HTML", "CSS", "ANGULAR JS", "SQL", "SWIFT", "PERL", "RUST", "TYPESCRIPT", "FLUTTER"};

    int images[] ={R.drawable.image_1, R.drawable.image_2,R.drawable.image_3, R.drawable.image_4,
            R.drawable.image_5, R.drawable.image_6, R.drawable.image_7,R.drawable.image_8,
            R.drawable.image_9,R.drawable.image_10,R.drawable.image_11, R.drawable.image_12,
            R.drawable.image_13, R.drawable.image_14,R.drawable.image_15, R.drawable.image_16,
            R.drawable.image_17} ;

    List<String> namelist;


    RecyclerView recyclerView;
    MyAdapter adapter;
    MyAdapter adapter1;
    Filter getresult();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namelist = new ArrayList<>();
        adapter1 = new MyAdapter(namelist);

        namelist.add("C");namelist.add("C SHARP"); namelist.add("JAVA"); namelist.add("JAVASCRIPT"); namelist.add("KOTLIN");
        namelist.add("PYTHON"); namelist.add("R"); namelist.add("RUBY"); namelist.add("HTML");


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
        adapter = new MyAdapter(text, images);
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                MyAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}