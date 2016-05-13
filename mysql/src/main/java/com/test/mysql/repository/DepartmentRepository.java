package com.test.mysql.repository;

import com.test.dbexpand.jpa.repository.ExpandJpaRepository;
import com.test.mysql.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ExpandJpaRepository<Department, Long> {
}
