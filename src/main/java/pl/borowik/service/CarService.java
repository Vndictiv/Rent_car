package pl.borowik.service;

import pl.borowik.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    public List<Car> findAll();

    void save(Car theCar);

    void deleteById(int theId);

    Car findById(int theId);

}
