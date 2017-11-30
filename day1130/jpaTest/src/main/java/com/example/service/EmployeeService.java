package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.domain.Employee;

@Service
public class EmployeeService {
	
	public static void main(String[] args) {
		
	}	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Employee createEmployee(long dept_id, String name, long salary) {
	    Employee emp = new Employee( name, salary, dept_id);
//	    emp.setId(id);
//	    emp.setDept_id(dept_id);
//	    emp.setName(name);
//	    emp.setSalary(salary);
	    entityManager.persist(emp);
	    
//	    entityManager.getTransaction().commit();
	    return emp;
	}
	
	public Employee findEmployee(long id) {
	    return entityManager.find(Employee.class, id);
	}
	
	public Employee findEmployee(String name) {
		return entityManager.find(Employee.class, name);
	}

}
