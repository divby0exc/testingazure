package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.model.RoutingVehicle;
import com.divby0exc.routingpool.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group_transport/*")
public class VehicleController {
    @Autowired
    private WebClient.Builder webClient;
    @Autowired
    CarService carService;

    @PostMapping("assign_car")
    public String assignCarToGroup(@RequestBody RoutingVehicle vehicle) {
        carService.addVehicle(vehicle);

        return "Assigned car to group";
    }
    @GetMapping("show_cars/{groupID}")
    public List<RoutingVehicle> showAllCarsInGroup(@PathVariable("groupID") Long groupID) {
        return carService.getAllCars(groupID);
    }
    @DeleteMapping("deassign_car/{groupID}/{carID}")
    public String deassignCarFromGroup(@PathVariable("carID") Long carID) {
        carService.deleteVehicle(carID);

        return "Car has been removed from group";
    }
    @GetMapping("fetch_cars/{groupID}")
    public List<RoutingVehicle> getAllCarsInGroup(@PathVariable("groupID") Long groupID) {
        /***
         * Hämta en lista över fordon tillhörande gruppen
         * Här ska det även framgå vart fordonet är placerat
         * och ifall den är tillgänglig eller redan används av en annan gruppmedlem.
         */

        return carService.getAllCars(groupID);
    }
    @PostMapping("set_available/{carID}")
    public String setCarAvailability(@PathVariable("carID") Long carID) {
        /***
         * Sätta ett viss fordon i gruppen som upptagen.
         * Det ska även gå att sätta hur länge fordonet förväntas vara upptagen
         * Tiden ska utgå från en rutt hämtad från api:et som hanterar enskild transport.
         */

        Integer timeLeft = webClient.build()
                .get()
                .uri("get_time_left/" + carID)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();

        carService.setAvailability(carID, timeLeft);

        return "Car has been set unavailable until " + timeLeft + " seconds.";
    }
    @PostMapping
    public String buyCar() {
        return null;
    }
    @DeleteMapping
    public String sellCar() {
        return null;
    }
}
