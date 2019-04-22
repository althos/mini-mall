package com.athos.mall.shop.controller;


import com.athos.mall.base.BaseController;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.config.SysConfig;
import com.athos.mall.lang.anotation.Log;
import com.athos.mall.lang.anotation.enums.BusinessType;
import com.athos.mall.page.TableDataInfo;
import com.athos.mall.shop.domain.Category;
import com.athos.mall.shop.service.ICategoryService;
import com.athos.mall.util.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 商品分类 信息操作处理
 *
 * @author ruoyi
 * @date 2019-03-05
 */
@Controller
@RequestMapping("/shop/category")
public class CategoryController extends BaseController {
    private String prefix = "shop/category";

    @Autowired
    private ICategoryService categoryService;

    @RequiresPermissions("shop:category:view")
    @GetMapping()
    public String category() {
        return prefix + "/category";
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("shop:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Category category) {
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }


    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("shop:category:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Category category) {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        return util.exportExcel(list, "category", SysConfig.getDownloadPath());
    }

    /**
     * 新增商品分类
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存商品分类
     */
    @RequiresPermissions("shop:category:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Category category) {
        category.setCreateTime(new Date());
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改商品分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Category category = categoryService.selectCategoryById(id);
        mmap.put("category", category);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品分类
     */
    @RequiresPermissions("shop:category:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Category category) {
        category.setCreateTime(new Date());
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("shop:category:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }

}
