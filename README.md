# 零售信贷系统 MCP Server 示例

[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

这个示例项目展示了如何使用Spring AI的MCP注解创建一个零售信贷系统的MCP服务器。它演示了如何使用Java注解以声明式的方式实现MCP服务器功能，包括工具的注册和使用。

## 目录结构
- [概述](#概述)
- [功能特性](#功能特性)
- [依赖](#依赖)
- [构建项目](#构建项目)
- [运行服务器](#运行服务器)
- [配置](#配置)
- [服务器实现](#服务器实现)
- [MCP工具](#mcp工具)
- [数据模型](#数据模型)

## 概述

本示例展示了一个完整的零售信贷系统MCP服务器实现，具有以下特点：
- 集成了`spring-ai-starter-mcp-server-webmvc`
- 支持SSE（Server-Sent Events）和STDIO传输
- 使用注解自动注册MCP功能：
  - `@McpTool`用于注册MCP特定工具
- 提供了完整的信贷查询功能

## 功能特性

本示例实现了以下信贷系统功能：

1. **客户授信额度查询** - 根据客户信息和贷款品种查询授信额度
2. **贷款余额查询** - 根据客户信息和贷款品种查询贷款余额
3. **多产品贷款余额查询** - 根据客户信息查询所有贷款品种的余额
4. **还款计划查询** - 查询指定贷款品种的今年还款计划
5. **逾期记录查询** - 查询指定贷款品种的逾期记录

## 依赖

项目需要Spring AI MCP Server WebMVC Boot Starter和MCP Annotations：

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-mcp-server-webmvc</artifactId>
</dependency>
```

这些依赖提供了：
- 基于Spring MVC的HTTP传输（`WebMvcSseServerTransport`）
- 自动配置的SSE、Streamable-HTTP或Stateless端点，由`spring.ai.mcp.server.protocol=...`属性配置，默认为`SSE`
- 可选的STDIO传输，如果设置了`spring.ai.mcp.server.stdio=true`
- 基于注解的MCP操作方法处理

## 构建项目

使用Maven构建项目：
```bash
./mvnw clean install -DskipTests
```

## 运行服务器

项目内配置的是Streamable-HTTP，直接使用如下命令启动：

```bash
nohup java -jar ./mcp-loan-server-20250920.jar > ./mcp-loan.log 2>&1 &
```

服务器支持两种传输模式：

### WebMVC SSE/Streamable-HTTP/Stateless模式

模式取决于`spring.ai.mcp.server.protocol=...`设置。

```bash
java -Dspring.ai.mcp.server.protocol=STREAMABLE -jar target/mcp-annotations-server-0.0.1-SNAPSHOT.jar
```

### STDIO模式
启用STDIO传输，设置相应的属性：
```bash
java -Dspring.ai.mcp.server.stdio=true -Dspring.main.web-application-type=none -jar target/mcp-annotations-server-0.0.1-SNAPSHOT.jar
```

## 配置

通过`application.properties`配置服务器：

```properties
# 服务器标识
spring.ai.mcp.server.name=loan-credit-server
spring.ai.mcp.server.version=0.0.1
spring.ai.mcp.server.protocol=STREAMABLE
# spring.ai.mcp.server.protocol=STATELESS

# 传输配置（取消注释以启用STDIO）
# spring.ai.mcp.server.stdio=true
# spring.main.web-application-type=none

# 日志（STDIO传输需要）
spring.main.banner-mode=off
# logging.pattern.console=

# 日志文件位置
logging.file.name=./model-context-protocol/mcp-annotations/mcp-annotations-server/target/server.log

# 数据源配置
spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# SQL初始化
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql
spring.sql.init.platform=h2

# H2控制台配置
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false

# MyBatis-Plus配置
mybatis-plus.mapper-locations=classpath:mapper/*.xml
mybatis-plus.type-aliases-package=org.springframework.ai.mcp.sample.server.entity
mybatis-plus.configuration.map-underscore-to-camel-case=true
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
# server.port=8081
```

## 服务器实现

服务器使用Spring Boot和MCP注解自动注册功能：

```java
@SpringBootApplication
@MapperScan("org.springframework.ai.mcp.sample.server.mapper")
public class McpServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    // MyBatis-Plus 分页插件配置
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }
}
```

## MCP工具

项目包含一个`LoanCreditProvider`类，使用`@McpTool`注解实现了信贷相关的工具方法：

```java
@Service
public class LoanCreditProvider {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private LoanProductService loanProductService;
    
    @Autowired
    private CustomerCreditService customerCreditService;
    
    @Autowired
    private LoanContractService loanContractService;
    
    @Autowired
    private RepaymentPlanService repaymentPlanService;
    
    @Autowired
    private OverdueRecordService overdueRecordService;
    
    // 各种@McpTool注解的方法...
}
```

### 可用工具

1. **查询客户的授信额度**
   - 方法名: `queryCreditLimit`
   - 描述: 查询客户在指定贷款品种下的授信额度
   - 参数:
     - `name`: String - 客户姓名
     - `idType`: String - 证件类型
     - `idNumber`: String - 证件号码
     - `productName`: String - 贷款品种名称
   - 返回: 授信额度信息，包括总授信额度和可用额度

2. **查询贷款余额（按产品）**
   - 方法名: `queryLoanBalanceByProduct`
   - 描述: 查询客户在指定贷款品种下的贷款余额
   - 参数:
     - `name`: String - 客户姓名
     - `idType`: String - 证件类型
     - `idNumber`: String - 证件号码
     - `productName`: String - 贷款品种名称
   - 返回: 贷款余额信息

3. **查询贷款余额（所有产品）**
   - 方法名: `queryLoanBalancesByCustomer`
   - 描述: 查询客户在所有贷款品种下的贷款余额
   - 参数:
     - `name`: String - 客户姓名
     - `idType`: String - 证件类型
     - `idNumber`: String - 证件号码
   - 返回: 各贷款品种的贷款余额列表

4. **查询还款计划**
   - 方法名: `queryRepaymentPlans`
   - 描述: 查询客户在指定贷款品种下的今年还款计划
   - 参数:
     - `name`: String - 客户姓名
     - `idType`: String - 证件类型
     - `idNumber`: String - 证件号码
     - `productName`: String - 贷款品种名称
   - 返回: 还款计划列表，包含还款时间、金额、利息、本金等信息

5. **查询逾期记录**
   - 方法名: `queryOverdueRecords`
   - 描述: 查询客户在指定贷款品种下的逾期记录
   - 参数:
     - `name`: String - 客户姓名
     - `idType`: String - 证件类型
     - `idNumber`: String - 证件号码
     - `productName`: String - 贷款品种名称
   - 返回: 逾期记录列表，包含逾期时间、应还金额、已还金额、逾期未还金额、罚息等信息

## 数据模型

系统使用以下数据表存储信贷相关信息：

1. **customer** - 客户信息表
2. **loan_product** - 贷款产品表
3. **customer_credit** - 客户授信表
4. **loan_contract** - 贷款合同表
5. **repayment_plan** - 还款计划表
6. **overdue_record** - 逾期记录表

## 使用方法

在 AgentOps 智能体平台中，使用如下信息配置 MPC Server，以供智能体开发用。

```json
{
  "mcpServers": {
    "amap-maps": {
      "name": "零售信贷业务组件",
      "description": "零售信贷业务组件，包含额度查询、贷款余额查询、还款计划查询和逾期记录查询等5个MCP工具。",
      "type": "streamable_http",
      "url": "http://xx.xx.xx.xx:9081/mcp"
    }
  }
}
```

