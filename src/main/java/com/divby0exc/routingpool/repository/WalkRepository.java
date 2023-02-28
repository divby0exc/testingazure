package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingWalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalkRepository extends JpaRepository<RoutingWalk, Long> {
    RoutingWalk save(RoutingWalk walk);

    void deleteRoutingWalkById(Long walkID);
    List<RoutingWalk> findAllByGroupID(Long groupID);
    RoutingWalk findRoutingWalkByGroupIDAndTo(Long groupID, String to);
}
