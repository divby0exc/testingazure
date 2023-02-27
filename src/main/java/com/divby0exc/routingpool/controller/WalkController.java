package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.model.RoutingWalk;
import com.divby0exc.routingpool.service.WalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/group_transport/*")
public class WalkController {
    @Autowired
    private WebClient.Builder webClient;
    @Autowired
    WalkService walkService;

    @PostMapping("register_walk")
    public String registerGroupWalks(@RequestBody RoutingWalk walk) {
        /***
         * Registrera grupp-promenader.
         * Promenadens rutt hämtas från tjänsten som hanterar enskild transport.
         */
        webClient.build()
                .get()
                .uri("walk_route")
                .retrieve()
                .bodyToMono(String.class)
                .toString();

        walkService.save(walk);

        return "Scheduled walk";
    }
    @DeleteMapping("unregister_walk/{walkID}")
    public String unregisterGroupWalks(@PathVariable("walkID") Long walkID) {
        walkService.delete(walkID);

        return "Scheduled walk has been canceled";
    }
}
