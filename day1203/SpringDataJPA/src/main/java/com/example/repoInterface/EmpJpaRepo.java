package com.example.repoInterface;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Employee;

@Transactional
public interface EmpJpaRepo extends JpaRepository<Employee, String> ,JpaSpecificationExecutor<Employee>{

	//自定义删除,需要自己写sql
//	@Transactional
	@Modifying	//注解完成修改操作(注意:不支持新增)
	@Query("delete from Employee e where e.name=?1")
	int deleteByName(@Param("1") String name);
	
	
	@Modifying	
	@Query("update Employee e set e.deptId=:deptId, e.name=:name, e.salary=:salary where e.id=:id")
	int updateEmp(@Param("deptId") BigInteger deptId,@Param("name") String name, @Param("salary")BigDecimal salary,@Param("id") String id);
	
}