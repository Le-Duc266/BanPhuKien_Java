/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TaiKhoanDAO;
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
@RequestMapping("admin/taikhoan")
public class TaiKhoanController {
     private KiemTraDangNhap kt;
    ServletContext servletContext;
    TaiKhoanDAO tk = null;

    public TaiKhoanController() {
        tk = new TaiKhoanDAO();
        kt = new KiemTraDangNhap();
    }
    
    @RequestMapping(value = "danhsachnguoidung", method = RequestMethod.GET)
    public String nguoiDungView(Model model, HttpSession session) {
        if (kt.checkAdmin(session)) {
        model.addAttribute("tk", tk.getNguoiDung());
        return "admin/taikhoan/nguoidung";
        }else{
            return "admin/taikhoan/thongbao";
        }
    }
    
    @RequestMapping(value = "danhsachnhanvien", method = RequestMethod.GET)
    public String nhanVienView(Model model, HttpSession session) {
        if (kt.checkAdmin(session)) {
        model.addAttribute("tk", tk.getNhanVien());
        return "admin/taikhoan/nhanvien";
        }else{
            return "admin/taikhoan/thongbao";
        }
    }
}
