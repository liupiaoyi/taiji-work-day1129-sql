package com.example.repoInterface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Employee;

public interface EmpRepo extends CrudRepository<Employee, String> {

	//查询方法可以自定义，删除需要自己写sql
	List<Employee> findByName(String id);
		
//	List<Department> findAll();

	
	
}
