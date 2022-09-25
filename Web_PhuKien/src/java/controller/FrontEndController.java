/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDAO;
import dao.DanhMucDAO;
import dao.HoaDonDAO;
import dao.NhanHangDAO;
import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import entities.Banner;
import entities.DanhMuc;
import entities.GioHang;
import entities.HoaDon;
import entities.HoaDonChiTiet;
import entities.NguoiDung;
import entities.NhanHang;
import entities.NhanVien;
import entities.SanPham;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Admin
 */
@Controller
public class FrontEndController extends BaseController {
    
    DanhMucDAO dmuc = null;
    SanPhamDAO spdao = null;
    HoaDonDAO hdao = null;
    BannerDAO bndao = null;
    NhanHangDAO nhdao = null;
    TaiKhoanDAO tkdao = null;
    
    public FrontEndController() {
        dmuc = new DanhMucDAO();
        spdao = new SanPhamDAO();
        hdao = new HoaDonDAO();
        bndao = new BannerDAO();
        nhdao = new NhanHangDAO();
        tkdao = new TaiKhoanDAO();
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
        String currentUser = getCookie(req, res);
        
        session.setAttribute("danhmuc", dmuc.getAll());
        List<DanhMuc> danhmuc = dmuc.getAll();
        List<SanPham> spall = spdao.getAlls();
        List<Banner> banners = bndao.getAlls();
        model.addAttribute("banners", banners);
        model.addAttribute("spall", spall);
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int so = 0;
            for (GioHang list1 : list) {
                so += list1.getSoluong();
            }
            model.addAttribute("so", so);
        }
        req.setAttribute("currentUser", currentUser);
        
