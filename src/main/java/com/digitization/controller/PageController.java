package com.digitization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/***
 * 页面转发控制器
 */
@Controller
public class PageController {

    /**
     * 页面转发
     */
    @GetMapping({"/"})
    public String login() {
        return "login";
    }

    /**
     * 页面转发
     */
    @GetMapping({"/to/{pageName}"})
    public String page(@PathVariable String pageName) {
        return pageName;
    }
}