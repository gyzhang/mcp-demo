package com.gientech.ail.mcp.sample.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 贷款产品表实体类
 */
@Data
@TableName("loan_product")
public class LoanProduct {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String productCode;
    
    private String productName;
    
    private String description;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}