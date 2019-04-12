package com.athos.mall.system.log.controller;

import com.athos.mall.base.BaseController;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.config.SysConfig;
import com.athos.mall.system.domain.OperLog;
import com.athos.mall.lang.anotation.Log;
import com.athos.mall.lang.anotation.enums.BusinessType;
import com.athos.mall.page.TableDataInfo;
import com.athos.mall.system.service.IOperLogService;
import com.athos.mall.util.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志记录
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/operlog")

public class OperlogController extends BaseController {
    private String prefix = "system/operlog";

    @Autowired
    private IOperLogService operLogService;

    @RequiresPermissions("system:operlog:view")
    @GetMapping()
    public String operlog() {
        return prefix + "/operlog";
    }

    @RequiresPermissions("system:operlog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OperLog operLog) {
        startPage();
        List<OperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:operlog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OperLog operLog) {
        List<OperLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<OperLog> util = new ExcelUtil<OperLog>(OperLog.class);
        return util.exportExcel(list, "操作日志", SysConfig.getDownloadPath());
    }

    @RequiresPermissions("system:operlog:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(operLogService.deleteOperLogByIds(ids));
    }

    @RequiresPermissions("system:operlog:detail")
    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long operId, ModelMap mmap) {
        mmap.put("operLog", operLogService.selectOperLogById(operId));
        return prefix + "/detail";
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @RequiresPermissions("system:operlog:remove")
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        operLogService.cleanOperLog();
        return success();
    }
}
