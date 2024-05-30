package com.example.jpa.exampleDB.vehicle;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleExam3 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

//        Car3 car1 = new Car3();
//        car1.setManufacturer("Toyota");
//        car1.setSeatCount(5);
//        em.persist(car1);
//
//        Car3 car2 = new Car3();
//        car2.setManufacturer("Hyundai");
//        car2.setSeatCount(4);
//        em.persist(car2);
//
//        Truck3 truck = new Truck3();
//        truck.setManufacturer("KIA");
//        truck.setPayloadCapacity(20);
//        em.persist(truck);
//        em.getTransaction().commit();

        List<Vehicle3> vehicles = em.createQuery("SELECT v FROM Vehicle3 v", Vehicle3.class).getResultList();
        for (Vehicle3 vehicle : vehicles) {
            if (vehicle instanceof Car3) {
                Car3 car = (Car3) vehicle;
                System.out.println("Car: " + car.getManufacturer() + ", Seats: " + car.getSeatCount());
            } else if (vehicle instanceof Truck3) {
                Truck3 truck = (Truck3) vehicle;
                System.out.println(
                        "Truck: " + truck.getManufacturer() + ", Payload Capacity: " + truck.getPayloadCapacity());
            }
        }

        em.close();
    }
}
