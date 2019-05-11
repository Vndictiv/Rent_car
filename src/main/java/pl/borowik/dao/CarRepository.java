package pl.borowik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.borowik.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
