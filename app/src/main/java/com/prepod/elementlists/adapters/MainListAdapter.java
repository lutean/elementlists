package com.prepod.elementlists.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prepod.elementlists.R;
import com.prepod.elementlists.containers.MainCard;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private List<MainCard> itemList;
    private Context context;

    public MainListAdapter(Context context, List<MainCard> itemList){
        this.context = context;
        this.itemList = itemList;
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
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView titleIcon;
        ImageView titleIconSel;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            titleIcon = (ImageView) itemView.findViewById(R.id.title_icon);
            titleIconSel = (ImageView) itemView.findViewById(R.id.title_icon_sel);
            title = (TextView) itemView.findViewById(R.id.header_text);
        }
    }
}
