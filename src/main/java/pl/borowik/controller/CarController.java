package pl.borowik.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.concurrent.TimeUnit;

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
    public String rentCarDetails(@RequestParam("carId") int theCarId,
                                 @ModelAttribute("rentDate") RentDate theRentDate,
                                 Model theModel) throws Exception{


            Car validCar = carService.findById(theCarId);

            if(validCar.getRented() == true){
                throw new Exception("Select other car");
            }
            else {


                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String userName = ((UserDetails) principal).getUsername();
                User theUser = userService.findByEmail(userName);


                theRentDate.setUser(theUser);
                theRentDate.setCar(carService.findById(theCarId));



                theModel.addAttribute("rentDate", theRentDate);


            }

        return "rent-details";
    }

    @GetMapping("/rentCarGet")
    public String rentForm(Model theModel){

        RentDate theRentDate = new RentDate();

        theModel.addAttribute("rentDate", theRentDate);

        return "rent-details";
    }

    @PostMapping("/rent")
    public String addRent(@ModelAttribute("rentDate")RentDate theRentDate, Model theModel) throws Exception{

        if(theRentDate.getRentDate().compareTo(theRentDate.getReturnDate()) > 0){
            throw new Exception();
        }
        else
            rentDateService.save(theRentDate);

        Car theCar = theRentDate.getCar();
        theCar.setRented(true);
        carService.save(theCar);


       long daysBetween = ((theRentDate.getReturnDate().getTime() - theRentDate.getRentDate().getTime()));

       double thePrice = (TimeUnit.DAYS.convert(daysBetween, TimeUnit.MILLISECONDS)) * (theCar.getDailyCost());


        theModel.addAttribute("price", thePrice);

        return "rent-confirmation";
    }


    @GetMapping("/rent/confirmation")
    public String rentConfirmation(){


        return "rent-confirmation";
    }


}
