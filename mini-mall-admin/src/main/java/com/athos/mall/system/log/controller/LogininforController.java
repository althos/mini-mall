package com.athos.mall.system.log.controller;


import com.athos.mall.base.BaseController;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.config.SysConfig;
import com.athos.mall.system.domain.Logininfor;
import com.athos.mall.lang.anotation.Log;
import com.athos.mall.lang.anotation.enums.BusinessType;
import com.athos.mall.page.TableDataInfo;
import com.athos.mall.system.service.ILogininforService;
import com.athos.mall.util.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统访问记录
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/logininfor")
public class LogininforController extends BaseController {
    private String prefix = "system/logininfor";

    @Autowired
    private ILogininforService logininforService;

    @RequiresPermissions("system:logininfor:view")
    @GetMapping()
    public String logininfor() {
        return prefix + "/logininfor";
    }

    @RequiresPermissions("system:logininfor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Logininfor logininfor) {
        startPage();
        List<Logininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @Log(title = "登陆日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:logininfor:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Logininfor logininfor) {
        List<Logininfor> list = logininforService.selectLogininforList(logininfor);
        ExcelUtil<Logininfor> util = new ExcelUtil<Logininfor>(Logininfor.class);
        return util.exportExcel(list, "登陆日志", SysConfig.getDownloadPath());
    }

    @RequiresPermissions("system:logininfor:remove")
    @Log(title = "登陆日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(logininforService.deleteLogininforByIds(ids));
    }

    @RequiresPermissions("system:logininfor:remove")
    @Log(title = "登陆日志", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        logininforService.cleanLogininfor();
        return success();
    }
}
