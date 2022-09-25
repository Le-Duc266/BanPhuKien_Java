/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class BaseController {
    public String getCookie(HttpServletRequest req, HttpServletResponse res){
        Cookie[] cookies = req.getCookies();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("user")){
                return cooky.getValue();
            }
        }
        return null;
    }
}
