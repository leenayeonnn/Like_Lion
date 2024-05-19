package com.example.day07.main.inter;

import com.example.day07.inter.Vehicle;
import com.example.day07.obj.vehicle.Car;

public class Test10 {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate(100);
        car.accelerate(30);
        car.decelerate(30);
        car.decelerate(40);

        Vehicle vehicle = new Car();
        vehicle.accelerate(100);
        vehicle.decelerate(30);
    }
}
