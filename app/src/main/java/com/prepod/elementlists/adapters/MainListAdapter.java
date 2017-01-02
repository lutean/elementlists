package com.prepod.elementlists.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private int selectedItem = -1;

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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (selectedItem == position){
            holder.mainHeaderSel.setVisibility(View.VISIBLE);
            holder.mainHeader.setVisibility(View.INVISIBLE);
        } else {
            holder.mainHeaderSel.setVisibility(View.INVISIBLE);
            holder.mainHeader.setVisibility(View.VISIBLE);
        }
        holder.titleIcon.setImageResource(itemList.get(position).getImgRes());
        holder.titleIconSel.setImageResource(itemList.get(position).getImgResSel());
        holder.title.setText(itemList.get(position).getTitle());
        holder.titleSel.setText(itemList.get(position).getTitle());
        holder.cardRecycelr.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.cardRecycelr.setLayoutManager(layoutManager);
        final CardListAdapter adapter = new CardListAdapter(context, cardListItems.get(position), listener);
        holder.cardRecycelr.setAdapter(adapter);

//        holder.mainCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectedItem = holder.getAdapterPosition();
//                notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView titleIcon;
        ImageView titleIconSel;
        TextView title;
        TextView titleSel;
        RecyclerView cardRecycelr;
        LinearLayout mainCard;
        LinearLayout mainHeader;
        LinearLayout mainHeaderSel;
        ImageView headerContact;
        ImageView headerPencil;
        ImageView headerLock;

        public ViewHolder(View itemView) {
            super(itemView);
            titleIcon = (ImageView) itemView.findViewById(R.id.title_icon);
            titleIconSel = (ImageView) itemView.findViewById(R.id.title_icon_sel);
            title = (TextView) itemView.findViewById(R.id.header_text);
            titleSel = (TextView) itemView.findViewById(R.id.header_text_sel);
            cardRecycelr = (RecyclerView) itemView.findViewById(R.id.card_recycler);
            mainCard = (LinearLayout) itemView.findViewById(R.id.main_card);
            mainHeader = (LinearLayout) itemView.findViewById(R.id.main_header);
            mainHeaderSel = (LinearLayout) itemView.findViewById(R.id.main_header_sel);
            headerContact = (ImageView) itemView.findViewById(R.id.header_contact);
            headerPencil = (ImageView) itemView.findViewById(R.id.header_pen);
            headerLock = (ImageView) itemView.findViewById(R.id.header_lock);
            mainCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedItem = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
            headerContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onHeaderContactClick(getAdapterPosition());
                }
            });
            headerPencil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPencilClick();
                }
            });
            headerLock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onLockClick();
                }
            });
        }
    }
}
