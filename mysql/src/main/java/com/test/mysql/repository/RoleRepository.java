package com.test.mysql.repository;

import com.test.dbexpand.jpa.repository.ExpandJpaRepository;
import com.test.mysql.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ExpandJpaRepository<Role, Long> {

}
