package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.model.RoutingGroup;
import com.divby0exc.routingpool.model.RoutingMember;
import com.divby0exc.routingpool.model.RoutingVehicle;
import com.divby0exc.routingpool.model.RoutingWalk;
import com.divby0exc.routingpool.service.CarService;
import com.divby0exc.routingpool.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/group_transport/*")
public class RoutingController {

    @Autowired
    private WebClient.Builder webClient;
    @Autowired
    GroupService groupService;
    @Autowired
    CarService carService;

    @PostMapping("create_group")
    public String createGroup(@RequestBody RoutingGroup group) {
        groupService.save(group);

        return "Group has been created";
    }
    @PostMapping("add_member/{groupID}")
    public String addMemberToGroup(@PathVariable("groupID") int groupID, @RequestBody RoutingMember member) {
        groupService.save(groupID, member);

        return "Member has been added to group";
    }
    @PostMapping("assign_car/{groupID}")
    public String assignCarToGroup(@PathVariable("groupID") int groupID, @RequestBody RoutingVehicle vehicle) {
        carService.save(groupID, vehicle);

        return "Assigned car to group";
    }
    @DeleteMapping("deassign_car/{groupID}/{carID}")
    public String deassignCarFromGroup(@PathVariable("groupID") int groupID, @PathVariable("carID") int carID) {
        carService.delete(groupID, carID);

        return "Car has been removed from group";
    }
    @GetMapping("fetch_cars/{groupID}")
    public List<RoutingVehicle> getAllCarsInGroup(@PathVariable("groupID") int groupID) {
        /***
         * Hämta en lista över fordon tillhörande gruppen
         * Här ska det även framgå vart fordonet är placerat
         * och ifall den är tillgänglig eller redan används av en annan gruppmedlem.
         */
        List<RoutingVehicle> carList = new ArrayList<>(carService.fetchAll(groupID));

                return carList;
    }
    @PostMapping("set_available/{groupID}/{carID}")
    public String setCarAvailability(@PathVariable("groupID") int groupID, @PathVariable("carID") int carID) {
        /***
         * Sätta ett viss fordon i gruppen som upptagen.
         * Det ska även gå att sätta hur länge fordonet förväntas vara upptagen
         * Tiden ska utgå från en rutt hämtad från api:et som hanterar enskild transport.
         */

        Integer timeLeft = webClient.build()
                .get()
                .uri("get_time_left/" + groupID + "/" + carID)
                .retrieve()
                .bodyToMono(Integer.class)
                        .block();

        carService.setAvailability(groupID, carID, timeLeft);

        return "Car has been set unavailable until " + timeLeft;
    }
    @PostMapping("register_walk/{groupID}")
    public String registerGroupWalks(@PathVariable("groupID") int groupID, @RequestBody RoutingWalk walk) {
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

        groupService.save(groupID, walk);

        return "Scheduled walk";
    }
    @DeleteMapping("unregister_walk/{groupID}/{walkID}")
    public String unregisterGroupWalks(@PathVariable("groupID") int groupID, @PathVariable("walkID") int walkID) {
        groupService.delete(groupID, walkID);

        return "Scheduled walk has been canceled";
    }
    @PostMapping
    public String buyCar() {
        return null;
    }
    @DeleteMapping
    public String sellCar() {
        return null;
    }
    /***
     * Skapa grupper
     * Registrera nya medlemmar i en grupp
     * Lägga till fordon tillhörande gruppen
     * Ta bort fordon tillhörande gruppen
     * Hämta en lista över fordon tillhörande gruppen
     * Här ska det även framgå vart fordonet är placerat och ifall
     *  den är tillgänglig eller redan används av en annan gruppmedlem.
     * Sätta ett viss fordon i gruppen som upptagen. Det ska även gå att
     *  sätta hur länge fordonet förväntas vara upptagen
     * Tiden ska utgå från en rutt hämtad från api:et som
     *  hanterar enskild transport.
     * Registrera grupp-promenader.
     * Promenadens rutt hämtas från tjänsten
     *  som hanterar enskild transport.
     * Avregistrera promenader
     * Individ ska därför kunna skapa promenader och annonsera ut dem i gruppen.
     *  Vidare ska även individ kunna ändra på plats och tillgänglig av olika fordon
     *  samt köpa in eller ta bort fordon till eller ifrån gruppen.
     * Summering:
     */
}
