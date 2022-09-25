/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DanhMucDAO;
import entities.DanhMuc;
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
@RequestMapping(value = "admin/category")
public class DanhMucController {

    private KiemTraDangNhap kt;
    ServletContext servletContext;
    DanhMucDAO dm = null;

    public DanhMucController() {
        dm = new DanhMucDAO();
        kt = new KiemTraDangNhap();
    }

    @RequestMapping(value = "listCate", method = RequestMethod.GET)
    public String danhsach(Model model, HttpSession session) {
        if (kt.checkAdmin(session) ||kt.check(session)) {
            model.addAttribute("danhmuc", dm.getAll());
            return "admin/category/listCate";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "saveCate", method = RequestMethod.POST)
    public String luu(Model model, DanhMuc d, HttpSession session) {
        if (d.getMaDanhMuc() == 0) {
            dm.Insert(d);
        } else {
            dm.Update(d);
        }
        return "redirect:listCate";
    }

    @RequestMapping(value = "deleteCate", method = RequestMethod.GET)
    public String xoa(int id) {
        dm.Delete(id);
        return "redirect:listCate";
    }

}
