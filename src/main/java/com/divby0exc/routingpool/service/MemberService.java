package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository repo;

    public RoutingMember addMember(RoutingMember member) {
        return repo.save(member);
    }
    public void deleteMember(Long memberID) {
        repo.deleteRoutingMemberById(memberID);
    }
    public List<RoutingMember> getAllMembers(Long groupID) {
        return repo.findAllByGroupID(groupID);
    }
    public boolean existsMember(Long id) {
        return repo.existsRoutingMemberById(id);
    }
    public RoutingMember findMember(Long id) {
        return repo.findRoutingMemberById(id);
    }
    public boolean upateMember(Long id, RoutingMember newMember) {
        if(existsMember(id)) {
            addMember(newMember);
            return true;
        }
        return false;
    }

}
