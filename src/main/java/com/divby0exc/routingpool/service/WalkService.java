package com.divby0exc.routingpool.service;

import com.divby0exc.routingpool.model.RoutingWalk;
import com.divby0exc.routingpool.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkService {
    @Autowired
    private WalkRepository repo;

    public RoutingWalk addWalk(RoutingWalk walk) {
        return repo.save(walk);
    }
    public void deleteWalk(Long walkID) {
        repo.deleteRoutingWalkById(walkID);
    }
    public List<RoutingWalk> getAllWalks(Long id) {
        return repo.findAllByGroupID(id);
    }
    public RoutingWalk findWalkInGroupByDest(Long groupID, String to) {
        return repo.findRoutingWalkByGroupIDAndTo(groupID, to);
    }
    public boolean updateWalk(Long id, String to, RoutingWalk newWalk) {
        RoutingWalk oldWalk = findWalkInGroupByDest(id, to);
        if(oldWalk!=null) {
            addWalk(newWalk);
            return true;
        }
        return false;
    }
}
