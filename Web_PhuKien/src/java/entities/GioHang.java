/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import unit.XuLyTien;

/**
 *
 * @author Admin
 */
public class GioHang {

    private int maSanPham;
    private String tenSanPham;
    private String anh;
    private double gia;
    private int soluong;

    public GioHang() {
    }

    public GioHang(int maSanPham, String tenSanPham, String anh, double gia, int soluong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.anh = anh;
        this.gia = gia;
        this.soluong = soluong;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double gia() {

        return this.gia;
    }

    public double tinhTongtien() {

        return this.gia * soluong;
    }

    public double thanhtien() {
        double thanhtien = 0;
        return thanhtien += tinhTongtien();
    }

    public String getTinhTongtien() {
        return XuLyTien.dinhDangTien1(tinhTongtien());
    }

    public String getGiaString() {
        return XuLyTien.dinhDangTien1(gia());
    }
}
