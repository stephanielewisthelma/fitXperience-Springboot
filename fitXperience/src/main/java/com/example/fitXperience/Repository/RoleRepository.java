package com.example.fitXperience.Repository;

import com.example.fitXperience.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String user);
}
