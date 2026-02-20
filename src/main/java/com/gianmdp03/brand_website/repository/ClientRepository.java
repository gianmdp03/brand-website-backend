package com.gianmdp03.brand_website.repository;

import com.gianmdp03.brand_website.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
