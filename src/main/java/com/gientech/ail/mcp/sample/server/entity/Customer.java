package com.gientech.ail.mcp.sample.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 客户信息表实体类
 */
@Data
@TableName("customer")
public class Customer {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private String idType;
    
    private String idNumber;
    
    private String phone;
    
    private String address;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}