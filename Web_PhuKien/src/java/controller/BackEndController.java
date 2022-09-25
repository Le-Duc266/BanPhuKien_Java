/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NhanVienDAO;
import entities.NhanVien;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/admin")
public class BackEndController {

    private NhanVienDAO nhanviendao;

    public BackEndController() {
        nhanviendao = new NhanVienDAO();
    }
    
    

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpSession session) {
       if (check(session)) {
            return "admin/index";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/login")
    public String initBackendLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/adminLogin")
    public String loginBackend(NhanVien nhanvien, ModelMap mm, HttpSession session) {
        boolean result = false;

        result = nhanviendao.loginStudent(nhanvien);

        if (result) {

            session.setAttribute("user", nhanvien.getEmail());
            String name = (String) session.getAttribute("user");

            nhanvien = nhanviendao.checkName(name);
            session.setAttribute("useramin", nhanvien.getTenTaiKhoan());

            if (nhanvien.getMaQuyen().getMaQuyen() == 1 || nhanvien.getMaQuyen().getMaQuyen() == 2) {
                return "admin/index";
            }
            else {
                mm.put("message", "không có quyền.");
                return "admin/login";
            }

        } else {
            mm.put("message", "Sai thông tin đăng nhập.");
            return "admin/login";
        }

    }
    @RequestMapping(value = "/logoutBackend")
    public String logoutBackend( HttpSession session, ModelMap mm, HttpServletRequest request) {

        if (session.getAttribute("user") != null || session.getAttribute("useramin") != null) {
            session.removeAttribute("user");
            session.removeAttribute("useramin");
        }
        return "admin/login";
    }

    public boolean check(HttpSession session) {
        String name = (String) session.getAttribute("user");
        NhanVien nhanvien = nhanviendao.checkName(name);
        if (session.getAttribute("user") != null && nhanvien.getMaQuyen().getMaQuyen() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
