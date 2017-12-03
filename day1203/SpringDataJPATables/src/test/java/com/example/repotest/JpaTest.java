package com.example.repotest;

import javax.persistence.Transient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.jparepo.UserAccountRepository;
import com.example.jparepo.UserRoleRepository;
import com.example.tables.UserAccount;
import com.example.tables.UserRoles;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class JpaTest {
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	@Test
	public void count() {
		System.out.println(userRoleRepository.count()+"+++"+userAccountRepository.count());
	}
	
	@Test
	public void add() {
		if( userRoleRepository.findOne("ROLE_ADMIN") == null ) {
			UserRoles userRole = new UserRoles();
			userRole.setCode("ROLE_ADMIN");
			userRole.setName("管理员");
			userRole.setEnabled(true);
			userRoleRepository.save(userRole);
		}
		if( userRoleRepository.findOne("ROLE_USER")==null ) {
			UserRoles userRole = new UserRoles();
			userRole.setCode("ROLE_USER");
			userRole.setName("用户");
			userRole.setEnabled(true);
			userRoleRepository.save(userRole);
		}
		
		long count = userAccountRepository.count();
		System.out.println("userAccountRepository.count==="+count);
		if( userAccountRepository.findOne("admin")==null ) {
			UserAccount userAccount = new UserAccount();
			userAccount.setCode("admin");
			userAccount.setName("manager.qiu");
			userAccount.setPassword("taiji");
			userAccount.setEnabled(true);
			userAccount.setEmail("taiji.com");
			userAccountRepository.save(userAccount);
		}
		count = userAccountRepository.count();
		System.out.println("userAccountRepository.count=== ==="+count);
	
	}
	
	
	@Test
	public void link() {
		UserRoles roleAdmin = userRoleRepository.findOne("ROLE_ADMIN");
		UserAccount userAdmin = userAccountRepository.findOne("admin");
	
		userAdmin.setUserRoles(roleAdmin);
		userAccountRepository.save(userAdmin);
	}
	
	

}
