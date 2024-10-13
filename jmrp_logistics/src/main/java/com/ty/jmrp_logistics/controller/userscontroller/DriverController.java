package com.ty.jmrp_logistics.controller.userscontroller;

import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Driver;
import com.ty.jmrp_logistics.exception.UnAuthorizedUserException;
import com.ty.jmrp_logistics.service.service.DriverService;
import com.ty.jmrp_logistics.utility.Authentication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private Authentication authentication;

    public void authorization(String userRole){
        if(!userRole.equalsIgnoreCase( "driver")){
            throw  new UnAuthorizedUserException("role is invalid");
        }
    }


    @PostMapping
    public ResponseEntity<ResponseStructure<Driver>> saveDriver(@Valid  @RequestBody Driver driver , @CookieValue String userRole){
        authentication.isAuthorized();
        return driverService.saveDriver(driver);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Driver>> updateDriver(@Valid @RequestBody Driver driver , @CookieValue String userRole){
        authentication.isAuthorized();
        return driverService.updateDriver(driver);
    }


}
