package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingWalk;
import com.divby0exc.routingpool.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkService implements IWalkService{
    @Autowired
    private WalkRepository repo;

    @Override
    public void save(RoutingWalk walk) {
        repo.save(walk);
    }

    @Override
    public void delete(Long walkID) {
        repo.deleteById(walkID);
    }

    @Override
    public List<RoutingWalk> fetchAll(Long groupID) {
        return null;
    }

    @Override
    public RoutingWalk findByDest(Long groupID, String to) {
        return repo.findById(groupID).stream().filter(e -> e.getTo().equals(to)).findFirst().get();
    }
}
