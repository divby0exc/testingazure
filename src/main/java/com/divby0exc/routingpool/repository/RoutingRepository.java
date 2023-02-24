package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutingRepository extends JpaRepository<RoutingGroup, Long> {
}
