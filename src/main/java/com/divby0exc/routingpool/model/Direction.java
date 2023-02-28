package com.divby0exc.routingpool.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Direction {
        private String owner;
        private String path;
        private String destination;
        private double estimatedArrivalTime;
        private String steps;
        private boolean trafficjam;
}
