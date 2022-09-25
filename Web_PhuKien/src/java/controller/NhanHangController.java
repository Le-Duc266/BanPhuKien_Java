/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NhanHangDAO;
import entities.NhanHang;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "admin/nhanhang")
public class NhanHangController {

    NhanHangDAO nhd = null;
    private KiemTraDangNhap kt;
    ServletContext servletContext;

    public NhanHangController() {
        nhd = new NhanHangDAO();
        kt = new KiemTraDangNhap();
    }

    @RequestMapping(value = "danhsachnhanhang", method = RequestMethod.GET)
    public String danhsach(Model model, HttpSession session) {
        if (kt.checkAdmin(session) ||kt.check(session)) {
            model.addAttribute("nh", nhd.getAll());
            return "admin/nhanhang/danhsachnhanhang";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "luuNhanhang", method = RequestMethod.POST)
    public String luu(Model model, NhanHang nh, HttpSession session) {
        if (nh.getMaNhanHang() == 0) {
            nhd.Insert(nh);
        } else {
            nhd.Update(nh);
        }
        return "redirect:danhsachnhanhang";
    }

    @RequestMapping(value = "xoaNhanhang", method = RequestMethod.GET)
    public String xoa(int id) {
        nhd.Delete(id);
        return "redirect:danhsachnhanhang";
    }

}
