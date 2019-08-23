package com.xixi.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xixi.dao.CustomerDao;
import com.xixi.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息，不用再手动读取
public class JPQLTest {

	
	@Autowired
	private CustomerDao customerDao;
	
	@Test
	public void testFindByName() {
		List<Customer> customers = customerDao.findByName("slok");
		for(Customer c : customers) {
			System.out.println(c);
		}
	}
	
	
	@Test
	public void testFindByNameAndId() {
		Customer c = customerDao.findByNameAndId("slok", 4l);
		System.out.println(c);
	}
	
	/**
	 * 执行更新操作需要事务注解
	 * 	org.springframework.dao.InvalidDataAccessApiUsageException: Executing an update/delete query; nested exception is javax.persistence.TransactionRequiredException: Executing an update/delete query
Caused by: javax.persistence.TransactionRequiredException: Executing an update/delete query
	 */
	@Test
	@Transactional//会自动回滚导致看到的是假象，实际上没有修改数据库
	@Rollback(value = false)//将回滚设置为false
	public void testUpdateUsernameById() {
		customerDao.updateUsernameById(2l,"x");
	}
	
	

	/**
	 * 测试使用sql进行查询全部
	 */
	@Test
	public void testFindAllWithSql() {
		List<Object[]> list = customerDao.findAllWithSql();
		for(Object[] c : list) {
			System.out.println(Arrays.toString(c));
		}
	}
	
	
	
	/**
	 * 使用sql进行模糊查询
	 */
	@Test
	public void testFindByUsernameLike1() {
		List<Object[]> list = customerDao.findByUsernameLike1("张%");
		for(Object[] c: list) {
			System.out.println(Arrays.toString(c));
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 测试根据方法命名进行查询
	 */
	@Test
	public void testFindByUsernameLike() {
		List<Customer> list = customerDao.findByUsernameLike("张%");
		for(Customer c : list) {
			System.out.println(c);
		}
	}
	
	
	
	
	
	
	@Test
	public void testFindById() {
		Customer c = customerDao.findById(2l);
		System.out.println(c);
	}
	
	
	@Test
	public void testfindByUsernameLikeAndId() {
		Customer c = customerDao.findByUsernameLikeAndId("张%", 3);
		System.out.println(c);
	}
	
	
	
	
	
	
	
	
	
	
	
}
