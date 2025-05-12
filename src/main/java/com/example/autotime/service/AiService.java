package com.example.autotime.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {
    public String chatWithAi(String userInput) {
        // 这里是模拟AI回复，后续可替换为真实阿里云AI调用
        return "AI回复: " + userInput;
    }
} 