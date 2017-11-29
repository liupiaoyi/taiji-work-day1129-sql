package cn.com.example.service;

import java.util.Collections;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import cn.com.example.domain.Person;

@Service
public class PersonService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

/*    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;*/


    public void create(String name, Integer age, Integer pid) {
        jdbcTemplate.update("insert into PERSON(NAME, AGE,PID) values(?, ?,?)", name, age,pid);
 /*       jdbcTemplate1.update("insert into PERSON(NAME, AGE) values(?, ?)", name, age);
        jdbcTemplate2.update("insert into PERSON(NAME, AGE) values(?, ?)", name, age);
*/    }

    public void deleteByName(String name) {
        jdbcTemplate.update("delete from PERSON where NAME = ?", name);
/*        jdbcTemplate1.update("delete from PERSON where NAME = ?", name);
        jdbcTemplate2.update("delete from PERSON where NAME = ?", name);
*/    }

    public Integer getAllPersons() {
        return jdbcTemplate.queryForObject("select count(1) from PERSON", Integer.class);
    }

    public void deleteAllPersons() {
        jdbcTemplate.update("delete from PERSON");
/*        jdbcTemplate1.update("delete from PERSON");
        jdbcTemplate2.update("delete from PERSON");
*/    }
    
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    public int countOfPersonByName(String name) {
        String sql = "select count(*) from Person where name=:name";
        //SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);
        Map<String, String> namedParameters = Collections.singletonMap("name",name);
        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    }
    
    
    public int countOfPerson(Person person) {
    	String sql = "select count(*) from person where name = :name and age = :age";
    	//System.out.println(sql+"+++++");
    	SqlParameterSource personParamter = new BeanPropertySqlParameterSource(person);
    	//System.out.println(sql+"------");
    	return this.namedParameterJdbcTemplate.queryForObject(sql, personParamter, Integer.class);
    	
    }
    
    
    
    
    
    
    

}
