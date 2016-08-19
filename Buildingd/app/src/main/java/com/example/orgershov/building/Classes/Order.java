package com.example.orgershov.building.Classes;

import java.io.Serializable;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class Order  implements Serializable {
    static private int OrderID;
    private String from;
    private String to;
    private String order;

    public Order() {
    }

    /**
     *
     * @param from
     * @param to
     * @param order
     */
    public Order(String from, String to, String order) {
        this.from = from;
        this.to = to;
        this.order = order;
    }




    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
