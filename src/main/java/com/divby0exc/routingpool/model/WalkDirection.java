package com.divby0exc.routingpool.model;

import lombok.Data;

@Data
public class WalkDirection {
        private String owner;
        private String path;
        private String destination;
        private double estimatedArrivalTime;
        private String steps;
        private boolean weather;
}
