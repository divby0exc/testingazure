package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<RoutingGroup, Long> {
}
