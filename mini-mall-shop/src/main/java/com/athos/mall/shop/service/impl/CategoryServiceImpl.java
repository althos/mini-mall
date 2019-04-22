package com.athos.mall.shop.service.impl;

import com.athos.mall.shop.domain.Category;
import com.athos.mall.shop.mapper.CategoryMapper;
import com.athos.mall.shop.service.ICategoryService;;
import com.athos.mall.tool.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类 服务层实现
 *
 * @author ruoyi
 * @date 2019-03-05
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询商品分类信息
     *
     * @param id 商品分类ID
     * @return 商品分类信息
     */
    @Override
    public Category selectCategoryById(Integer id) {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询商品分类列表
     *
     * @param category 商品分类信息
     * @return 商品分类集合
     */
    @Override
    public List<Category> selectCategoryList(Category category) {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增商品分类
     *
     * @param category 商品分类信息
     * @return 结果
     */
    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改商品分类
     *
     * @param category 商品分类信息
     * @return 结果
     */
    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    /**
     * 删除商品分类对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(String ids) {
        return categoryMapper.deleteCategoryByIds(Convert.toStrArray(ids));
    }

}
