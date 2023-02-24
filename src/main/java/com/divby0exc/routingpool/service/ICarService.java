package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingVehicle;

import java.util.List;

public interface ICarService {
    public void save(int groupID, RoutingVehicle vehicle);

    public void delete(int groupID, int carID);

    public List<RoutingVehicle> fetchAll(int groupID);

    public void setAvailability(int groupID, int carID, Integer timeLeft);
}
