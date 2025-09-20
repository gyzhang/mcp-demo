package com.gientech.ail.mcp.sample.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 还款计划表实体类
 */
@Data
@TableName("repayment_plan")
public class RepaymentPlan {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long contractId;
    
    private String repaymentDate;
    
    private BigDecimal repaymentAmount;
    
    private BigDecimal interestAmount;
    
    private BigDecimal principalAmount;
    
    private BigDecimal remainingBalance;
    
    private String status;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}