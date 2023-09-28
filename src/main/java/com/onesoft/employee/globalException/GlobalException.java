package com.onesoft.employee.globalException;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onesoft.employee.entity.Employee;
import com.onesoft.employee.exception.AgeNotFoundException;
import com.onesoft.employee.exception.GenderNotFoundException;
import com.onesoft.employee.exception.HighestSalaryException;
import com.onesoft.employee.exception.NameNotFoundException1;
import com.onesoft.employee.exception.SalaryNotFoundException;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NameNotFoundException1.class)
	public ResponseEntity<Object> namenotHandling(NameNotFoundException1 ne){
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<Object> age(AgeNotFoundException ae){
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> salary(SalaryNotFoundException se){
		return new ResponseEntity<>(se.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(GenderNotFoundException.class)
	public ResponseEntity<Object> salary(GenderNotFoundException ge){
		return new ResponseEntity<>(ge.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HighestSalaryException.class)
	public ResponseEntity<Object> high(HighestSalaryException hs){
		return new ResponseEntity<>(hs.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