        return "frontend/index";
    }
    
    @RequestMapping(value = "lien-he", method = RequestMethod.GET)
    public String lienHe(Model model, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
        String currentUser = getCookie(req, res);
        session.setAttribute("danhmuc", dmuc.getAll());
        List<DanhMuc> danhmuc = dmuc.getAll();
        List<SanPham> spall = spdao.getAlls();
        List<Banner> banners = bndao.getAlls();
        model.addAttribute("banners", banners);
        model.addAttribute("spall", spall);
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int so = 0;
            for (GioHang list1 : list) {
                so += list1.getSoluong();
            }
            model.addAttribute("so", so);
        }
        req.setAttribute("currentUser", currentUser);
        
        return "frontend/lienhe";
    }
    
    @RequestMapping(value = "/san-pham", method = RequestMethod.GET)
    public String sanpham(Model model, HttpSession session,HttpServletRequest req, HttpServletResponse res) {
         String currentUser = getCookie(req, res);
        session.setAttribute("danhmuc", dmuc.getAll());
        
        List<DanhMuc> danhmuc = dmuc.getAll();
        List<SanPham> spall = spdao.getAlls();
        List<Banner> banners = bndao.getAlls();
        model.addAttribute("banners", banners);
        model.addAttribute("spall", spall);
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int so = 0;
            for (GioHang list1 : list) {
                so += list1.getSoluong();
            }
            model.addAttribute("so", so);
        }
        req.setAttribute("currentUser", currentUser);
        return "frontend/sanpham";
    }
    
    @RequestMapping(value = "/chi-tiet", method = RequestMethod.GET)
    public String sanPhamChiTiet(Model model, ModelMap modelMap, HttpSession session, int maSanPham, DanhMuc dm,HttpServletRequest req, HttpServletResponse res) {
        String currentUser = getCookie(req, res);
        model.addAttribute("s", spdao.getById(maSanPham));
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            modelMap.addAttribute("slgiohang", list.size());
        }
        List<SanPham> spall = spdao.getAlls();
        List<DanhMuc> danhmuc = dmuc.getAll();
        session.setAttribute("danhmuc", dmuc.getAll());
        model.addAttribute("spall", spall);
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int so = 0;
            for (GioHang list1 : list) {
                so += list1.getSoluong();
            }
            model.addAttribute("so", so);
        }
         req.setAttribute("currentUser", currentUser);
        return "frontend/sanphamchitiet";
    }
    
    @RequestMapping(value = "/tim-kiem", method = RequestMethod.POST)
    public String SearchName(HttpServletRequest request, @RequestParam("ten") String ten, @ModelAttribute SanPham sanPham, ModelMap model) {
        List<SanPham> lstsanPhams = spdao.searchByName(ten);
        if (lstsanPhams == null) {
            return "frontend/sanpham";
        } else {
            model.addAttribute("spall", lstsanPhams);
            return "frontend/sanpham";
        }
    }
    
    @RequestMapping(value = "/them-gio-hang", method = RequestMethod.GET)
    @ResponseBody
    public void themGioHang(Model model, HttpSession session, @RequestParam int maSanPham, @RequestParam String tenSanPham, @RequestParam double gia, @RequestParam int soLuong, @RequestParam String anh) {
        if (null == session.getAttribute("giohang")) {
            List<GioHang> listgiohang = new ArrayList<>();
            GioHang ghang = new GioHang();
            ghang.setMaSanPham(maSanPham);
            ghang.setTenSanPham(tenSanPham);
            ghang.setGia(gia);
            ghang.setSoluong(soLuong);
            listgiohang.add(ghang);
            session.setAttribute("giohang", listgiohang);
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            
        } else {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int vitri = kiemtraSanPham(list, session, maSanPham);
            if (vitri == -1) {
                GioHang ghang = new GioHang();
                ghang.setMaSanPham(maSanPham);
                ghang.setTenSanPham(tenSanPham);
                ghang.setGia(gia);
                ghang.setSoluong(soLuong);
                list.add(ghang);
            } else {
                int soluongmoi = list.get(vitri).getSoluong() + soLuong;
                list.get(vitri).setSoluong(soluongmoi);
            }
        }
        List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
        
    }
    
    @RequestMapping(value = "/cap-nhap-gio-hang", method = RequestMethod.GET)
    @ResponseBody
    public void suaGioHang(HttpSession session, @RequestParam int soLuong, @RequestParam int maSanPham) {
        
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int vitri = kiemtraSanPham(list, session, maSanPham);
            list.get(vitri).setSoluong(soLuong);
        }
    }
    
    private int kiemtraSanPham(List<GioHang> listgiohang, HttpSession session, int maSanPham) {
        for (int i = 0; i < listgiohang.size(); i++) {
            if (listgiohang.get(i).getMaSanPham() == maSanPham) {
                return i;
            }
        }
        return -1;
    }
    
    @RequestMapping(value = "/lay-so-luong", method = RequestMethod.GET)
    @ResponseBody
    public String laySoLuong(HttpSession session) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int so = 0;
            for (GioHang list1 : list) {
                so += list1.getSoluong();
            }
            return so + "";
        }
        return "";
    }
    
    @RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
    public String gioHang(Model model, HttpSession session, GioHang gh, ModelMap modelMap,HttpServletRequest req, HttpServletResponse res) {
       
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            
            modelMap.addAttribute("giohang", list);
            int so = 0;
            double tongtien = 0;
            for (GioHang list1 : list) {
                so += list1.getSoluong();
                tongtien += list1.thanhtien();
            }
            model.addAttribute("tongtien", tongtien);
            model.addAttribute("so", so);
        }
        return "frontend/cart";
    }
    
    @RequestMapping(value = "/hoa-don", method = RequestMethod.GET)
    public String hoaDon(Model model, HttpSession session) {
        if (check(session)) {
            if(session.getAttribute("user")!=null){
            if (null != session.getAttribute("giohang")) {
                String name = (String) session.getAttribute("user");
                NguoiDung nd = tkdao.checkName(name);
                List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
                Date date = new Date();
                double _TongTien = 0;
                for (GioHang item : list) {
                    _TongTien += item.getGia() * item.getSoluong();
                }
                HoaDon hd = new HoaDon();
                hd.setDiaChi(nd.getDiaChi());
                hd.setNgayLap(date);
                hd.setTinhTrang(1);
                hd.setTongTien(_TongTien);
                hd.setMaTaiKhoanND(nd);
                if (hdao.Insert(hd)) {
                    System.out.println("them thanh cong");
                } else {
                    System.out.println("them that bai");
                }
                for (GioHang item : list) {
                    HoaDonChiTiet hdct = new HoaDonChiTiet();
                    hdct.setMaHoaDon(hdao.getHoaDonLatest());
                    hdct.setGiaTien(item.getGia());
                    hdct.setMaSanPham(spdao.getById(item.getMaSanPham()));
                    hdct.setSoLuong(item.getSoluong());
                    hdct.setThanhTien(item.getSoluong() * item.gia());
                    hdao.Insertchitiet(hdct);
                }
            }
            return "redirect:/san-pham";}
            else{
                 return "redirect:dang-nhap";
            }
        } else {
            session.removeAttribute("user");
            return "redirect:dang-nhap";
        }
        
    }
    
    @RequestMapping(value = "/xoa-gio-hang", method = RequestMethod.GET)
    public void xoaGioHang(HttpSession session, @RequestParam int maSanPham) {
        if (null != session.getAttribute("giohang")) {
            List<GioHang> list = (List<GioHang>) session.getAttribute("giohang");
            int vitri = kiemtraSanPham(list, session, maSanPham);
            list.remove(vitri);
        }
    }
    
    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public String dangKy(Model model, HttpSession session, NguoiDung nd) {
        return "frontend/dangky";
    }
    
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
    public String dangNhap(Model model, HttpSession session, NguoiDung nd) {
        return "frontend/dangnhap";
    }
    
    @RequestMapping(value = "/danh-nhap-nguoi-dung")
    public String loginBackend(NguoiDung nd, ModelMap mm, HttpSession session, HttpServletResponse res, HttpServletRequest req) {
        boolean result = false;
        result = tkdao.dangNhap(nd);
        if (result) {
            session.setAttribute("user", nd.getEmail());
            String name = (String) session.getAttribute("user");
            nd = tkdao.checkName(name);
            Cookie cookie = new Cookie("user", nd.getEmail());
            cookie.setMaxAge(8000);
            res.addCookie(cookie);
            req.setAttribute("currentUser", nd.getEmail());
            return "redirect:/gio-hang";
        } else {
            mm.put("message", "Sai thông tin đăng nhập.");
            return "frontend/dangnhap";
        }
    }
    
    @RequestMapping(value = "/dang-xuat")
    public String logoutBackend(HttpSession session, HttpServletResponse res, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("user")) {
                cooky.setMaxAge(0);
                res.addCookie(cooky);
            }
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = "/luu-tai-khoan", method = RequestMethod.POST)
    public String luutaikhoan(Model model, HttpSession session, NguoiDung nd) {
        tkdao.insertTaiKhoanNguoiDung(nd);
        return "redirect:/san-pham";
    }
    
    public boolean check(HttpSession session) {
        String name = (String) session.getAttribute("user");
        NguoiDung nd = tkdao.checkName(name);
        if (session.getAttribute("user") != null) {
            return true;
        } else {
            return false;
        }
    }
}
