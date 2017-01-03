package com.prepod.elementlists.activities;

import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.prepod.elementlists.R;
import com.prepod.elementlists.fragments.ListsFragment;
import com.prepod.elementlists.interfaces.OnCardListItemClickListener;
import com.prepod.elementlists.interfaces.OnQueryTextChangeListener;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private SearchView searchView;
    private OnQueryTextChangeListener textChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListsFragment listFragment = new ListsFragment();

        textChangeListener = (OnQueryTextChangeListener) listFragment;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, listFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        final MenuItem myActionMenuItem = menu.findItem( R.id.action_search);

        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                textChangeListener.onQueryTextChange(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
