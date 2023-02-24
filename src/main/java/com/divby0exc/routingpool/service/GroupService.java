package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingWalk;
import org.apache.catalina.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements IGroupService {

    @Override
    public void save(RoutingGroup group) {

    }

    @Override
    public void save(int groupID, RoutingMember member) {

    }

    @Override
    public void save(int groupID, RoutingWalk walk) {

    }

    @Override
    public void delete(int groupID, int walkID) {

    }
}
