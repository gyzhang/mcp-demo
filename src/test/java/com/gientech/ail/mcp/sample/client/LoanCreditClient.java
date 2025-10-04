package com.gientech.ail.mcp.sample.client;

import io.modelcontextprotocol.client.transport.HttpClientStreamableHttpTransport;

/**
 * 零售信贷系统MCP客户端主类
 * 用于启动LoanCreditTestClient测试5个信贷系统相关的MCP工具
 */
public class LoanCreditClient {

    public static void main(String[] args) {
        // 创建HTTP客户端传输对象，连接到本地运行的MCP服务器（默认端口8080）
        HttpClientStreamableHttpTransport transport = HttpClientStreamableHttpTransport.builder("http://localhost:9081")
                .build();

        // 创建并运行LoanCreditTestClient，测试所有5个信贷系统工具
        new LoanCreditTestClient(transport).run();                
    }

}