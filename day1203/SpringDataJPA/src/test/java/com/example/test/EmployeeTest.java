package com.example.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class EmployeeTest {
	
	@Autowired
	EmployeeService empService;
	
	@Test
	public void add() {
		Employee emp = new Employee();
		emp.setName("san");
		emp.setDeptId(BigInteger.valueOf(30L));
		emp.setSalary(BigDecimal.valueOf(30000) );
		
		Employee addEmp = empService.addEmp(emp);
		System.out.println(addEmp);
	}
	
	
	@Test
	public void find() {
//		Employee employee = empService.getEmployee("1");
//		System.out.println(employee);
		
//		List<Employee> allEmployee = empService.getAllEmployee();
		
		List<Employee> allEmployee = empService.getEmployeeByIdName("3", "san");
		allEmployee.forEach(System.out::println);
	}
	
	
	@Test
	public void change() {
		String id = "1";
		Employee employee = empService.getEmployee(id);
		System.out.println("before:  "+employee);
		
		empService.updateEmployee(id, "changeQuery");

		
		employee = empService.getEmployee(id);
		System.out.println("after:  "+employee);
	}
	
	
	@Test
	public void delete() {
		String id = "2";
		Employee employee = empService.getEmployee(id);
		System.out.println("before:  "+employee);
		
		empService.deleteEmployee(id);
		
		employee = empService.getEmployee(id);
		System.out.println("after:  "+employee);
		
	}

}
