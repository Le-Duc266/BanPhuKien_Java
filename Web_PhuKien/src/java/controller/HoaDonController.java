/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HoaDonDAO;
import entities.HoaDon;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "admin/hoadon")
public class HoaDonController {

    private KiemTraDangNhap kt;
    ServletContext servletContext;
    HoaDonDAO hdao = null;

    public HoaDonController() {
        hdao = new HoaDonDAO();
        kt = new KiemTraDangNhap();
    }

    @RequestMapping(value = "danhsachdonhang", method = RequestMethod.GET)
    public String sanPhamView(Model model, HttpSession session) {
        if (kt.checkAdmin(session) ||kt.check(session)) {
            model.addAttribute("hd", hdao.getAll());
            return "admin/hoadon/danhsachdonhang";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "chitiethodon", method = RequestMethod.GET)
    public String chitiethodon(Model model, int maHoaDon, HttpSession session) {
       if (kt.checkAdmin(session) ||kt.check(session)) {
            model.addAttribute("a", hdao.getByIdChiTietHD(maHoaDon));
            System.out.println(hdao.getByIdChiTietHD(maHoaDon));
            return "admin/hoadon/chitiethoadon";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "cap-nhat-tinh-trang")
    @ResponseBody
    public Boolean updatetintrang(@RequestParam int maHoaDon, @RequestParam int tinhTrang, ModelMap mm, HttpSession session) {

        HoaDon hoaDon = hdao.detail(maHoaDon);
        if (tinhTrang == 1) {
            hoaDon.setTinhTrang(2);
        } else if (tinhTrang == 2) {
            hoaDon.setTinhTrang(3);
        }
        boolean result = hdao.UpdateStatus(hoaDon);
        return result;

    }

    @RequestMapping(value = "don-hang-da-duyet", method = RequestMethod.GET)
    public String donHangDaDuyet(Model model, HttpSession session) {
        if (kt.checkAdmin(session) ||kt.check(session)) {
            List<HoaDon> list = hdao.getHoadonDaDuyet();
            model.addAttribute("hd", list);
            return "admin/hoadon/donhangdaduyet";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

}
