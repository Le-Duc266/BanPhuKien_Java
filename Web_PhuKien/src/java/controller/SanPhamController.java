/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DanhMucDAO;
import dao.NhanHangDAO;
import dao.SanPhamDAO;
import entities.DanhMuc;
import entities.NhanHang;
import entities.SanPham;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("admin/sanpham")
public class SanPhamController {

    SanPhamDAO spd = null;
    NhanHangDAO nhd = null;
    DanhMucDAO dmd = null;

    public SanPhamController() {
        spd = new SanPhamDAO();
        nhd = new NhanHangDAO();
        dmd = new DanhMucDAO();
    }

    @RequestMapping(value = "danhsachsanpham", method = RequestMethod.GET)
    public String sanPhamView(Model model, HttpSession session, DanhMuc d, NhanHang nh) {
        model.addAttribute("sp", spd.getAlls());
        return "admin/sanpham/danhsachsanpham";
    }

    @RequestMapping(value = "/xoasanpham", method = RequestMethod.GET)
    public String xoaSanPham(int id) {
        spd.Delete(id);
        return "redirect:danhsachsanpham";
    }

    @RequestMapping(value = "/themmoisanpham", method = RequestMethod.GET)
    public String themSanPham(Model model, DanhMuc d, NhanHang nh) {
        SanPham s = new SanPham();
        model.addAttribute("s", s);
        model.addAttribute("dm", dmd.getAll());
        model.addAttribute("nh", nhd.getAll());
        return "admin/sanpham/themmoisanpham";
    }

    @RequestMapping(value = "/luusanpham", method = RequestMethod.POST)
    public String luuSanPham(MultipartFile productURL, Model model, HttpServletRequest request, @RequestParam int maSanPham, @RequestParam int maDanhMuc, @RequestParam int maNhanHang, DanhMuc d, NhanHang nh, @RequestParam int soLuong, @RequestParam String tenSanPham, @RequestParam Double gia, @RequestParam String moTa) {
        SanPham s = new SanPham();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String strDate = formatter.format(date);
        try {
            String uploadRootPath = request.getServletContext().getRealPath("/") + "resources/images/product/";
            File destination = new File(uploadRootPath + "/" + productURL.getOriginalFilename());
            productURL.transferTo(destination);
            s.setAnh(productURL.getOriginalFilename());
        } catch (IOException | IllegalStateException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.setMaSanPham(maSanPham);
        s.setTenSanPham(tenSanPham);
        d.setMaDanhMuc(maDanhMuc);
        s.setMaDanhMuc(d);
        nh.setMaNhanHang(maNhanHang);
        s.setMaNhanHang(nh);
        s.setGia(gia);
        s.setSoLuong(soLuong);
        s.setNgayTao(date);
        s.setMoTa(moTa);
        s.setAnh(productURL.getOriginalFilename());

        spd.Insert(s);
        return "redirect:danhsachsanpham";
    }

    @RequestMapping(value = "/initSanPham", method = RequestMethod.GET)
    public String sua(Model model, int maSanPham) {
        model.addAttribute("s", spd.getById(maSanPham));
        model.addAttribute("dm", dmd.getAll());
        model.addAttribute("nh", nhd.getAll());
        return "admin/sanpham/suasanpham";
    }

    @RequestMapping(value = "/suaSanPham", method = RequestMethod.POST)
    public String suaThongTin(MultipartFile productURL, HttpServletRequest request, Model model, @RequestParam int maSanPham, @RequestParam int maDanhMuc, @RequestParam int maNhanHang, DanhMuc d, NhanHang nh, @RequestParam int soLuong, @RequestParam String tenSanPham, @RequestParam Double gia, @RequestParam String anh, @RequestParam String moTa) {
        SanPham s = new SanPham();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String strDate = formatter.format(date);
        if (!productURL.isEmpty()) {
            try {
                String uploadRootPath = request.getServletContext().getRealPath("/") + "resources/images/product/";
                File destination = new File(uploadRootPath + "/" + productURL.getOriginalFilename());
                productURL.transferTo(destination);
                s.setAnh(productURL.getOriginalFilename());
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            s.setAnh(anh);
        }
        s.setMaSanPham(maSanPham);
        d.setMaDanhMuc(maDanhMuc);
        s.setMaDanhMuc(d);
        nh.setMaNhanHang(maNhanHang);
        s.setMaNhanHang(nh);
        s.setSoLuong(soLuong);
        s.setGia(gia);
        s.setNgayTao(date);
        s.setTenSanPham(tenSanPham);
        s.setMoTa(moTa);
        spd.Update(s);
        return "redirect:danhsachsanpham";
    }
}
