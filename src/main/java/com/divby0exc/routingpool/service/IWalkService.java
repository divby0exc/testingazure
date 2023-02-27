package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingVehicle;
import com.divby0exc.routingpool.model.RoutingWalk;

import java.util.List;

public interface IWalkService {
    public void save(RoutingWalk walk);

    public void delete(Long walkID);
    public List<RoutingWalk> fetchAll(Long groupID);
    public RoutingWalk findByDest(Long groupID, String to);
}
