package com.ty.jmrp_logistics.service.service;

import com.ty.jmrp_logistics.DAO.*;
import com.ty.jmrp_logistics.DTO.ResponseStructure;
import com.ty.jmrp_logistics.entity.Carriers;
import com.ty.jmrp_logistics.entity.Driver;
import com.ty.jmrp_logistics.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CarriersDao carriersDao;
    @Autowired
    private CargoDao cargoDao;
    @Autowired
    private LoadingDao loadingDao;
    @Autowired
    private UnloadingDao unloadingDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DriverDao driverDao;
    @Autowired
    private AddressDao addressDao;



    public ResponseEntity<ResponseStructure<Order>> saveOrder(Order order){
        ResponseStructure<Order> responseStructure ;
        boolean flag = true;
        if (order!=null){
            order= orderDao.saveOrder(order);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), order, "Order Created");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not created");
        }
        return new ResponseEntity<ResponseStructure<Order>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Order>> updateOrder(Order order){
        ResponseStructure<Order> responseStructure ;
        boolean flag = true;
        if (order!=null){
            order= orderDao.updateOrder(order);
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), order, "Order updated");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not updated");
        }
        return new ResponseEntity<ResponseStructure<Order>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Order>> findByIdOrder(int id){
        ResponseStructure<Order> responseStructure ;
        boolean flag = true;
        Order order = orderDao.findById(id);
        if (order!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), order, "Order found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not found");
        }
        return new ResponseEntity<ResponseStructure<Order>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<List<Order>>> findAllOrder(){
        ResponseStructure<List<Order>> responseStructure ;
        boolean flag = true;
        List<Order> list = orderDao.findAll();
        if (list!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), list, "Order found");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not found");
        }
        return new ResponseEntity<ResponseStructure<List<Order>>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ResponseStructure<Order>> deleteOrderByID(int id){
        ResponseStructure<Order> responseStructure ;
        boolean flag = true;
        Order order = orderDao.findById(id);
        order.setUnloadingUser(null);
        order.setLoadingUser(null);
        order = orderDao.updateOrder(order);

        order = orderDao.deleteById(id);

        if (order!=null){
            responseStructure= new ResponseStructure<>(HttpStatus.OK.value(), order, "Order deleted");
        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not delete or not exist");
        }
        return new ResponseEntity<ResponseStructure<Order>>(responseStructure, (flag==true ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
    }



    public ResponseEntity<ResponseStructure<Order>> saveAllOrder(Order order){
        ResponseStructure<Order> responseStructure ;
        boolean flag = true;
        if (order!=null){
            if (order.getCargo() != null){
                cargoDao.saveCargo(order.getCargo());
            }
            if (order.getCarriers()!=null){
                Carriers carriers = order.getCarriers();
                List<Driver> list = order.getCarriers().getDriver();
                List<Driver> list1 = new ArrayList<>();
                List<Driver> list2 = new ArrayList<>();
                List<Carriers> carriersList = new ArrayList<>();
                for (int i=0; i< list.size(); i++){
                   list1.add(list.get(i));
                   list2.add(list.get(i));
                }
                for (int i = 0; i < list.size(); i++) {
                   if(list.get(i)!=null) carriersList.add(list.get(i).getCarriers());
                }

                for (Driver driver : list1){
                    driver.setCarriers(null);
                }

                for (Driver driver:list1){
                    driverDao.saveDriver(driver);
                }

                carriersDao.saveCarriers(order.getCarriers());
                carriers.setDriver(null);
                for (int i=0; i<list2.size(); i++){
                    list2.get(i).setCarriers(carriers);
                    driverDao.updateDriver(list2.get(i));
                }
            }
            if (order.getLoading() !=null){
                addressDao.saveAddress(order.getLoading().getAddress());
                loadingDao.saveLoading(order.getLoading());
            }
            if (order.getUnloading()!=null){
                addressDao.saveAddress(order.getUnloading().getAddress());
                unloadingDao.saveUnloading(order.getUnloading());
            }

            order= orderDao.saveOrder(order);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), order, "Order Created");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not created");
        }
        return new ResponseEntity<ResponseStructure<Order>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }


    public ResponseEntity<ResponseStructure<Order>> updateAllOrder(Order order){
        ResponseStructure<Order> responseStructure ;
        boolean flag = true;
        if (order!=null){
            if (order.getCargo() != null){
                cargoDao.updateCargo(order.getCargo());
            }
            if (order.getCarriers()!=null){
                Carriers carriers = order.getCarriers();
                List<Driver> list = order.getCarriers().getDriver();
                List<Driver> list1 = new ArrayList<>();
                List<Driver> list2 = new ArrayList<>();
                List<Carriers> carriersList = new ArrayList<>();
                for (int i=0; i< list.size(); i++){
                    list1.add(list.get(i));
                    list2.add(list.get(i));
                }
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i)!=null) carriersList.add(list.get(i).getCarriers());
                }

                for (Driver driver : list1){
                    driver.setCarriers(null);
                }

                for (Driver driver:list1){
                    driverDao.updateDriver(driver);
                }

                carriersDao.updateCarriers(order.getCarriers());
                carriers.setDriver(null);
                for (int i=0; i<list2.size(); i++){
                    list2.get(i).setCarriers(carriers);
                    driverDao.updateDriver(list.get(i));
                }

            }
            if (order.getLoading() !=null){
                addressDao.updateAddress(order.getLoading().getAddress());
                loadingDao.updateLoading(order.getLoading());
            }
            if (order.getUnloading()!=null){
                addressDao.updateAddress(order.getUnloading().getAddress());
                unloadingDao.updateUnloading(order.getUnloading());
            }
            order= orderDao.updateOrder(order);
            responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(), order, "Order updated");

        }
        else {
            flag = false;
            responseStructure = new ResponseStructure<>(HttpStatus.BAD_REQUEST.value(), null, "Order not updated");
        }
        return new ResponseEntity<ResponseStructure<Order>>(responseStructure, (flag==true ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST));
    }


}
