package com.bnpinnovation.prototestcli.controller;

import com.bnpinnovation.proto.ScvInfo;
import com.bnpinnovation.prototestcli.GrpcClient;
import com.bnpinnovation.prototestcli.dto.SCVDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoClientController {
    @Autowired
    private GrpcClient grpcClient;

    @GetMapping
    @RequestMapping("/scv")
    public SCVDto.Response scv() {
        ScvInfo.SCVResponse response = grpcClient.getSCV();
        return new SCVDto.Response(response.getUsername(),response.getEmail());
    }
}
