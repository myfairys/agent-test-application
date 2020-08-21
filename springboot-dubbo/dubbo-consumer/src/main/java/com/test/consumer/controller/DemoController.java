package com.test.consumer.controller;

//import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//
//    @Reference
//    DemoService demoService;
//    @Reference
//    UserService userService;
//    @Reference
//    Provider2DemoService provider2DemoService;

    @GetMapping("/printdemo")
//    @SentinelResource(value = "print", blockHandler = "blockHandler", fallback = "fallback")
    public String print(String name) {
        System.out.println("consumer");
        return "demoService.print(name)";
    }

    public String fallback(String name)
    {
        return "error: " + name;
    }
//    public String blockHandler(String s, BlockException ex)
//    {
//        ex.printStackTrace();
//        return "Oops, error occurred at " + s;
//    }
//    @GetMapping("/test")
//    public String muckInvoke(String name) {
//        return provider2DemoService.print(name);
//    }
    @GetMapping("/user/id")
    public String selectById(Integer id) {
//        System.out.println(demoService.getUserById(id));
        return "success";
    }

    @PostMapping("/user")
    public String insertUser(String name) {
//        return userService.insertOne(user);
        System.out.println("i'm post");
        return "ok";
    }

    public static void main(String[] args)
    {

        System.out.println(System.getenv("MAVEN_HOME"));
    }

   /* private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }*/
}
