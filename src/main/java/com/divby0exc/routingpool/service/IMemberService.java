package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingVehicle;

import java.util.List;

public interface IMemberService {

    public void save(RoutingMember member);

    public void delete(Long memberID);

    public List<RoutingMember> fetchMember(Long groupID);
}
