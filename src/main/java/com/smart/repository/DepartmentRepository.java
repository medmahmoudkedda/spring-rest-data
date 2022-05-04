package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.smart.entity.Department;

@Repository 
//@RestResource(exported = false)
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
