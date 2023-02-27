package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<RoutingVehicle, Long> {
}
