package com.onesoft.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.repositary.EmployeeRepositary;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepositary er;
	public String setEmp(Employee e) {
		// TODO Auto-generated method stub
		er.save(e);
		return "Succss Kamal" ;
	}
	public String setAllEmp(List<Employee> e) {
		// TODO Auto-generated method stub
		er.saveAll(e);
		return "Sucees Full All Employee List";
	}
	public Employee getId(int a) {
		// TODO Auto-generated method stub
		return er.findById(a).get();
	}
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return er.findAll();
	}
	public String update(Employee e) {
		// TODO Auto-generated method stub
		er.save(e);
		return "Updated Kamal";
	}
	public String del(int a) {
		// TODO Auto-generated method stub
		er.deleteById(a);
		return "Deleted Kamal";
	}
	public List<Employee> getBySalary(int a, int b) {
		// TODO Auto-generated method stub
		return er.getBySalary(a,b);
	}
	public List<Employee> getAge(int a) {
		// TODO Auto-generated method stub
		return er.getAge(a);
	}
	public List<Employee> getName1(String a) {
		// TODO Auto-generated method stub
		return er.getName1(a);
	}

}
