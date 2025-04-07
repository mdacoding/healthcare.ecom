package com.mdacoding.healthcare.ecom.repositories;

import com.mdacoding.healthcare.ecom.model.Role;
import com.mdacoding.healthcare.ecom.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
