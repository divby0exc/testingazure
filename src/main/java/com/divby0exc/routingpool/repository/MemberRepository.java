package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<RoutingMember, Long> {
}
