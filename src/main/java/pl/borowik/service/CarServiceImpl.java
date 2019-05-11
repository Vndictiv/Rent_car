package pl.borowik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.borowik.dao.CarRepository;
import pl.borowik.model.Car;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository theCarRepository){
        carRepository=theCarRepository;
    }


    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void save(Car theCar) {

        carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }

    @Override
    public Car findById(int theId) {


        Car theCar = carRepository.findById(theId);

        return theCar;
    }
}
