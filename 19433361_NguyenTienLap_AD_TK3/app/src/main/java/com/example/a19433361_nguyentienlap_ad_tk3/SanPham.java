package com.example.a19433361_nguyentienlap_ad_tk3;

public class SanPham {
    private int id;
    private int hinh;
    private String ten;
    private String gia;
    private String chatLieu;
    private String trongLuong;
    private String moTa;

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public SanPham(int id, int hinh, String ten, String gia, String chatLieu, String trongLuong, String moTa) {
        this.id = id;
        this.hinh = hinh;
        this.ten = ten;
        this.gia = gia;
        this.chatLieu = chatLieu;
        this.trongLuong = trongLuong;
        this.moTa = moTa;
    }
}
