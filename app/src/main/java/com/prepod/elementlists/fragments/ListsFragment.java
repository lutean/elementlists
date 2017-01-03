package com.prepod.elementlists.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.prepod.elementlists.R;
import com.prepod.elementlists.adapters.MainListAdapter;
import com.prepod.elementlists.containers.CardListItem;
import com.prepod.elementlists.containers.MainCard;
import com.prepod.elementlists.interfaces.OnCardListItemClickListener;
import com.prepod.elementlists.interfaces.OnQueryTextChangeListener;

import java.util.ArrayList;
import java.util.List;

public class ListsFragment extends Fragment implements OnCardListItemClickListener, OnQueryTextChangeListener{

    private RecyclerView mainRecycler;
    private MainListAdapter adapter;
    private List<MainCard> itemList = new ArrayList<>();
    private List<List<CardListItem>> cardList = new ArrayList<>();
    private OnCardListItemClickListener cardListener;
    private CoordinatorLayout coordinatorLayout;
    private List<MainCard> tempSearchCollection = new ArrayList<>();

    public ListsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lists, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.main_coordinator);

        mainRecycler = (RecyclerView) view.findViewById(R.id.main_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mainRecycler.setHasFixedSize(true);
        mainRecycler.setLayoutManager(layoutManager);
        initDummyData();
        adapter = new MainListAdapter(getActivity(), itemList, this);
        mainRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initDummyData(){
        MainCard card = new MainCard("First");
        List<CardListItem> tempList = new ArrayList<>();
        tempList.add(new CardListItem(R.mipmap.facebook, "Line 1", "Avaliable"));
        card.setCardListItem(tempList);
        itemList.add(card);


        MainCard cardSecond = new MainCard("Second");

        List<CardListItem> tempListAn = new ArrayList<>();
        tempListAn.add(new CardListItem(R.mipmap.google, "Line 1", "Avaliable"));
        tempListAn.add(new CardListItem(R.mipmap.youtube, "Line 2", "Avaliable"));
        cardSecond.setCardListItem(tempListAn);
        itemList.add(cardSecond);

    }

    private void showMessage(String msg){
        Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_LONG).show();
    }

    private void showPopUpMenu(View view){
        PopupMenu menu = new PopupMenu(getActivity(), view);
        menu.inflate(R.menu.popupmenu);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        menu.show();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cardListener = null;
    }

    @Override
    public void onItemClick(int position) {
        showMessage("Item clicked: " + position);
    }

    @Override
    public void onHeaderMenuClick(View v, int position) {
        showPopUpMenu(v);
    }

    @Override
    public void onHeaderContactClick(int position) {
        showMessage("Add contact");
    }

    @Override
    public void onHeaderPencilClick() {
        showMessage("Pencil clicked");
    }

    @Override
    public void onHeaderLockClick() {
        showMessage("Something locked");
    }

    @Override
    public void onQueryTextChange(String s) {
        int textLength = s.length();
        tempSearchCollection.clear();
        for (int i = 0; i < itemList.size(); i++) {

            if (textLength <= itemList.get(i).getTitle().length()) {
                if (itemList.get(i).getTitle().toLowerCase().contains(s.toLowerCase())) {
                    tempSearchCollection.add(itemList.get(i));
                }
            }

        }
        if (textLength == 0) {
            tempSearchCollection.clear();
            adapter = new MainListAdapter(getActivity(), itemList, this);
        } else
            adapter = new MainListAdapter(getActivity(), tempSearchCollection, this);

        mainRecycler.setAdapter(adapter);
    }
}
