package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<RoutingGroup, Long> {
    RoutingGroup save(RoutingGroup group);

    void deleteRoutingGroupById(Long groupID);
    RoutingGroup findRoutingGroupById(Long id);
    boolean existsRoutingGroupById(Long id);

}
