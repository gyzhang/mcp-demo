package com.gientech.ail.mcp.sample.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.ail.mcp.sample.server.entity.Customer;
import com.gientech.ail.mcp.sample.server.mapper.CustomerMapper;
import com.gientech.ail.mcp.sample.server.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * 客户信息表Service实现类
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    
}