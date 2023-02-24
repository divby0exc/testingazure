package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingVehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{
    @Override
    public void save(int groupID, RoutingVehicle vehicle) {

    }

    @Override
    public void delete(int groupID, int carID) {

    }

    @Override
    public List<RoutingVehicle> fetchAll(int groupID) {
        return null;
    }

    @Override
    public void setAvailability(int groupID, int carID, Integer timeLeft) {

    }
}
