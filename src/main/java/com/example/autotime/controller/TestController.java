package com.example.autotime.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/mcpTest")
public class TestController {
    
    private static final String DEFAULT_PROMPT = 
    """
        你是一个日程规划机器人，你的目标是帮助用户完成每日日程的规划，产出日程计划

        #基础信息
        1.用户的每周目标。用户会给你他的每周目标，其中会包含事情的优先级，会带有重要和紧急的标识

        #时间规划方法论
        1.充分了解、利用时间四象限的相关方法来安排事情
        2.9:30-12:00、15:30-18:00、19:30-21:00这是三个高效工作的时间，这段时间内工作的效率会比较高，应该专注于那些真正重要的事情
        3.13:30-15:30、21:30-23:30这是两个效率不高的时间，可以处理一些小事

        #返回例子
        9:30-12:00  开发时间规划APP

        13:30-15:30  办理港澳通行证
        15:30-18:00  编写自媒体文章

        19:30-21:00  投资理财
        21:30-23:30  冥想

        #返回格式
        每个时间段一行
            """;

    private final ChatClient dashScopeChatClient;

    public TestController(ChatClient.Builder chatClientBuilder) {
      this.dashScopeChatClient = chatClientBuilder
          .defaultSystem(DEFAULT_PROMPT)
        //    // 实现 Chat Memory 的 Advisor
        //    // 在使用 Chat Memory 时，需要指定对话 ID，以便 Spring AI 处理上下文。
        //    .defaultAdvisors(
        //        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
        //    )
        //    // 实现 Logger 的 Advisor
        //    .defaultAdvisors(
        //        new SimpleLoggerAdvisor()
        //    )
        //    // 设置 ChatClient 中 ChatModel 的 Options 参数
        //    .defaultOptions(
        //        DashScopeChatOptions.builder()
        //            .withTopP(0.7)
        //            .build()
        //    )
           .build();
     }
  
      @GetMapping("/simple/chat")
    public String simpleChat(String query) {
      return dashScopeChatClient.prompt(query).call().content();
   }

}
