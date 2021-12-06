package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Espace;

@Repository
public interface EspaceRepository extends JpaRepository<Espace,Long> {

}
