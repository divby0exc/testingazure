package com.divby0exc.routingpool.model;

import lombok.Data;

@Data
public class DriveDirection {
    private String owner;
    private String path;
    private String destination;
    private double estimatedArrivalTime;
    private String steps;
    private boolean weather;
}
