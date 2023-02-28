package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingGroup;
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
public class CarService {
    @Autowired
    private VehicleRepository repo;

    public List<RoutingVehicle> getAllCars(Long groupID) {
        return repo.findAllByGroupID(groupID);
    }
    public RoutingVehicle addVehicle(RoutingVehicle vehicle) {
        return repo.save(vehicle);
    }
    public void deleteVehicle(Long carID) {
        repo.deleteRoutingVehicleById(carID);
    }
    public void setAvailability(Long carID, Integer timeLeft) {

    }
    public boolean existCar(Long carID) {
        return repo.existsRoutingVehicleById(carID);
    }
    public RoutingVehicle findCar(Long id) {
        return repo.findRoutingVehicleById(id);
    }
    public boolean updateCar(Long id, RoutingVehicle newVehicle) {
        if(existCar(id)) {
            addVehicle(newVehicle);
            return true;
        }
        return false;
    }

}
