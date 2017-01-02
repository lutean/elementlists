package com.prepod.elementlists.containers;

public class CardListItem {

    private int imgRes;
    private String title;
    private String status;

    public CardListItem(int imgRes, String title, String status){
        this.imgRes = imgRes;
        this.title = title;
        this.status = status;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
