package com.christianvilca.proyecto1.christian.repository;

import com.christianvilca.proyecto1.christian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
