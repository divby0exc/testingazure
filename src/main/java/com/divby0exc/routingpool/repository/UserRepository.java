package com.divby0exc.routingpool.repository;

import com.divby0exc.routingpool.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
}
