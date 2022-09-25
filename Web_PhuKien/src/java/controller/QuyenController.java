/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuyenDAO;
import entities.Quyen;
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
@RequestMapping(value = "admin/quyen")
public class QuyenController {

    QuyenDAO qd = null;
    private KiemTraDangNhap kt;
    ServletContext servletContext;

    public QuyenController() {
        qd = new QuyenDAO();
        kt = new KiemTraDangNhap();
    }

    @RequestMapping(value = "danhsachquyen", method = RequestMethod.GET)
    public String danhsach(Model model, HttpSession session) {
         if (kt.checkAdmin(session)) {
        model.addAttribute("q", qd.getAll());
        return "admin/quyen/danhsachquyen";
        }else{
            return "admin/taikhoan/thongbao";
        }
    }

    @RequestMapping(value = "luuQuyen", method = RequestMethod.POST)
    public String luu(Model model, Quyen q, HttpSession session) {
        if (q.getMaQuyen() == 0) {
            qd.Insert(q);
        } else {
            qd.Update(q);
        }
        return "redirect:danhsachquyen";
    }

    @RequestMapping(value = "xoaQUyen", method = RequestMethod.GET)
    public String xoa(int id) {
        qd.Delete(id);
        return "redirect:danhsachquyen";
    }

}
