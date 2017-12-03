package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
创建两个类，使用entitymanager、JPQL和spring data jpa做增删改查操作，以及多对一关系的保存、查询、删除关系。
Employee：long id(主键)、string name 、double salary、long dept_id
 */

@SpringBootApplication
public class SpringDataJpaApplication{


	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	// implements CommandLineRunner
//	//import org.springframework.boot.CommandLineRunner;
//
//	@Override
//	public void run(String... strings) throws Exception {
//
//       jdbcTemplate.execute("DROP TABLE IF EXISTS Employee");
//       jdbcTemplate.execute("CREATE TABLE Employee(" +
//               "id bigint primary key AUTO_INCREMENT,name VARCHAR(255),"
//               + "salary decimal(10,2), dept_id bigint(20))");
//	}
	 
}
