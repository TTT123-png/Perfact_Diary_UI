package com.example.tang;

public class HotConstructor {
    public int getStartimg() {
        return startimg;
    }

    public void setStartimg(int startimg) {
        this.startimg = startimg;
    }

    private int img;
    private String title;
    private int startimg;
    private int num;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



    public HotConstructor(int img, String title, int startimg, int num) {
        this.img = img;
        this.title = title;
        this.startimg = startimg;
        this.num = num;
    }

    public HotConstructor() {}

}
