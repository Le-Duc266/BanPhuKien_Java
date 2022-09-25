/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NhanVienDAO;
import entities.NhanVien;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */

public class KiemTraDangNhap {
    private NhanVienDAO nvdao;

    public KiemTraDangNhap() {
        nvdao = new NhanVienDAO();
    }
    
     public boolean check(HttpSession session){
         String name=(String) session.getAttribute("user");
           NhanVien nhanvien=nvdao.checkName(name);
        if(session.getAttribute("user") != null && nhanvien.getMaQuyen().getMaQuyen()==2 ){
            return true;
        }else {
            return false;
        }
    }
     
     public boolean checkAdmin(HttpSession session){
         String name=(String) session.getAttribute("user");
           NhanVien nhanvien=nvdao.checkName(name);
        if(session.getAttribute("user") != null && nhanvien.getMaQuyen().getMaQuyen()==1){
            // cái này là t để phân quyền đấy bạn nên t ms cop ra làm 2 cái
            return true;
        }else {
            return false;
        }
    }
}
