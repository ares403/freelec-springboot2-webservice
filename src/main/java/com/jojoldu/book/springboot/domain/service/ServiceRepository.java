package com.jojoldu.book.springboot.domain.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long>{

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Service> findAllDesc();
}
