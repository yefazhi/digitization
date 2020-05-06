package com.digitization.controller;

import com.digitization.common.JsonResult;
import com.digitization.dal.entry.TechnologyEntry;
import com.digitization.model.AjaxModel;
import com.digitization.service.inter.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BeanParam;

/**
 * 工艺信息控制器
 */
@RestController
@RequestMapping("/technology")
public class TechnologyController extends AjaxModel {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping({"/add"})
    public void add(@BeanParam TechnologyEntry technologyEntry) {
        technologyService.add(technologyEntry);
        this.print(JsonResult.getSuccess(null));
    }

    @PostMapping({"/delete/{id}"})
    public void add(@PathVariable Integer id) {
        technologyService.delete(id);
        this.print(JsonResult.getSuccess(null));
    }

    @GetMapping({"/query"})
    public void query(@BeanParam TechnologyEntry technologyEntry) {
        this.print(JsonResult.getSuccess(technologyService.query(technologyEntry)));
    }
}
