package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jpa_link.Employee;

import javax.persistence.*;
import java.util.List;

public class InsertEmpService {

    protected EntityManager em;
    
    public InsertEmpService(EntityManager em) {
        this.em = em;
    }
    
    //insert
    public Employee createEmployee(String name, long salary) {
        Employee emp = new Employee();
        
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }
    
    //find
    public Employee findEmployee(String id) {
        return em.find(Employee.class, id);
    }    
    
    //remove
    public void removeEmployee(String id) {
        Employee emp = findEmployee(id);
        if (emp != null) {
            em.remove(emp);
        }
    } 

    
    
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = em.createQuery(
                  "SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
    

}
