package com.athos.mall.shop.controller;

import com.athos.mall.base.BaseController;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.config.SysConfig;
import com.athos.mall.lang.anotation.Log;
import com.athos.mall.lang.anotation.enums.BusinessType;
import com.athos.mall.page.TableDataInfo;
import com.athos.mall.shop.domain.Banner;
import com.athos.mall.shop.service.IBannerService;
import com.athos.mall.util.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 广告banner 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-27
 */
@Controller
@RequestMapping("/shop/banner")
public class BannerController extends BaseController {
    private String prefix = "shop/banner";

    @Autowired
    private IBannerService bannerService;

    @RequiresPermissions("shop:banner:view")
    @GetMapping()
    public String banner() {
        return prefix + "/banner";
    }

    /**
     * 查询广告banner列表
     */
    @RequiresPermissions("shop:banner:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Banner banner) {
        startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
        return getDataTable(list);
    }


    /**
     * 导出广告banner列表
     */
    @RequiresPermissions("shop:banner:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Banner banner) {
        List<Banner> list = bannerService.selectBannerList(banner);
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        return util.exportExcel(list, "banner", SysConfig.getDownloadPath());
    }

    /**
     * 新增广告banner
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存广告banner
     */
    @RequiresPermissions("shop:banner:add")
    @Log(title = "广告banner", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Banner banner) {
        banner.setCreateTime(new Date());
        return toAjax(bannerService.insertBanner(banner));
    }

    /**
     * 修改广告banner
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Banner banner = bannerService.selectBannerById(id);
        mmap.put("banner", banner);
        return prefix + "/edit";
    }

    /**
     * 修改保存广告banner
     */
    @RequiresPermissions("shop:banner:edit")
    @Log(title = "广告banner", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Banner banner) {
        return toAjax(bannerService.updateBanner(banner));
    }

    /**
     * 删除广告banner
     */
    @RequiresPermissions("shop:banner:remove")
    @Log(title = "广告banner", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
//	   FileUtils.deleteFile(filePath);
        return toAjax(bannerService.deleteBannerByIds(ids));
    }

}
