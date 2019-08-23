package com.xixi.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xixi.dao.CustomerDao;
import com.xixi.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息，不用再手动读取
public class CustomerDaoTest {

	@Autowired
	private CustomerDao customerDao;
	
	
	/**
	 * 根据id查询
	 */
	@Test
	public void testFindOne() {
		Customer customer = customerDao.findOne(1l);
		System.out.println(customer);
		
	}
	
	/**
	 * 保存
	 */
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setPhone("123");
		c.setUsername("slok");
		customerDao.save(c);
	}
	
	/**
	 * 修改
	 */
	@Test
	public void testUpdate() {
		Customer customer = customerDao.findOne(1l);
		customer.setUsername("xixi");
		customerDao.save(customer);
	}
	
	
	/**
	 * 删除
	 */
	@Test
	public void testDelete() {
		customerDao.delete(1l);
	}
	
	
	/**
	 * 查询所有
	 */
	@Test
	public void testFindAll() {
		List<Customer> cs = customerDao.findAll();
		for(Customer c : cs) {
			System.out.println(c);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
