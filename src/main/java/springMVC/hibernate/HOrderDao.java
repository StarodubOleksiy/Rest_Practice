package springMVC.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import springMVC.dao.OrderDao;
import springMVC.model.Orders;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 09.06.16.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o ").list();
    }


    @Override
    public List<Orders> findOpenOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o where state = 'open'").list();
    }


    @Override
    public List<Orders> findCloseOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o where state = 'close'").list();
    }

    @Override
    public void save(Orders order) {
     sessionFactory.getCurrentSession().save(order);
    }


    @Override
    public Orders findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return  (Orders) session.get(Orders.class, id);
    }

    @Override
    public void updateDish(Orders orders)
    {
       sessionFactory.getCurrentSession().update(orders);
    }

    @Override
    public void setClose(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Orders orders = session.get(Orders.class, id);
        orders.setState("close");
        sessionFactory.getCurrentSession().update(orders);
    }

    @Override
    public void remove(Long id) throws  IOException{

        if(findById(id).getState().equals("close"))
            throw new IOException("Delete close order is forbidden");
        sessionFactory.getCurrentSession().delete(findById(id));
    }


}
