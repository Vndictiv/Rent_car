package pl.borowik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borowik.model.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findById(int theId);

}
