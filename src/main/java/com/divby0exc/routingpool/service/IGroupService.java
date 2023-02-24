package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingWalk;

public interface IGroupService {
    public void save(RoutingGroup group);

    public void save(int groupID, RoutingMember member);

    public void save(int groupID, RoutingWalk walk);

    public void delete(int groupID, int walkID);
}
