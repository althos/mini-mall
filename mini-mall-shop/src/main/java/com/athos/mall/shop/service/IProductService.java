package com.athos.mall.shop.service;


import com.athos.mall.shop.domain.Product;

import java.util.List;

/**
 * 产品 服务层
 *
 * @author ruoyi
 * @date 2019-02-27
 */
public interface IProductService {
    /**
     * 查询产品信息
     *
     * @param id 产品ID
     * @return 产品信息
     */
     Product selectProductById(Integer id);

    /**
     * 查询产品列表
     *
     * @param product 产品信息
     * @return 产品集合
     */
     List<Product> selectProductList(Product product);

    /**
     * 新增产品
     *
     * @param product 产品信息
     * @return 结果
     */
     int insertProduct(Product product);

    /**
     * 修改产品
     *
     * @param product 产品信息
     * @return 结果
     */
     int updateProduct(Product product);

    /**
     * 删除产品信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteProductByIds(String ids);

     int out(Integer id, Integer status);

}
