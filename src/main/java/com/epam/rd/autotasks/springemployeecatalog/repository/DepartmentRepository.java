package com.epam.rd.autotasks.springemployeecatalog.repository;

import com.epam.rd.autotasks.springemployeecatalog.entity.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
    @Query(value = "SELECT id FROM department WHERE name = ?", nativeQuery = true)
    Long findDepartmentId(String departmentName);
}
