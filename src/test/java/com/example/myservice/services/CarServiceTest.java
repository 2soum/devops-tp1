package com.example.myservice.services;

import com.example.myservice.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void testAddCar() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        assertEquals(1, carService.getCars().size());
    }

    @Test
    void testGetCars() {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));
        carService.addCar(new Car("DEF456", "Honda", 12000.0));
        List<Car> cars = carService.getCars();
        assertEquals(2, cars.size());
    }

    @Test
    void testGetCarByPlateNumber() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        Car found = carService.getCar("ABC123");
        assertNotNull(found);
        assertEquals("Toyota", found.getBrand());
    }

    @Test
    void testGetCarNotFound() {
        Car found = carService.getCar("NONEXISTENT");
        assertNull(found);
    }

    @Test
    void testAddMultipleCars() {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));
        carService.addCar(new Car("DEF456", "Honda", 12000.0));
        carService.addCar(new Car("GHI789", "BMW", 30000.0));
        assertEquals(3, carService.getCars().size());
    }
}
