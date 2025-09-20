package com.gientech.ail.mcp.sample.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 贷款合同表实体类
 */
@Data
@TableName("loan_contract")
public class LoanContract {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String contractNo;
    
    private Long customerId;
    
    private Long productId;
    
    private BigDecimal loanAmount;
    
    private BigDecimal loanBalance;
    
    private LocalDate loanDate;
    
    private LocalDate maturityDate;
    
    private String status;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}