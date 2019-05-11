package pl.borowik.controller;

import javafx.beans.binding.IntegerBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.borowik.model.Car;
import pl.borowik.model.RentDate;
import pl.borowik.model.User;
import pl.borowik.service.CarService;
import pl.borowik.service.RentDateService;
import pl.borowik.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    private final RentDateService rentDateService;

    private UserService userService;


    @Autowired
    public CarController(CarService theCarService, RentDateService rentDateService, UserService theUserService){
        carService = theCarService;
        this.rentDateService = rentDateService;
        userService = theUserService;
    }


    @GetMapping("/list")
    public String carList(Model model){

        List<Car> cars = carService.findAll();

        model.addAttribute("cars", cars);

        return "car";
    }

    @GetMapping("/carId")
    public String carInfo(@RequestParam("carID") int theCarId, Model theModel){

        Car car = carService.findById(theCarId);

        theModel.addAttribute("tempCar", car);

        return "rent-details";
    }


    @PostMapping("/rentCar")
    public String rentCarDetails(@RequestParam("carId") int theCarId,@ModelAttribute("rentDate") RentDate theRentDate, Model theModel){


            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String userName = ((UserDetails) principal).getUsername();

            User theUser = userService.findByEmail(userName);



            theRentDate.setUser(theUser);
            theRentDate.setCar(carService.findById(theCarId));


           // theModel.addAttribute("carId", theCar);

            theModel.addAttribute("rentDate", theRentDate);

        System.out.println(theRentDate.getCar());

        return "rent-details";
    }

    @GetMapping("/rentCarGet")
    public String rentForm(Model theModel){

        RentDate theRentDate = new RentDate();

        theModel.addAttribute("rentDate", theRentDate);

        return "rent-details";
    }

    @PostMapping("/rent")
    public String addRent(@ModelAttribute("rentDate")RentDate theRentDate) throws Exception{

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        String userName = ((UserDetails) principal).getUsername();
//
//        User theUser = userService.findByEmail(userName);
//        theRentDate.setUser(theUser);


        if(theRentDate.getRentDate().compareTo(theRentDate.getReturnDate()) > 0){
            throw new Exception();
        }
        else

        rentDateService.save(theRentDate);

        //wartość do przekazania dalej
       // double cena = theRentDate.getRentDate().compareTo(theRentDate.getReturnDate()) * (carService.findById().getDailyCost());


        return "redirect:/car/rent/confirmation";
    }

    @GetMapping("/rent/confirmation")
    public String rentConfirmation(){


        return "rent-confirmation";
    }


}
