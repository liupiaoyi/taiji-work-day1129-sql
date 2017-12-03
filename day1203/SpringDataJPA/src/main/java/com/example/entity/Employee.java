package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="selectIdName",query="select e from Employee e where e.id=:id and e.name=:name")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	@Column(name="dept_id")
	private BigInteger deptId;

	private String name;

	private BigDecimal salary;

	public Employee() {
	}

	
	public Employee(BigInteger deptId, String name, BigDecimal salary) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.salary = salary;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getDeptId() {
		return this.deptId;
	}

	public void setDeptId(BigInteger deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", deptId=" + deptId + ", name=" + name + ", salary=" + salary + "]";
	}

}