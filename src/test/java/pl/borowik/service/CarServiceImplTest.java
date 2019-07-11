package pl.borowik.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.borowik.dao.CarRepository;
import pl.borowik.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarServiceImpl carService;

    Car carToReturn;


    @BeforeEach
    void setUp() {

        carToReturn  = new Car(1,"sedan", "renault", "laguna", 100.0, false);
    }

    @Test
    void findAll() {

        List<Car> returnCars = new ArrayList<>();
        returnCars.add(new Car(1,"sedan", "renault", "laguna", 300.0, false));
        returnCars.add(new Car(2,"sedan", "mazda", "6", 60.0, false));


        when(carRepository.findAll()).thenReturn(returnCars);

        List<Car> cars = carService.findAll();

        assertNotNull(cars);
        assertEquals(2, cars.size());



    }

    @Test
    void save() {

        carService.save(carToReturn);

        verify(carRepository).save(any(Car.class));


    }

    @Test
    void deleteById() {

        carService.deleteById(carToReturn.getCarId());

        verify(carRepository).deleteById(anyInt());
    }

    @Test
    void findById() {
        Car carHere = new Car(1,"sedan", "renault", "laguna", 100.0, false);

        when(carRepository.findById(carHere.getCarId())).thenReturn(carToReturn);

        Car car = carService.findById(1);

        assertEquals(carToReturn, car);
        assertNotNull(car);

    }
}