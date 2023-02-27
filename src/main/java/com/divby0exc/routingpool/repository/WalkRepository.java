package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingWalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkRepository extends JpaRepository<RoutingWalk, Long> {
}
