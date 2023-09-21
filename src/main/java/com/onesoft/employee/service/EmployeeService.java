package com.onesoft.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.employee.dao.EmployeeDao;
import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.exception.AgeNotEligibleException;
import com.onesoft.employee.exception.AgeNotFoundException;
import com.onesoft.employee.exception.GenderNotFoundException;

import com.onesoft.employee.exception.NameNotFoundException1;
import com.onesoft.employee.exception.SalaryNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao ed;
	public String setEmp(Employee e) throws AgeNotEligibleException {
		// TODO Auto-generated method stub
		try {
			if(e.getAge()<=18) {
				throw new AgeNotEligibleException("Age Not Accept");
				
			}
			else {
				return ed.setEmp(e);
			}
			
			
		}catch(AgeNotEligibleException ane) {
			return "Not Accepted This Age";
			
		}
		
	}
	public String setAllEmp(List<Employee> e) {
		// TODO Auto-generated method stub
		return ed.setAllEmp(e);
	}
	public Employee getId(int a) {
		// TODO Auto-generated method stub
		return ed.getId(a);
	}
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return ed.getAll();
	}
	public List<Employee> getName(String a) {
		// TODO Auto-generated method stub
		
			List<Employee> b = getAll();
			
			List<Employee> x = b.stream().filter(y -> y.getName().equals(a)).collect(Collectors.toList());
			return x;
		
		
	}
	public Employee getMAx() {
		List<Employee> b =getAll();
		Employee x =b.stream().max(Comparator.comparingInt(Employee::getSalary)).get();
		return x;
	}
	public Employee getMin() {
		// TODO Auto-generated method stub
		List<Employee> b =getAll();
		Employee x =b.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
		return x;
	}
	public List<Employee> age() {
		// TODO Auto-generated method stub
		List<Employee> b = getAll();
		List<Employee> c = b.stream().filter(x-> x.getAge()>=24 && x.getAge()<=26).collect(Collectors.toList());
		return c;
	}
	public String update(Employee e) {
		// TODO Auto-generated method stub
		return ed.update(e);
	}
	public String del(int a) {
		// TODO Auto-generated method stub
		return ed.del(a);
	}
	public List<Employee> getByAge(int a) {
		// TODO Auto-generated method stub
		List<Employee> x = getAll();
		List<Employee> z = x.stream().filter(k-> k.getAge()==a).toList();
		return z;
	}
	public List<Employee> getByGender(String a) throws GenderNotFoundException {
		// TODO Auto-generated method stub
		List<Employee> x = getAll();
		List<Employee> z = x.stream().filter(k-> k.getGender().equalsIgnoreCase(a)).toList();
		if(z.isEmpty()) {
			throw new GenderNotFoundException("The Gender Is Not Available");
		}
		else {
			return z;
		}
	}
	public List<Employee> getBySalary(int a) throws SalaryNotFoundException {
		// TODO Auto-generated method stub
		List<Employee> x = getAll();
		List<Employee> z = x.stream().filter(k-> k.getSalary()==a).toList();
		if(z.isEmpty()) {
			throw new SalaryNotFoundException("No Salary List");
		}
		else {
			return z;
		}
	}
	public Employee maxAge() {
		// TODO Auto-generated method stub
		List<Employee> x = getAll();
		Employee z = x.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		return z;
	}
	public Employee minAge() {
		// TODO Auto-generated method stub
		List<Employee> x = getAll();
		Employee z = x.stream().min(Comparator.comparingInt(Employee::getAge)).get();
		return z;
	}
	public List<Employee> getBySalary(int a, int b) {
		// TODO Auto-generated method stub
		return ed.getBySalary(a,b);
	}
	public List<Employee> getAge(int a) throws AgeNotFoundException {
		// TODO Auto-generated method stub
		List<Employee> x= ed.getAge(a);
		if(x.isEmpty()) {
			throw new AgeNotFoundException("This Age Not Availaple in database");
		}
		else {
			return x;
		}
	}
	public List<Employee> getName1(String a) throws NameNotFoundException1  {
		// TODO Auto-generated method stub
		List<Employee> x =ed.getName1(a);
		if(x.isEmpty()) {
			throw new NameNotFoundException1("No Name In List");
		}
		else {
			return x;
		}
		
	}
	
	
	


}
