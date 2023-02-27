package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingVehicle;
import com.divby0exc.routingpool.model.RoutingWalk;

import java.util.List;

public interface IGroupService {
    public void save(RoutingGroup group);

    public void delete(Long groupID);

    public List<RoutingGroup> fetchAll();
}
