package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingVehicle;
import com.divby0exc.routingpool.model.RoutingWalk;
import com.divby0exc.routingpool.service.CarService;
import com.divby0exc.routingpool.service.GroupService;
import com.divby0exc.routingpool.service.MemberService;
import com.divby0exc.routingpool.service.WalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group_transport/*")
public class GroupController {

    @Autowired
    private WebClient.Builder webClient;
    @Autowired
    GroupService groupService;


    @PostMapping("create_group")
    public String createGroup(@RequestBody RoutingGroup group) {
        groupService.save(group);

        return "Group has been created";
    }
    @GetMapping("show_groups")
    public List<RoutingGroup> showAllGroups() {
        return new ArrayList<>(groupService.fetchAll());
    }
}
