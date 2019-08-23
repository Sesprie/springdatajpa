package com.xixi.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import com.xixi.utils.JpaUtils;

/**
 * 测试Jpql
 * @author Asus
 *
 */
public class JpqlTest {

	
	/**
	 * 查找全部：
	 * 		sql: select * from t_customer
	 * 		jpql: from Customer
	 */
	@Test
	public void testFindAll() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//获取Query对象执行jpql语句
		String jpql = "from Customer";
		Query query = em.createQuery(jpql);
		List list = query.getResultList();
		for(Object obj : list) {
			System.out.println(obj);
		}
		
		
		
		tx.commit();
		em.close();
	}
	
	
	
	
	
	
	
	/**
	 * 排序
	 * 		sql: select * from t_customer order by id desc
	 * 		jpql: from Customer order by id desc
	 */
	@Test
	public void testOrder() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//获取query对象执行jpql
		String jpql = "from Customer order by id desc";
		Query query = em.createQuery(jpql);
		List list = query.getResultList();
		for(Object obj : list) {
			System.out.println(obj);
		}
		
		
		
		tx.commit();
		em.close();
	}
	
	/**
	 * 统计查询
	 * 		sql: select count(t_id) from t_customer
	 * 		jpql: select count(id) from Customer
	 */
	@Test
	public void testCount() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//获取query对象执行jpql
		String jpql = "select count(id) from Customer";
		Query query = em.createQuery(jpql);
		Object obj = query.getSingleResult();
		System.out.println(obj);
		
		
		
		tx.commit();
		em.close();
	}
	
	/**
	 * 分页查询
	 * 		sql: select * from t_customer limit 0,2
	 * 		jpql: from Customer 
	 */
	@Test
	public void testPage() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//获取query对象执行jpql
		String jpql = "from Customer";
		Query query = em.createQuery(jpql);
		//设置分页参数
		query.setFirstResult(0);
		query.setMaxResults(2);
		
		List list = query.getResultList();
		for(Object obj : list) {
			System.out.println(obj);
		}
		
		
		
		tx.commit();
		em.close();
	}
	
	
	/**
	 * 条件查询：
	 * 		sql: select * from t_customer where t_username like '张%'
	 * 		jpql: from Customer where username like ?
	 */
	@Test
	public void testLike() {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		/**
		 * java.lang.IllegalArgumentException: org.hibernate.QueryException: Legacy-style query parameters (`?`) are no longer supported; 
		 * use JPA-style ordinal parameters (e.g., `?1`) instead : 
		 * from com.xixi.domain.Customer where username like ? [from com.xixi.domain.Customer where username like ?]
		 */
		
		//获取query对象执行jpql
		String jpql = "from Customer where username like ?1";
		Query query = em.createQuery(jpql);
		//为占位符赋值，索引从1开始
		query.setParameter(1, "张%");
		
		List list = query.getResultList();
		for(Object obj : list) {
			System.out.println(obj);
		}
		
		
		
		tx.commit();
		em.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
