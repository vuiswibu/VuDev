package com.huynhnamvu.custom_list_view_2;

public class MonAn {
    private String monAn;
    private double donGia;
    private String moTa;
    private int image;

    public MonAn(String monAn, double donGia, String moTa, int image) {
        this.monAn = monAn;
        this.donGia = donGia;
        this.moTa = moTa;
        this.image = image;
    }

    public String getMonAn() {
        return monAn;
    }

    public void setMonAn(String monAn) {
        this.monAn = monAn;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
