package com.athos.mall.shop.service.impl;

import com.athos.mall.shop.domain.Banner;
import com.athos.mall.shop.mapper.BannerMapper;
import com.athos.mall.shop.service.IBannerService;
import com.athos.mall.tool.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告banner 服务层实现
 *
 * @author ruoyi
 * @date 2019-02-27
 */
@Service
public class BannerServiceImpl implements IBannerService {
    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 查询广告banner信息
     *
     * @param id 广告bannerID
     * @return 广告banner信息
     */
    @Override
    public Banner selectBannerById(Integer id) {
        return bannerMapper.selectBannerById(id);
    }

    /**
     * 查询广告banner列表
     *
     * @param banner 广告banner信息
     * @return 广告banner集合
     */
    @Override
    public List<Banner> selectBannerList(Banner banner) {
        return bannerMapper.selectBannerList(banner);
    }

    /**
     * 新增广告banner
     *
     * @param banner 广告banner信息
     * @return 结果
     */
    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insertBanner(banner);
    }

    /**
     * 修改广告banner
     *
     * @param banner 广告banner信息
     * @return 结果
     */
    @Override
    public int updateBanner(Banner banner) {
        return bannerMapper.updateBanner(banner);
    }

    /**
     * 删除广告banner对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBannerByIds(String ids) {
        return bannerMapper.deleteBannerByIds(Convert.toStrArray(ids));
    }

}
