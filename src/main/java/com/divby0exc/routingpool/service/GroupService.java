package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingWalk;
import com.divby0exc.routingpool.repository.GroupRepository;
import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private GroupRepository repo;

    @Override
    public void save(RoutingGroup group) {
        repo.save(group);
    }

    @Override
    public void delete(Long groupID) {
        repo.deleteById(groupID);
    }

    @Override
    public List<RoutingGroup> fetchAll() {
        return repo.findAll();
    }
}
