package com.gientech.ail.mcp.sample.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.ail.mcp.sample.server.entity.LoanProduct;
import com.gientech.ail.mcp.sample.server.mapper.LoanProductMapper;
import com.gientech.ail.mcp.sample.server.service.LoanProductService;
import org.springframework.stereotype.Service;

/**
 * 贷款产品表Service实现类
 */
@Service
public class LoanProductServiceImpl extends ServiceImpl<LoanProductMapper, LoanProduct> implements LoanProductService {
    
}