package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingVehicle;
import com.divby0exc.routingpool.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CarService implements ICarService{
    @Autowired
    private VehicleRepository repo;
    @Override
    public void save(RoutingVehicle vehicle) {
        repo.save(vehicle);
    }

    @Override
    public void delete(Long carID) {
        repo.deleteById(carID);
    }

    @Override
    public List<RoutingVehicle> fetchAll(Long groupID) {

        return repo.findAllById(Collections.singleton(groupID));
    }

    @Override
    public void setAvailability(Long carID, Integer timeLeft) {
        repo.findById(carID).get().setOccupiedFor(timeLeft);
    }
}
