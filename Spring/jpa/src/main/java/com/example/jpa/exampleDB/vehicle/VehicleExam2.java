package com.example.jpa.exampleDB.vehicle;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleExam2 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

//        Car2 car1 = new Car2();
//        car1.setManufacturer("Toyota");
//        car1.setSeatCount(5);
//        em.persist(car1);
//
//        Car2 car2 = new Car2();
//        car2.setManufacturer("Hyundai");
//        car2.setSeatCount(4);
//        em.persist(car2);
//
//        Truck2 truck = new Truck2();
//        truck.setManufacturer("KIA");
//        truck.setPayloadCapacity(20);
//        em.persist(truck);
//        em.getTransaction().commit();

        List<Vehicle2> vehicles = em.createQuery("SELECT v FROM Vehicle2 v", Vehicle2.class).getResultList();
        for (Vehicle2 vehicle : vehicles) {
            if (vehicle instanceof Car2) {
                Car2 car = (Car2) vehicle;
                System.out.println("Car: " + car.getManufacturer() + ", Seats: " + car.getSeatCount());
            } else if (vehicle instanceof Truck2) {
                Truck2 truck = (Truck2) vehicle;
                System.out.println(
                        "Truck: " + truck.getManufacturer() + ", Payload Capacity: " + truck.getPayloadCapacity());
            }
        }

        em.close();
    }
}
