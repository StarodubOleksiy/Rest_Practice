package springMVC.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment" , strategy = "increment")
    @Column(name = "id")
    private long id;



    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee waiter;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )

    private List<Dish> dishes;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "order_date")
    private String orderDate;



    @Column(name = "state")
    private String state;

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (tableNumber != orders.tableNumber) return false;
        if (!dishes.equals(orders.dishes)) return false;
        if (!orderDate.equals(orders.orderDate)) return false;
        if (!state.equals(orders.state)) return false;
        if (!waiter.equals(orders.waiter)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = waiter.hashCode();
        result = 31 * result + dishes.hashCode();
        result = 31 * result + tableNumber;
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID =" + id +
                " waiter=" + waiter +
                ", tableNumber=" + tableNumber +
                ", orderDate='" + orderDate + '\'' +
                ", state='" + state + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
