package com.gientech.ail.mcp.sample.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gientech.ail.mcp.sample.server.entity.LoanContract;
import com.gientech.ail.mcp.sample.server.mapper.LoanContractMapper;
import com.gientech.ail.mcp.sample.server.service.LoanContractService;
import org.springframework.stereotype.Service;

/**
 * 贷款合同表Service实现类
 */
@Service
public class LoanContractServiceImpl extends ServiceImpl<LoanContractMapper, LoanContract> implements LoanContractService {
    
}