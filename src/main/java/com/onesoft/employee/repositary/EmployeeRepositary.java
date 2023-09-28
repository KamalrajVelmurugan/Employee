package com.onesoft.employee.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onesoft.employee.entity.Employee;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {

	@Query(value="select * from test_db.employee where salary>=? and salary<=?", nativeQuery = true)
	List<Employee> getBySalary(int a, int b);
	
	@Query(value="select e from Employee e where e.age>:a ")
	List<Employee> getAge(int a);

	@Query(value="select * from test_db.employee where name=?", nativeQuery = true)
	List<Employee> getName1(String a);
	
	
	
}
