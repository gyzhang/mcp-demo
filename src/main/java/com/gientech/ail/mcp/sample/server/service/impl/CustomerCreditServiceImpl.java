package com.gientech.ail.mcp.sample.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.ail.mcp.sample.server.entity.CustomerCredit;
import com.gientech.ail.mcp.sample.server.mapper.CustomerCreditMapper;
import com.gientech.ail.mcp.sample.server.service.CustomerCreditService;
import org.springframework.stereotype.Service;

/**
 * 客户授信表Service实现类
 */
@Service
public class CustomerCreditServiceImpl extends ServiceImpl<CustomerCreditMapper, CustomerCredit> implements CustomerCreditService {
    
}