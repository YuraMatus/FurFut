package com.furniturefuture.repository;


import com.furniturefuture.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {

Role findByName(String name);

    Role save(Role r);
}