package com.Beetles.SystemPayout.repository;

import com.Beetles.SystemPayout.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository

public interface Repository extends JpaRepository<User, Long> {
}
