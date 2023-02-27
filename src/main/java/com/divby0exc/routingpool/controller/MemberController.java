package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group_transport/*")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("get_members/{groupID}")
    public List<RoutingMember> getMembersInGroup(@PathVariable("groupID") Long groupID) {

        return memberService.fetchMember(groupID);
    }
    @PostMapping("add_member")
    public String addMemberToGroup(@RequestBody RoutingMember member) {
        memberService.save(member);

        return "Member has been added to group";
    }
}
