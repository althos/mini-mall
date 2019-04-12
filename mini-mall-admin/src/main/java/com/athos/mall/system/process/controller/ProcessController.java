package com.athos.mall.system.process.controller;


import com.athos.mall.base.BaseController;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.config.SysConfig;
import com.athos.mall.lang.anotation.Log;
import com.athos.mall.lang.anotation.enums.BusinessType;
import com.athos.mall.page.TableDataInfo;
import com.athos.mall.system.service.IProcessService;
import com.athos.mall.util.CSVUtils;
import com.athos.mall.util.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.athos.mall.system.domain.Process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 工序 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/system/process")
public class ProcessController extends BaseController {
    private String prefix = "system/process";

    @Autowired
    private IProcessService processService;


    @RequiresPermissions("system:process:view")
    @GetMapping()
    public String process() {
        return prefix + "/process";
    }

    /**
     * 查询工序列表
     */
    @RequiresPermissions("system:process:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Process process) {
        startPage();
        List<Process> list = processService.selectProcessList(process);
        return getDataTable(list);
    }


    /**
     * 导出工序列表
     */
    @RequiresPermissions("system:process:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Process process) {
        List<Process> list = processService.selectProcessList(process);
        ExcelUtil<Process> util = new ExcelUtil<Process>(Process.class);
        return util.exportExcel(list, "process",SysConfig.getDownloadPath());
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    public void importTemplate(HttpServletRequest request, HttpServletResponse response) {
        //csv表头
        String header = "工票号,工序号,员工号,工分,备注";
        //下面 data里的key，可以说是数据库字段了
        String key = "ticketNo,processNo,employeeNo,score,remark";
        String fileName = "工票导入模板.csv";
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        String content = CSVUtils.formatCsvData(data, header, key);
        try {
            CSVUtils.exportCsv(fileName, content, request, response);
            return;
        } catch (Exception e) {

        }
    }

    /**
     * 批量导入
     */
    @RequiresPermissions("system:process:importExcel")
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(@RequestParam("file") MultipartFile file) {
        try {
            InputStreamReader is = new InputStreamReader(file.getInputStream(), "GBK");
            BufferedReader reader = new BufferedReader(is);//换成你的文件名 
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉 
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分 
                System.out.print(Arrays.toString(item));
                Process process = new Process();
                process.setCreateTime(new Date());
                process.setTicketNo(item[0]);
                process.setProcessNo(item[1]);
                process.setEmployeeNo(item[2]);
                process.setScore(Integer.parseInt(item[3]));
                process.setRemark(item[4]);
                processService.insertProcess(process);
            }
            return toAjax(true);
        } catch (Exception e) {
            e.printStackTrace();
            return toAjax(false);
        }
    }

    /**
     * 新增工序
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存工序
     */
    @RequiresPermissions("system:process:add")
    @Log(title = "工序", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Process process) {
        process.setCreateTime(new Date());
        return toAjax(processService.insertProcess(process));
    }

    /**
     * 修改工序
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Process process = processService.selectProcessById(id);
        mmap.put("process", process);
        return prefix + "/edit";
    }

    /**
     * 修改保存工序
     */
    @RequiresPermissions("system:process:edit")
    @Log(title = "工序", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Process process) {
        return toAjax(processService.updateProcess(process));
    }

    /**
     * 删除工序
     */
    @RequiresPermissions("system:process:remove")
    @Log(title = "工序", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(processService.deleteProcessByIds(ids));
    }


}
