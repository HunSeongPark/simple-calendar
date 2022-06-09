package com.hunseong.calendar.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static com.hunseong.calendar.api.service.LoginService.LOGIN_SESSION_KEY;

/**
 * Created by Hunseong on 2022/06/09
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@RequestParam(required = false) String redirect, Model model, HttpSession session) {
        model.addAttribute("isSignIn", session.getAttribute(LOGIN_SESSION_KEY) != null);
        model.addAttribute("redirect", redirect);
        return "index";
    }
}
