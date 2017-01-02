package com.prepod.elementlists.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prepod.elementlists.R;
import com.prepod.elementlists.adapters.MainListAdapter;
import com.prepod.elementlists.containers.CardListItem;
import com.prepod.elementlists.containers.MainCard;
import com.prepod.elementlists.interfaces.OnCardListItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mainRecycler;
    private MainListAdapter adapter;
    private List<MainCard> itemList = new ArrayList<>();
    private List<List<CardListItem>> cardList = new ArrayList<>();

    public ListsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListsFragment newInstance(String param1, String param2) {
        ListsFragment fragment = new ListsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lists, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainRecycler = (RecyclerView) view.findViewById(R.id.main_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mainRecycler.setHasFixedSize(true);
        mainRecycler.setLayoutManager(layoutManager);
        initDummyData();
        adapter = new MainListAdapter(getActivity(), itemList, cardList, new OnCardListItemClickListener() {
            @Override
            public void OnItemClicked(int position) {

            }
        });
        mainRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initDummyData(){
        MainCard card = new MainCard("First");
        itemList.add(card);
        MainCard cardSecond = new MainCard("Second");
        itemList.add(cardSecond);

        List<CardListItem> tempList = new ArrayList<>();
        tempList.add(new CardListItem(R.mipmap.facebook, "Line 1", "Avaliable"));
        cardList.add(tempList);

        List<CardListItem> tempListAn = new ArrayList<>();
        tempListAn.add(new CardListItem(R.mipmap.google, "Line 1", "Avaliable"));
        tempListAn.add(new CardListItem(R.mipmap.youtube, "Line 2", "Avaliable"));
        cardList.add(tempListAn);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
