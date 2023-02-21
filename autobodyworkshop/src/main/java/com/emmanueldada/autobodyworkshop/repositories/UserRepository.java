package com.emmanueldada.autobodyworkshop.repositories;

import com.emmanueldada.autobodyworkshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
