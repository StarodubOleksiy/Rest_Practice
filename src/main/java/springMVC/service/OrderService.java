package springMVC.service;

import org.springframework.transaction.annotation.Transactional;
import springMVC.dao.OrderDao;
import springMVC.model.Employee;
import springMVC.model.Menu;
import springMVC.model.Orders;

import java.util.List;

/**
 * Created by Администратор on 22.08.16.
 */
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }




    @Transactional
    public List<Orders> getOrders() {
        return orderDao.findAllOrders();
    }

    @Transactional
    public List<Orders> getOpenOrders() {
        return orderDao.findOpenOrders();
    }

    @Transactional
    public List<Orders> getCloseOrders() {
        return orderDao.findCloseOrders();
    }


    @Transactional
    public Orders getOrderById(Long id){
        return orderDao.findById(id);
    }
}
