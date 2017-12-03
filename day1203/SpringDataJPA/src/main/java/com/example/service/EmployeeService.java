package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;

@Service
@Transactional
public class EmployeeService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	//增
	public Employee addEmp( Employee employee ) {
		Employee emp = new Employee();
		emp.setDeptId( employee.getDeptId() );
		emp.setName(( employee.getName()) );
		emp.setSalary( employee.getSalary() );
		
		entityManager.persist(emp);
		return emp;
	}	
	
	//查
	public Employee getEmployee(String id){
		//Employee find = entityManager.find(Employee.class, id);
		
		Employee find = new Employee();
		//find = entityManager.createQuery("select e from Employee e where e.id=?1",Employee.class)
		find = entityManager.createQuery("select e from Employee e where e.id=:id",Employee.class)		
		.setParameter("id", id).getSingleResult();	
		
		return find;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> emp = new ArrayList<Employee>();
		emp = entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
		return emp;
	}
		
	
	public List<Employee> getEmployeeByIdName(String id,String name) {
		List<Employee> emp = new ArrayList<Employee>();
		emp = entityManager.createNamedQuery("selectIdName",Employee.class)
				.setParameter("id", id).setParameter("name", name).getResultList();
		return emp;
	}
	
	//改
	public void updateEmployee(String id,String name){
		//找到需要修改的实体类对象
//		Employee find = entityManager.find(Employee.class, id);
//		find.setName(name);
		
		entityManager.createQuery("update Employee e set e.name=?1 WHERE e.id=?2")
		.setParameter(1, name).setParameter(2, id).executeUpdate();
		
		entityManager.flush();
	}
		

	//删
	public void deleteEmployee(String id){
		//找到需要修改的实体类对象
//		Employee find = entityManager.find(Employee.class, id);
//		entityManager.remove(find);
		
		entityManager.createQuery("DELETE FROM Employee e WHERE e.id=?1")
        .setParameter(1, id).executeUpdate();
		
	}
	

}
