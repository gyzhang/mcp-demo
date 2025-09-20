package com.gientech.ail.mcp.sample.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.ail.mcp.sample.server.entity.RepaymentPlan;
import com.gientech.ail.mcp.sample.server.mapper.RepaymentPlanMapper;
import com.gientech.ail.mcp.sample.server.service.RepaymentPlanService;
import org.springframework.stereotype.Service;

/**
 * 还款计划表Service实现类
 */
@Service
public class RepaymentPlanServiceImpl extends ServiceImpl<RepaymentPlanMapper, RepaymentPlan> implements RepaymentPlanService {
    
}