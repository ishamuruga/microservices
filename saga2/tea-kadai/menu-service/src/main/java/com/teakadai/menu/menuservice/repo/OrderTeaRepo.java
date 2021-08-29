package com.teakadai.menu.menuservice.repo;

import com.teakadai.menu.menuservice.entity.OrderTea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTeaRepo extends JpaRepository<OrderTea,String> {
    
}
