package com.zelex.handrpc.handrpcclient.controller;

import com.zelex.handrpc.handrpcclient.remoteservice.RpcClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/request")
public class RequestController {

    @Resource
    private RpcClientService rpcClientService;

    @GetMapping("/testHello")
    public String testHello(@RequestParam("name") String name) {
        return rpcClientService.sendMessage(name);
    }
}
