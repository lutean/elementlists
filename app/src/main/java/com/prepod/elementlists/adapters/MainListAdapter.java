package com.prepod.elementlists.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prepod.elementlists.R;
import com.prepod.elementlists.containers.CardListItem;
import com.prepod.elementlists.containers.MainCard;
import com.prepod.elementlists.interfaces.OnCardListItemClickListener;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private List<MainCard> itemList;
    private List<List<CardListItem>> cardListItems;
    private Context context;
    private OnCardListItemClickListener listener;

    public MainListAdapter(Context context, List<MainCard> itemList, List<List<CardListItem>> cardListItems, OnCardListItemClickListener listener){
        this.context = context;
        this.itemList = itemList;
        this.cardListItems = cardListItems;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleIcon.setImageResource(itemList.get(position).getImgRes());
        holder.titleIconSel.setImageResource(itemList.get(position).getImgResSel());
        holder.title.setText(itemList.get(position).getTitle());
        holder.cardRecycelr.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.cardRecycelr.setLayoutManager(layoutManager);
        CardListAdapter adapter = new CardListAdapter(context, cardListItems.get(position), listener);
        holder.cardRecycelr.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView titleIcon;
        ImageView titleIconSel;
        TextView title;
        RecyclerView cardRecycelr;

        public ViewHolder(View itemView) {
            super(itemView);
            titleIcon = (ImageView) itemView.findViewById(R.id.title_icon);
            titleIconSel = (ImageView) itemView.findViewById(R.id.title_icon_sel);
            title = (TextView) itemView.findViewById(R.id.header_text);
            cardRecycelr = (RecyclerView) itemView.findViewById(R.id.card_recycler);
        }
    }
}
