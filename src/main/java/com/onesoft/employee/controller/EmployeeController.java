package com.onesoft.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.exception.AgeNotEligibleException;
import com.onesoft.employee.exception.AgeNotFoundException;
import com.onesoft.employee.exception.GenderNotFoundException;

import com.onesoft.employee.exception.NameNotFoundException1;
import com.onesoft.employee.exception.SalaryNotFoundException;
import com.onesoft.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	@PostMapping("add")
	public String setEmp(@RequestBody Employee e) throws AgeNotEligibleException {
		return es.setEmp(e);
	}
	
	@PostMapping("addAll")
	public String setAllEmp(@RequestBody List<Employee> e) {
		return es.setAllEmp(e);
	}
	
	@GetMapping("find/{a}")
	public Employee getId(@PathVariable int a){
		return es.getId(a);
	}
	@GetMapping("getAll")
	public List<Employee> getAll(){
		return es.getAll();
	}
	
	@GetMapping("getName/{a}")
	public List<Employee> getName(@PathVariable String a) {
		return es.getName(a);
	}
	
	@GetMapping("getMaxSalary")
	public Employee getMax(){
		return es.getMAx();
	}
	
	@GetMapping("getMinSalary")
	public Employee getMin(){
		return es.getMin();
	}
	
	@GetMapping("age")
	public List<Employee> age(){
		return es.age();
	}
	
	@PutMapping("update")
	public String update(@RequestBody Employee e) {
		return es.update(e);
	}
	
	@DeleteMapping("del/{a}")
	public String del(@PathVariable int a) {
		return es.del(a);
	}
	
	@GetMapping("getByAge/{a}")
	public List<Employee> getByAge(@PathVariable int a){
		return es.getByAge(a);
	}
	
	@GetMapping("getByGender/{a}")
	public List<Employee> getbyGender(@PathVariable String a) throws GenderNotFoundException{
		return es.getByGender(a);
	}
	@GetMapping("getBySalary/{a}")
	public List<Employee> getBySalary(@PathVariable int a) throws SalaryNotFoundException{
		return es.getBySalary(a);
	}
	
	@GetMapping("maxAge")
	public Employee maxAge() {
		return es.maxAge();
	}
	
	@GetMapping("minAge")
	public Employee minAge() {
		return es.minAge();
	}
	
	@GetMapping("getBySalary/{a}/{b}")
	public List<Employee> getBySalary(@PathVariable int a, @PathVariable int b){
		return es.getBySalary(a,b);
	}
	
	@GetMapping("getAge")
	public List<Employee> getAge(@Param(value="a") int a) throws AgeNotFoundException{
		return es.getAge(a);
	}
	
	@GetMapping("getName1/{a}")
	public List<Employee> getName1(@PathVariable String a) throws NameNotFoundException1{
		return es.getName1(a);
	}
	
}
