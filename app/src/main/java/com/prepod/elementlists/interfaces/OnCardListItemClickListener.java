package com.prepod.elementlists.interfaces;

import android.view.View;

public interface OnCardListItemClickListener {
    void onItemClick(int position);
    void onHeaderMenuClick(View v, int position);
    void onHeaderContactClick(int position);
    void onHeaderPencilClick();
    void onHeaderLockClick();
}
