package com.prepod.elementlists.activities;

import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prepod.elementlists.R;
import com.prepod.elementlists.fragments.ListsFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListsFragment listFragment = new ListsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, listFragment)
                .commit();

    }
}
