package com.gientech.ail.mcp.sample.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.ail.mcp.sample.server.entity.OverdueRecord;
import com.gientech.ail.mcp.sample.server.mapper.OverdueRecordMapper;
import com.gientech.ail.mcp.sample.server.service.OverdueRecordService;
import org.springframework.stereotype.Service;

/**
 * 逾期记录表Service实现类
 */
@Service
public class OverdueRecordServiceImpl extends ServiceImpl<OverdueRecordMapper, OverdueRecord> implements OverdueRecordService {
    
}