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
import com.example.repoInterface.EmpJpaRepo;
import com.example.repoInterface.EmpRepo;
import com.example.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class EmployeeInterfaceTest {
	
	@Autowired
	EmpRepo empRepo;
	
	@Test
	public void add() {
//		System.out.println(  empRepo.count()+"\n"			//一空多少数据
//							+empRepo.exists("1")+"\n"		//是否存在 id=1 的数据
//							+empRepo.findAll()+"\n"			//查询所有数据
//							+empRepo.findOne("4")+"\n"		//按条件查询数据
//							+empRepo.save(new Employee(BigInteger.valueOf(10L),"si",BigDecimal.valueOf(4000)))+"\n"			//插入数据
//							);
		
		//自定义方法(只有查询可以。删除，修改，需要自定义)
		List<Employee> findByName = empRepo.findByName("si");
		findByName.forEach(System.out::println);
		
	}
	
	
	@Autowired
	EmpJpaRepo empJpaRepo;
	
	@Test
	public void selfDeleteMethod() {
		int deleteByName = empJpaRepo.deleteByName("si");
		System.out.println(deleteByName);
	}
	
	@Test
	public void updateDeleteMethod() {
		int updateEmp = empJpaRepo.updateEmp(BigInteger.valueOf(44L), "siChange", BigDecimal.valueOf(40000), "4");
		System.out.println(updateEmp);
	}
	
}
