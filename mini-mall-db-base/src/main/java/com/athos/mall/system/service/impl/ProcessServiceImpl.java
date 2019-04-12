package com.athos.mall.system.service.impl;

import com.athos.mall.system.mapper.ProcessMapper;
import com.athos.mall.system.service.IProcessService;
import com.athos.mall.tool.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.athos.mall.system.domain.Process;

import java.util.List;

/**
 * 工序 服务层实现
 *
 * @author ruoyi
 * @date 2019-02-21
 */
@Service
public class ProcessServiceImpl implements IProcessService {

    @Autowired
    private ProcessMapper processMapper;

    /**
     * 查询工序信息
     *
     * @param id 工序ID
     * @return 工序信息
     */
    @Override
    public Process selectProcessById(Integer id) {
        return processMapper.selectProcessById(id);
    }

    /**
     * 查询工序列表
     *
     * @param process 工序信息
     * @return 工序集合
     */
    @Override
    public List<Process> selectProcessList(Process process) {
        return processMapper.selectProcessList(process);
    }

    /**
     * 新增工序
     *
     * @param process 工序信息
     * @return 结果
     */
    @Override
    public int insertProcess(Process process) {
        return processMapper.insertProcess(process);
    }

    /**
     * 修改工序
     *
     * @param process 工序信息
     * @return 结果
     */
    @Override
    public int updateProcess(Process process) {
        return processMapper.updateProcess(process);
    }

    /**
     * 删除工序对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProcessByIds(String ids) {
        return processMapper.deleteProcessByIds(Convert.toStrArray(ids));
    }

    /**
     * 工分统计
     *
     * @param process
     * @return
     */
    @Override
    public List<Process> selectProcessStatistics(Process process) {
        return processMapper.selectProcessStatistics(process);
    }
}
