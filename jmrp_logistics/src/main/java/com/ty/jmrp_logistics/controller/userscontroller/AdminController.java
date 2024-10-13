package com.ty.jmrp_logistics.controller.userscontroller;

import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.*;
import com.ty.jmrp_logistics.exception.UnAuthorizedUserException;
import com.ty.jmrp_logistics.service.service.*;
import com.ty.jmrp_logistics.utility.Authentication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoadingService loadingService;
    @Autowired
    private UnloadingService unloadingService;
    @Autowired
    private CarriersService carriersService;
    @Autowired
    private TruckService truckService;
    @Autowired
    private Authentication authentication;

   // private final String route="/admin/";

    public void authorization(String userRole){
        if(!(userRole.equalsIgnoreCase("admin"))){
            throw  new UnAuthorizedUserException("role is invalid");
        }
    }


    @PostMapping("order/save")
    public ResponseEntity<ResponseStructure<Order>> saveOrderAll(@Valid @RequestBody Order order , @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.saveAllOrder(order);
    }

    @PutMapping("order/update")
    public ResponseEntity<ResponseStructure<Order>> updateOrder(@Valid @RequestBody Order order, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.updateAllOrder(order);
    }


    @GetMapping("order/view")
    public ResponseEntity<ResponseStructure<List<Order>>> viewAllOrder(@Valid @CookieValue String userRole){
      System.out.println(userRole);
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.findAllOrder();
    }

    //working done
    @DeleteMapping("order/delete/{id}")
    public ResponseEntity<ResponseStructure<Order>> deleteOrder(@Valid @PathVariable int id, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.deleteOrderByID(id);
    }

    @PostMapping("truck/add")
    public ResponseEntity<ResponseStructure<Truck>> saveTruck(@Valid @RequestBody Truck truck, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return truckService.saveTruck(truck);
    }

    @PutMapping("truck/update")
    public ResponseEntity<ResponseStructure<Truck>> updateTruck(@RequestBody Truck truck, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return truckService.updateTruck(truck);
    }

    @DeleteMapping("truck/delete/{id}")
    public ResponseEntity<ResponseStructure<Truck>> deleteTruck(@Valid @PathVariable int id, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return truckService.deleteTruckByID(id);
    }

    @GetMapping("truck/view")
    public ResponseEntity<ResponseStructure<List<Truck>>> viewTruck(@Valid @CookieValue(value = "userRole") String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return truckService.findAllTruck();
    }

    @PostMapping("user/add")
    public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return userService.saveUser(user);
    }

    @PutMapping("user/update")
    public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestBody User user, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return userService.updateUser(user);
    }

    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid @PathVariable int id, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return userService.deleteUserByID(id);
    }

    @GetMapping("user/view")
    public ResponseEntity<ResponseStructure<List<User>>> viewUser(){
       // System.out.println(userRole);
       // authorization(userRole);
        authentication.isAuthorized();
        return userService.findAllUser();
    }

    @GetMapping("user/viewid")
    public ResponseEntity<ResponseStructure<User>> viewbyidUser(@Valid @RequestParam int id , @CookieValue String userRole){
        authentication.isAuthorized();
        return userService.findByIdUser(id);
    }

    @PutMapping("carrier/update")
    public ResponseEntity<ResponseStructure<Carriers>> updateCarrier(@Valid @RequestBody Carriers carriers, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return carriersService.updateCarrier(carriers);
    }

    @PostMapping("carrier/add")
    public ResponseEntity<ResponseStructure<Carriers>> saveCarrier(@Valid @RequestBody Carriers carriers, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return carriersService.saveCarriers(carriers);
    }

    @GetMapping("carrier/view")
    public ResponseEntity<ResponseStructure<List<Carriers>>> viewCarrier(@Valid @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return carriersService.findAllCarrier();
    }

    @PutMapping("loading/update")
    public ResponseEntity<ResponseStructure<Loading>> updateLoading(@Valid @RequestBody Loading loading, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return loadingService.updateLoading(loading);
    }

    @PostMapping("loading/add")
    public ResponseEntity<ResponseStructure<Loading>> saveLoading(@Valid @RequestBody Loading loading, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return loadingService.saveLoading(loading);
    }

    @GetMapping("loading/view")
    public ResponseEntity<ResponseStructure<List<Loading>>> viewLoading(@Valid @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return loadingService.findAllLoading();
    }

    @PutMapping("unloading/update")
    public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(@Valid @RequestBody Unloading unloading, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return unloadingService.updateUnloading(unloading);
    }

    @PostMapping("unloading/add")
    public ResponseEntity<ResponseStructure<Unloading>> saveUnloading(@Valid @RequestBody Unloading unloading, @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return unloadingService.saveUnloading(unloading);
    }

    @GetMapping("unloading/view")
    public ResponseEntity<ResponseStructure<List<Unloading>>> viewUnloading(@Valid @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return unloadingService.findAllUnloading();
    }






}
