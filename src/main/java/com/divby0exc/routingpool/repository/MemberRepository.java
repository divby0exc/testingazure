package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.RoutingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<RoutingMember, Long> {
    RoutingMember save(RoutingMember member);

    void deleteRoutingMemberById(Long memberID);

    List<RoutingMember> findAllByGroupID(Long groupID);
    RoutingMember findRoutingMemberById(Long id);
    boolean existsRoutingMemberById(Long id);
}
