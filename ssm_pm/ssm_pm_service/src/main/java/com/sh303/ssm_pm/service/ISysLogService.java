package com.sh303.ssm_pm.service;

import com.sh303.ssm_pm.entity.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 日志记录保存
     *
     * @param sysLog
     * @throws Exception
     */
    void save(SysLog sysLog) throws Exception;

    /**
     * 查询所有日志
     *
     * @return
     * @throws Exception
     */
    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;
}
