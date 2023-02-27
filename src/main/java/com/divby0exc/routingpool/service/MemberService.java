package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.repository.GroupRepository;
import com.divby0exc.routingpool.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberService implements IMemberService{
    @Autowired
    private MemberRepository repo;
    @Override
    public void save(RoutingMember member) {
        repo.save(member);
    }

    @Override
    public void delete(Long memberID) {
        repo.deleteById(memberID);
    }

    @Override
    public List<RoutingMember> fetchMember(Long groupID) {
        return repo.findAll();
    }
}
