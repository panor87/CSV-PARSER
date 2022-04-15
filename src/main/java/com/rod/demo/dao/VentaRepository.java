package com.rod.demo.dao;

import com.rod.demo.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT COUNT(DISTINCT(country)) from Venta")
    Integer countDistinctCountry();
    @Query("SELECT COUNT(DISTINCT(region)) from Venta")
    Integer countDistinctRegion();
    @Query("SELECT COUNT(DISTINCT(item_type)) from Venta")
    Integer countDistinctItemTypes();
    @Query("SELECT COUNT(DISTINCT(sales_channel)) from Venta")
    Integer countDistinctSalesChannel();
    @Query("SELECT COUNT(DISTINCT(order_priority)) from Venta")
    Integer countDistinctOrderPriority();
}
