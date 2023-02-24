package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<RoutingVehicle, Long> {
}
