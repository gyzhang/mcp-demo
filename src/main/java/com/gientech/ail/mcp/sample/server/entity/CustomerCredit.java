package com.gientech.ail.mcp.sample.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 客户授信表实体类
 */
@Data
@TableName("customer_credit")
public class CustomerCredit {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long customerId;
    
    private Long productId;
    
    private BigDecimal creditLimit;
    
    private BigDecimal availableLimit;
    
    private String status;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}