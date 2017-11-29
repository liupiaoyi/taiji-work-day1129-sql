package cn.com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.example.SpringJdbcApplication;
import cn.com.example.domain.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJdbcApplication.class)
public class PersonServiceTest {
	
	@Autowired
	private PersonService ps;
	
	@Test
	public void testCreate() {
		ps.create("person", 11,7);
	}
	
	@Test
	public void getAllPersons() {
		System.out.println( ps.getAllPersons() );
	}
	
	@Test
	public void getPersonNameCount() {
		int count = ps.countOfPersonByName("kanaki");
		System.out.println(count);
	}
	@Test
	public void getPersonParamter() {
		Person person = new Person("person", 11,7);
		int count = ps.countOfPerson(person);
		System.out.println(count);
	}
	
	
}
