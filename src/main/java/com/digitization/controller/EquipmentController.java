package com.digitization.controller;

import com.digitization.common.JsonResult;
import com.digitization.dal.entry.EquipmentEntry;
import com.digitization.model.AjaxModel;
import com.digitization.service.inter.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.BeanParam;

/**
 * 设备控制器
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController extends AjaxModel {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping({"/add"})
    public void add(@BeanParam EquipmentEntry equipmentEntry) {
        equipmentService.add(equipmentEntry);
        this.print(JsonResult.getSuccess(null));
    }

    @PostMapping({"/delete/{id}"})
    public void add(@PathVariable Integer id) {
        equipmentService.delete(id);
        this.print(JsonResult.getSuccess(null));
    }

    @GetMapping({"/query"})
    public void query(@BeanParam EquipmentEntry equipmentEntry) {
        this.print(JsonResult.getSuccess(equipmentService.query(equipmentEntry)));
    }
}
