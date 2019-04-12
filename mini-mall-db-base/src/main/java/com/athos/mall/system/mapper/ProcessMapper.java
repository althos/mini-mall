package com.athos.mall.system.mapper;

import java.util.List;
import com.athos.mall.system.domain.Process;

/**
 * 工序 数据层
 *
 * @author ruoyi
 * @date 2019-02-21
 */
public interface ProcessMapper {
    /**
     * 查询工序信息
     *
     * @param id 工序ID
     * @return 工序信息
     */
     Process selectProcessById(Integer id);

    /**
     * 查询工序列表
     *
     * @param process 工序信息
     * @return 工序集合
     */
     List<Process> selectProcessList(Process process);

    /**
     * 新增工序
     *
     * @param process 工序信息
     * @return 结果
     */
     int insertProcess(Process process);

    /**
     * 修改工序
     *
     * @param process 工序信息
     * @return 结果
     */
     int updateProcess(Process process);

    /**
     * 删除工序
     *
     * @param id 工序ID
     * @return 结果
     */
     int deleteProcessById(Integer id);

    /**
     * 批量删除工序
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteProcessByIds(String[] ids);

    /**
     * 工分统计
     *
     * @param process
     * @return
     */
     List<Process> selectProcessStatistics(Process process);

}