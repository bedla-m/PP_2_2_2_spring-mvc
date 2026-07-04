package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;

    public CarController() {
        this.carService = new CarServiceImpl();
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(required = false) Integer count, ModelMap model) {
        Integer cnt = (count == null || count <= 0 || count >= 5) ? carService.getCars(5).size() : count;
        List<Car> cars = carService.getCars(cnt);
        model.addAttribute("cars", cars);
        return "cars"; //cars_bootstrap - html с бутстрапом
    }
}
