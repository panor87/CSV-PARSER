package com.rod.demo.entity;

import javax.persistence.*;

//Hibernate
@Entity
//Spring
@Table
public class Venta {
    @Id
    @SequenceGenerator(
            name = "venta_sequence",
            sequenceName = "",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "venta_sequence"
    )
    private Long id;

    private String region;
    private String country;
    private String item_type;
    private String sales_channel;
    private String order_priority;
    private String order_date;
    private Long order_id;
    private String ship_date;
    private Long units_sold;
    private Float unit_price;
    private Float unit_cost;
    private Double total_revenue;
    private Double total_cost;
    private Double total_profit;

    public Venta(){
    }

    public Venta(Long id, String region, String country,
                 String item_type, String sales_channel,
                 String order_priority, String order_date, Long order_id,
                 String ship_date, Long units_sold, Float unit_price,
                 Float unit_cost, Double total_revenue,
                 Double total_cost, Double total_profit) {

        this.id = id;
        this.region = region;
        this.country = country;
        this.item_type = item_type;
        this.sales_channel = sales_channel;
        this.order_priority = order_priority;
        this.order_date = order_date;
        this.order_id = order_id;
        this.ship_date = ship_date;
        this.units_sold = units_sold;
        this.unit_price = unit_price;
        this.unit_cost = unit_cost;
        this.total_revenue = total_revenue;
        this.total_cost = total_cost;
        this.total_profit = total_profit;
    }

    public Venta(String region, String country,
                 String item_type, String sales_channel,
                 String order_priority, String order_date, Long order_id,
                 String ship_date, Long units_sold, Float unit_price,
                 Float unit_cost, Double total_revenue,
                 Double total_cost, Double total_profit) {

        this.region = region;
        this.country = country;
        this.item_type = item_type;
        this.sales_channel = sales_channel;
        this.order_priority = order_priority;
        this.order_date = order_date;
        this.order_id = order_id;
        this.ship_date = ship_date;
        this.units_sold = units_sold;
        this.unit_price = unit_price;
        this.unit_cost = unit_cost;
        this.total_revenue = total_revenue;
        this.total_cost = total_cost;
        this.total_profit = total_profit;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getSales_channel() {
        return sales_channel;
    }

    public void setSales_channel(String sales_channel) {
        this.sales_channel = sales_channel;
    }

    public String getOrder_priority() {
        return order_priority;
    }

    public void setOrder_priority(String order_priority) {
        this.order_priority = order_priority;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public String getShip_date() {
        return ship_date;
    }

    public void setShip_date(String ship_date) {
        this.ship_date = ship_date;
    }

    public Long getUnits_sold() {
        return units_sold;
    }

    public void setUnits_sold(Long units_sold) {
        this.units_sold = units_sold;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }

    public Float getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(Float unit_cost) {
        this.unit_cost = unit_cost;
    }

    public Double getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(Double total_revenue) {
        this.total_revenue = total_revenue;
    }

    public Double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }

    public Double getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(Double total_profit) {
        this.total_profit = total_profit;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", item_type='" + item_type + '\'' +
                ", sales_channel='" + sales_channel + '\'' +
                ", order_priority='" + order_priority + '\'' +
                ", order_date='" + order_date + '\'' +
                ", order_id=" + order_id +
                ", ship_date='" + ship_date + '\'' +
                ", units_sold=" + units_sold +
                ", unit_price=" + unit_price +
                ", unit_cost=" + unit_cost +
                ", total_revenue=" + total_revenue +
                ", total_cost=" + total_cost +
                ", total_profit=" + total_profit +
                '}';
    }
}
