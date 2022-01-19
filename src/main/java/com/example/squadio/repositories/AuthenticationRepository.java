package com.example.squadio.repositories;

import com.example.squadio.entities.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bkariuki
 */
@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
    Authentication findByUsername(String username);
}
