package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Conge;
@Repository
public interface CongeRepository extends JpaRepository<Conge,Long> {

}
