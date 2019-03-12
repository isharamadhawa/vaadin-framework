package com.gmail.ishara.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.ishara.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
