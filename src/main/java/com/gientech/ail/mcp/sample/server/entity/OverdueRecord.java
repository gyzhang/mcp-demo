package com.gientech.ail.mcp.sample.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 逾期记录表实体类
 */
@Data
@TableName("overdue_record")
public class OverdueRecord {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long contractId;
    
    private String overdueDate;
    
    private BigDecimal dueAmount;
    
    private BigDecimal paidAmount;
    
    private BigDecimal overdueAmount;
    
    private BigDecimal penaltyAmount;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}