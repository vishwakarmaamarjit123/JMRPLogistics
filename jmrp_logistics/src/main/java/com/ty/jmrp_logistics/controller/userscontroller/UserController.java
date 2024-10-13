package com.ty.jmrp_logistics.controller.userscontroller;

import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Loading;
import com.ty.jmrp_logistics.entity.Order;
import com.ty.jmrp_logistics.entity.Unloading;
import com.ty.jmrp_logistics.exception.UnAuthorizedUserException;
import com.ty.jmrp_logistics.service.service.LoadingService;
import com.ty.jmrp_logistics.service.service.OrderService;
import com.ty.jmrp_logistics.service.service.UnloadingService;
import com.ty.jmrp_logistics.utility.Authentication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private LoadingService loadingService;
    @Autowired
    private UnloadingService unloadingService;
    @Autowired
    private Authentication authentication;

   // private final String route="/user";

    public void authorization(String userRole){
        if(! userRole.equalsIgnoreCase("user")){
            throw  new UnAuthorizedUserException("role is invalid");
        }
    }

    @PostMapping("/order/save")
    public ResponseEntity<ResponseStructure<Order>> saveOrder(@Valid  @RequestBody Order order , @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.saveOrder(order);
    }

    @PutMapping("/loading/update")
    public ResponseEntity<ResponseStructure<Loading>> updateLoading(@Valid @RequestBody Loading loading , @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return loadingService.updateLoading(loading);
    }

    @PutMapping("/unloading/update")
    public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(@Valid @RequestBody Unloading unloading , @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return unloadingService.updateUnloading(unloading);
    }

    @PostMapping("/order/saveall")
    public ResponseEntity<ResponseStructure<Order>> saveAllOrder(@Valid @RequestBody Order order , @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.saveAllOrder(order);
    }

    @PutMapping("/order/update")
    public ResponseEntity<ResponseStructure<Order>> updateOrder(@Valid  @RequestBody Order order , @CookieValue String userRole){
        authorization(userRole);
        authentication.isAuthorized();
        return orderService.updateAllOrder(order);
    }





}
