package com.epam.rd.autotasks.springemployeecatalog.repository;

import com.epam.rd.autotasks.springemployeecatalog.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    @Query(value = "SELECT * FROM EMPLOYEE WHERE manager = ?", nativeQuery = true)
    Page<Employee> findAllByManagerId(Long managerId, PageRequest pageRequest);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE department = ?", nativeQuery = true)
    Page<Employee> findAllByDepartmentId(Long departmentId, PageRequest pageRequest);
}
