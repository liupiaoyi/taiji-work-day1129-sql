package entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpa_link.Employee;

public class InsertEmployee {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa_link");
		
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Employee employee = new Employee();
//		employee.setId("14");
//		employee.setDeptId(BigInteger.valueOf(5L));
//		employee.setName("shisi");
//		employee.setSalary(40000);
//		
//		entitymanager.persist(employee);
		
		Employee find = entitymanager.find(Employee.class, "10");
		System.out.println("find==="+find.toString());
//	    if (find != null) {
//	    	entitymanager.remove(find);
//	    }
		
		
//		TypedQuery<Employee> createQuery = entitymanager.createQuery("select * from employee",Employee.class);
//		List<Employee> resultList = createQuery.getResultList();
//		resultList.forEach(System.out::println);
		
		
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
		
		
		
	}

}
