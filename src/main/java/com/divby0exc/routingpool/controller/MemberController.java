package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group_transport/*")
public class MemberController {
    @Autowired
    MemberService memberService;
}
