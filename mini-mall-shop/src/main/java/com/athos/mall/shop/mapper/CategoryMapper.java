package com.athos.mall.shop.mapper;


import com.athos.mall.shop.domain.Category;

import java.util.List;

/**
 * 商品分类 数据层
 *
 * @author ruoyi
 * @date 2019-03-05
 */
public interface CategoryMapper {
    /**
     * 查询商品分类信息
     *
     * @param id 商品分类ID
     * @return 商品分类信息
     */
    public Category selectCategoryById(Integer id);

    /**
     * 查询商品分类列表
     *
     * @param category 商品分类信息
     * @return 商品分类集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增商品分类
     *
     * @param category 商品分类信息
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改商品分类
     *
     * @param category 商品分类信息
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 删除商品分类
     *
     * @param id 商品分类ID
     * @return 结果
     */
    public int deleteCategoryById(Integer id);

    /**
     * 批量删除商品分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCategoryByIds(String[] ids);

}