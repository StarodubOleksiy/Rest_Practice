package springMVC.dao;

import springMVC.model.Orders;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 09.06.16.
 */
public interface OrderDao {
void save(Orders order);
 List<Orders> findAllOrders();
 Orders findById(Long id);
 void updateDish(Orders orders);
 void setClose(Long id);
 public List<Orders> findOpenOrders();
 public List<Orders> findCloseOrders();
 void remove(Long id) throws IOException;

}
