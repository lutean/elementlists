package com.prepod.elementlists.containers;

import com.prepod.elementlists.R;

import java.util.ArrayList;
import java.util.List;

public class MainCard {

    private int imgRes;
    private int imgResSel;
    private String title;
    private List<CardListItem> cardListItem = new ArrayList<>();

    public MainCard(String title){
        this.imgRes = R.mipmap.win;
        this.imgResSel = R.mipmap.win_white;
        this.title = title;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgResSel() {
        return imgResSel;
    }

    public void setImgResSel(int imgResSel) {
        this.imgResSel = imgResSel;
    }

    public List<CardListItem> getCardListItem() {
        return cardListItem;
    }

    public void setCardListItem(List<CardListItem> cardListItem) {
        this.cardListItem = cardListItem;
    }
}


