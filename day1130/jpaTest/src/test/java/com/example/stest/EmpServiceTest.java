package com.example.stest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Employee;
import com.example.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class EmpServiceTest {
	
	@Autowired
	private EmployeeService empService;
/**
 * `id  `dept_id  name``salary`
 */
	@Test
	public void t() {
		Employee employee = empService.createEmployee(5,"name2", 30000);
		
		//Employee employee = empService.findEmployee(1);
		//Employee findEmployee = empService.findEmployee("name"); 报错
		System.out.println(employee);
	}
	
	

}
