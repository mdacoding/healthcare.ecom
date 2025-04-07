package com.mdacoding.healthcare.ecom.repositories;

import com.mdacoding.healthcare.ecom.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
