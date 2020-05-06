package com.digitization.controller;

import com.digitization.common.JsonResult;
import com.digitization.dal.entry.WorkpieceEntry;
import com.digitization.model.AjaxModel;
import com.digitization.service.inter.WorkpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BeanParam;

/**
 * 工件信息控制器
 */
@RestController
@RequestMapping("/workpiece")
public class WorkpieceController extends AjaxModel {

    @Autowired
    private WorkpieceService workpieceService;

    @PostMapping({"/add"})
    public void add(@BeanParam WorkpieceEntry workpieceEntry) {
        workpieceService.add(workpieceEntry);
        this.print(JsonResult.getSuccess(null));
    }

    @PostMapping({"/delete/{id}"})
    public void add(@PathVariable Integer id) {
        workpieceService.delete(id);
        this.print(JsonResult.getSuccess(null));
    }

    @GetMapping({"/query"})
    public void query(@BeanParam WorkpieceEntry workpieceEntry) {
        this.print(JsonResult.getSuccess(workpieceService.query(workpieceEntry)));
    }

}
