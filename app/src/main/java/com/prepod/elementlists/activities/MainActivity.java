package com.prepod.elementlists.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prepod.elementlists.R;
import com.prepod.elementlists.fragments.ListsFragment;
import com.prepod.elementlists.interfaces.OnCardListItemClickListener;

import java.util.List;

public class MainActivity extends AppCompatActivity{


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
