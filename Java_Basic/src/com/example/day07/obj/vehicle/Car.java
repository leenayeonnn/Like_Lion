package com.example.day07.obj.vehicle;

import com.example.day07.inter.Vehicle;

public class Car implements Vehicle {
    private int speed;

    @Override
    public void accelerate(int increase) {
        this.speed += increase;
        if (this.speed > MAX_SPEED) {
            this.speed = MAX_SPEED;
        }
        System.out.println("speed : " + this.speed);
    }

    @Override
    public void decelerate(int decrease) {
        this.speed -= decrease;
        if (this.speed < 0) {
            this.speed = 0;
        }
        System.out.println("speed : " + this.speed);
    }
}
