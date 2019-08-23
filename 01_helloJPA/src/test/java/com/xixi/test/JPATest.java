package com.xixi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.xixi.domain.Customer;
import com.xixi.utils.JpaUtils;

public class JPATest {

	@Test
	public void testJpaSave() {
		//EntityManagerFactory是线程安全的，但是其创建过程耗费资源，所以启动程序时就创建一份即可
		//以下API都是JPA规范中的，只不过实现是调用了hibernate实现
		//1.加载配置文件(不用指定位置，默认读取META-INF/persistence.xml文件)，获取实体管理器工厂
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");//名称是persistence.xml中持久化单元的名称
		//2.通过工厂获取实体管理器
		EntityManager em =  factory.createEntityManager();
		//3.获取事务对象
		EntityTransaction tx = em.getTransaction();
		//4.打开事务
		tx.begin();
		Customer customer = new Customer();
		customer.setUsername("张三2");
		customer.setPhone("1365243845");
		//5.使用实体管理器保存数据
		em.persist(customer);
		//remove(删除),merge(更新),find/getReference(根据id查找),persist(保存)
		//6.提交事务
		tx.commit();
		//7.释放资源
		em.close();
		factory.close();
		
	}
	
	@Test
	public void testFind() {
		//需要将hibernate.hbm2ddl.auto改为update
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer customer = em.find(Customer.class, 1l);//此语句运行就会执行sql语句
		System.out.println(customer);
		tx.commit();
		em.close();
	}
	
	//find/getReference的区别
	//find：立即加载
	//getReference：延迟加载
	@Test
	public void testGetReference() {
		//需要将hibernate.hbm2ddl.auto改为update
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer customer = em.getReference(Customer.class, 1l);//此语句运行不会sql语句
		System.out.println(customer);//只有在使用这个对象的时候，才去查询，可以使用debug打断点看一下
		tx.commit();
		em.close();
	}
	
	
	@Test
	public void testRemove() {
		//需要将hibernate.hbm2ddl.auto改为update
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//先查询再删除
		Customer customer = em.getReference(Customer.class, 1l);
		em.remove(customer);
		tx.commit();
		em.close();
	}
	
	
	//需要将hibernate.hbm2ddl.auto改为update
	@Test
	public void testUpdate() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//先查询
		Customer customer = em.find(Customer.class, 1l);
		//再修改
		customer.setUsername("张三三");
		em.merge(customer);
		tx.commit();
		em.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
