package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingVehicle;

import java.util.List;

public interface ICarService {
    public void save(RoutingVehicle vehicle);

    public void delete(Long carID);

    public List<RoutingVehicle> fetchAll(Long groupID);

    public void setAvailability(Long carID, Integer timeLeft);
}
