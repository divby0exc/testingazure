package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository repo;

    public RoutingGroup addGroup(RoutingGroup group) {
        return repo.save(group);
    }
    public void deleteGroup(Long groupID) {
        repo.deleteRoutingGroupById(groupID);
    }
    public boolean existGroup(Long id) {
        return repo.existsRoutingGroupById(id);
    }
    public RoutingGroup getGroup(Long groupID) {
        return repo.findRoutingGroupById(groupID);
    }
    public boolean updateGroup(Long id, RoutingGroup newGroup) {
        if(existGroup(id)) {
            addGroup(newGroup);
            return true;
        }
        return false;
    }

}
