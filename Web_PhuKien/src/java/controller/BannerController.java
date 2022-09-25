/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import dao.BannerDAO;
import entities.Banner;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "admin/banner")
public class BannerController {

    private KiemTraDangNhap kt;
    ServletContext servletContext;
    BannerDAO bn = null;

    public BannerController() {
        bn = new BannerDAO();
        kt = new KiemTraDangNhap();
    }

    @RequestMapping(value = "danhsachBanner", method = RequestMethod.GET)
    public String BannerView(Model model, HttpSession session) {
         if (kt.checkAdmin(session) ||kt.check(session)) {
            model.addAttribute("bn", bn.getAlls());
            return "admin/banner/danhsachBanner";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }

    }

    @RequestMapping(value = "luuBanner", method = RequestMethod.POST)
    public String saveBanner(Banner b, MultipartFile anhBannerURL, HttpServletRequest request, HttpSession session) {
        if (kt.check(session)) {
            try {
                String uploadRootPath = request.getServletContext().getRealPath("/") + "resources/images/banner/";
                File destination = new File(uploadRootPath + "/" + anhBannerURL.getOriginalFilename());
                anhBannerURL.transferTo(destination);
                b.setAnh(anhBannerURL.getOriginalFilename());
            } catch (IOException | IllegalStateException ex) {
                Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (b.getMaBanner() == 0) {
                bn.Insert(b);
            } else {

                bn.Update(b);
            }
            return "redirect:danhsachBanner";
        } else {
            session.removeAttribute("user");
            return "admin/login";
        }
    }

    @RequestMapping(value = "/xoaBanner", method = RequestMethod.POST)
    public String deleteAnh(int maAnh, String tenAnhCu, HttpServletRequest req, HttpSession session) {

        bn.Delete(maAnh);

        String uploadRootPath = req.getServletContext().getRealPath("/") + "resources/images/banner/";
        File filecu = new File(uploadRootPath + "\\" + tenAnhCu);
        if (filecu.exists()) {
            filecu.delete();
        }
        return "redirect:danhsachBanner";

    }
}
