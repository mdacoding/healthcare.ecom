package com.mdacoding.healthcare.ecom.repositories;

import com.mdacoding.healthcare.ecom.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
