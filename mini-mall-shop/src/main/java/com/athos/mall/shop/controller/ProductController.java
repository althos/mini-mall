package com.athos.mall.shop.controller;


import com.athos.mall.base.BaseController;
import com.athos.mall.bean.AjaxResult;
import com.athos.mall.config.SysConfig;
import com.athos.mall.lang.anotation.Log;
import com.athos.mall.lang.anotation.enums.BusinessType;
import com.athos.mall.page.TableDataInfo;
import com.athos.mall.shop.domain.Category;
import com.athos.mall.shop.domain.Product;
import com.athos.mall.shop.service.ICategoryService;
import com.athos.mall.shop.service.IProductService;
import com.athos.mall.util.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 产品 信息操作处理
 *
 * @author ruoyi
 * @date 2019-02-27
 */
@Controller
@RequestMapping("/shop/product")
public class ProductController extends BaseController {
    private String prefix = "shop/product";

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;


    @RequiresPermissions("shop:product:view")
    @GetMapping()
    public String product() {
        return prefix + "/product";
    }

    /**
     * 查询产品列表
     */
    @RequiresPermissions("shop:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Product product) {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }


    /**
     * 导出产品列表
     */
    @RequiresPermissions("shop:product:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product) {
        List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(list, "product", SysConfig.getDownloadPath());
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    public String add(HttpServletRequest request) {
        List<Category> categoryList = categoryService.selectCategoryList(null);
        request.setAttribute("categoryList", categoryList);
        return prefix + "/add";
    }

    /**
     * 新增保存产品
     */
    @RequiresPermissions("shop:product:add")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Product product) {
        product.setCreateTime(new Date());
        product.setUserId(getUserId());
        product.setDeptId(getSysUser().getDeptId());
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改产品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        List<Category> categoryList = categoryService.selectCategoryList(null);
        Product product = productService.selectProductById(id);
        mmap.put("product", product);
        mmap.put("categoryList", categoryList);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品
     */
    @RequiresPermissions("shop:product:edit")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Product product) {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除产品 下架
     */
    @RequiresPermissions("shop:product:remove")
    @Log(title = "产品", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(productService.deleteProductByIds(ids));
    }


    /**
     * 删除产品 下架
     */
    @RequiresPermissions("shop:product:out")
    @PostMapping("/out")
    @ResponseBody
    public AjaxResult out(Integer id, Integer status) {
        return toAjax(productService.out(id, status));
    }


}
