package com.gianmdp03.brand_website.repository;

import com.gianmdp03.brand_website.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
