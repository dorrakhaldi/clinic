package com.onegateafrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onegateafrica.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

}
