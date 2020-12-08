package com.SpringBoot.SpringBootThymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import com.SpringBoot.SpringBootThymeleaf.form.CarForm;
import com.SpringBoot.SpringBootThymeleaf.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


//Add le stereotype Controller du framework Spring
@Controller
public class MainController {

    private static List<Car> cars = new ArrayList<Car>();
    private int id;

    static {
        cars.add(new Car(1, "Fiesta", "Ford", "noire"));
        cars.add(new Car(2, "Mondeo", "Ford", "gris"));
        cars.add(new Car(3, "A7", "Audi", "noire"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value= {"/index"},method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = {"/carList"}, method = RequestMethod.GET)
    public String carList(Model model){
        model.addAttribute("cars", cars);
        return "carList";
    }


}
