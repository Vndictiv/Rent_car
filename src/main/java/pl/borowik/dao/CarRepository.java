package pl.borowik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Car extends JpaRepository<Car, Integer> {

}
