package com.digitization.controller;

import com.digitization.common.JsonResult;
import com.digitization.model.AjaxModel;
import com.digitization.service.impl.MatlabService;
import com.digitization.service.inter.TaskHistoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 调度任务控制器
 */
@RestController
@RequestMapping("/task")
public class TaskController extends AjaxModel {

    @Autowired
    MatlabService matlabService;

    @Autowired
    private TaskHistoryService taskHistoryService;

    /**
     * 开启任务，返回任务编号
     */
    @PostMapping({"/start"})
    public void start() {
        this.print(JsonResult.getSuccess(matlabService.run()));
    }

    @GetMapping({"/query/{taskId}"})
    public void query(@PathVariable String taskId) {
        if (StringUtils.isBlank(taskId) || StringUtils.equals("ALL", taskId)) {
            this.print(JsonResult.getSuccess(taskHistoryService.queryAll()));
            return;
        }
        this.print(JsonResult.getSuccess(taskHistoryService.queryOne(taskId)));
    }

    @PostMapping({"/date"})
    public void data(@RequestParam("taskId") String taskId) {
        this.print(JsonResult.getSuccess(taskHistoryService.delete(taskId)));
    }
}
