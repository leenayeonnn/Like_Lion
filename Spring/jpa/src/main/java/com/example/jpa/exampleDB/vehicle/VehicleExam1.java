package com.example.jpa.exampleDB.vehicle;

import com.example.jpa.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleExam1 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

//        Car car1 = new Car();
//        car1.setManufacturer("Toyota");
//        car1.setSeatCount(5);
//        em.persist(car1);
//
//        Car car2 = new Car();
//        car2.setManufacturer("Hyundai");
//        car2.setSeatCount(4);
//        em.persist(car2);
//
//        Truck truck = new Truck();
//        truck.setManufacturer("KIA");
//        truck.setPayloadCapacity(20);
//        em.persist(truck);
//

        List<Vehicle> vehicles = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList();

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                log.info("Car info : {}", car.getSeatCount());
            } else {
                Truck truck = (Truck) vehicle;
                log.info("Truck info : {}", truck.getPayloadCapacity());
            }
        }

        em.getTransaction().commit();
    }
}
