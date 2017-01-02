package com.prepod.elementlists.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prepod.elementlists.R;
import com.prepod.elementlists.containers.CardListItem;
import com.prepod.elementlists.interfaces.OnCardListItemClickListener;

import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder>{

    private Context context;
    private List<CardListItem> itemsList;
    private OnCardListItemClickListener listener;

    public CardListAdapter(Context context, List<CardListItem> itemsList, OnCardListItemClickListener listener){
        this.context = context;
        this.itemsList = itemsList;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemIcon.setImageResource(itemsList.get(position).getImgRes());
        holder.itemTitle.setText(itemsList.get(position).getTitle());
        holder.itemStatus.setText(itemsList.get(position).getStatus());
        holder.cardListItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnItemClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView itemIcon;
        TextView itemTitle;
        TextView itemStatus;
        LinearLayout cardListItemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemIcon = (ImageView) itemView.findViewById(R.id.card_list_icon);
            itemTitle = (TextView) itemView.findViewById(R.id.card_list_text);
            itemStatus = (TextView) itemView.findViewById(R.id.card_list_status);
            cardListItemLayout = (LinearLayout) itemView.findViewById(R.id.card_list_layout);
        }
    }
}
