package com.onegateafrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onegateafrica.entity.Conge;
@Repository
public interface CongeRepository extends JpaRepository<Conge,Long> {

}
