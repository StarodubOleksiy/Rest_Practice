package springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springMVC.model.Menu;
import springMVC.model.Orders;
import springMVC.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 22.08.16.
 */
@Controller
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/openOrders", method = RequestMethod.GET)
 // @ResponseBody
    public List<Orders> openOrders() {
        return orderService.getOpenOrders();
    }

    @RequestMapping(value = "/orderById/{orderId}", method = RequestMethod.GET)
    // @ResponseBody
    public Orders orderById(@PathVariable long orderId) {
        return orderService.getOrderById(orderId);
    }


    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    // @ResponseBody
    public List<Orders> orders() {
        return orderService.getOrders();
    }

    @RequestMapping(value = "/closeOrders", method = RequestMethod.GET)
    // @ResponseBody
    public List<Orders> closeOrders() {
        return orderService.getCloseOrders();
    }


}
