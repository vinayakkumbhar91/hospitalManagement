/*package com.app.serviceTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.app.dao.AdminDao;
import com.app.domain.Admin;
import com.app.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/ApplicationContext.xml","classpath:/Dispatcher-servlet.xml"})
@ComponentScan(basePackages="com.app")
public class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminDao adminDao;


	@Test
	public void adminSaveTest() {
		Admin admin = new Admin();
		admin.setFirstName("abc");
		admin.setLastName("xxx");
		admin.setEmailId("abc@gmail.com");
		admin.setStatus(true);
		int id = adminDao.saveAdmin(admin);
		assertTrue(id == 5);
	}
}
*/