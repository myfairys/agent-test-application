//package com.test.provider2.service;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.alibaba.dubbo.config.annotation.Service;
//import com.test.api.service.DemoService;
//import com.test.api.service.Provider2DemoService;
//
//@Service
//public class Provider2DemoServiceImpl implements Provider2DemoService {
//    @Reference
//    DemoService demoService;
//    @Override
//    public String print(String name) {
//        return demoService.print(name) + " provider2: " + name;
//    }
//}
