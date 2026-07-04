package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("Volvo", 1990, "blue"));
        cars.add(new Car("BMW", 1987, "red"));
        cars.add(new Car("Lincoln", 1982, "gray"));
        cars.add(new Car("Buick ", 1969, "green"));
        cars.add(new Car("Pontiac Firebird", 1987, "gold"));
    }

    @Override
    public List<Car> getCars(Integer count) {
        return cars.subList(0, count);
    }
}
