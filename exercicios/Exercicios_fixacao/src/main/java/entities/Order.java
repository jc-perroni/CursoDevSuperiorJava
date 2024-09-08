package entities;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private static final LocalDate MOMENTDATE = LocalDate.now();
    private OrderStatus status;
    private List<OrderItem> ordensItems = new ArrayList<>();

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrdensItems() {
        return ordensItems;
    }

    public Order(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        ordensItems.add(item);
    }

    public void removeItem(OrderItem item){
        ordensItems.remove(item);
    }

}
