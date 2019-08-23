package com.xixi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.xixi.domain.Customer;

/**
 * 接口不用实现
 * 符合SpringDataJpa的dao接口规范
 * JpaRepository<操作的实体类类型，实体类中主键属性的类型或对应的包装类>
 * 		* 封装了基本CRUD操作
 * JpaSpecificationExecutor<操作的实体类类型>
 * 		* 封装了复杂查询(例如：分页)
 * @author Asus
 *
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	/*
	 * 此接口不用实现的原因在于，程序在执行过程中自动的生成了接口的实现类对象
	 * 使用的是动态代理，生成基于接口的实现类对象
	 * 通过debug发现，程序执行过程中生成的代理对象为SimpleJpaRepository
	 * 如果打断点eclipse没有高亮显示打断点的行，重启eclipse即可
	 * */
	
	
	/**
	 * 如果需要自定义查询方法，需要借助@Query并手动实现相应的jpql语句
	 */
	@Query(value = "from Customer where username = ?")
	public List<Customer> findByName(String username);
	
	
	
	
	/**
	 * 根据name和id查找，
	 * 多占位符的赋值
	 * 函数参数要与jpql语句中的占位符保持一致，如果不保持一致会出错，也可以在?后面加上数字，例如这里?2代表id,?1代表name
	 * from Customer where username = ?1 and id = ?2
	 */
	@Query(value = "from Customer where username = ? and id = ?")
	public Customer findByNameAndId(String name, long id);
	
	
	
	/**
	 * 更新操作
	 * sql: udpate t_customer set t_username = ? where t_id = ?
	 * jpql: update Customer set username = ? where id = ?
	 * 
	 * 
	 * Query表示查询
	 *	这里加上@Modifying即可表示修改操作
	 */
	@Query(value = "update Customer set username = ?2 where id = ?1")
	@Modifying
	public void updateUsernameById(long id, String username);
	
	
	/**
	 * 使用sql语句进行查询全部
	 * 这里的返回值比较特殊
	 */
	@Query(value ="select * from t_customer", nativeQuery = true)
	public List<Object[] > findAllWithSql();
	
	/**
	 * 使用sql语句进行查询，附带条件
	 */
	@Query(value = "select * from t_customer where t_username like ?1", nativeQuery = true)
	public List<Object[]> findByUsernameLike1(String username);
	
	
	
	/**
	 * 根据规则进行方法的命名，方法名称即为查询方式
	 * 支持的关键字
	 * https://docs.spring.io/spring-data/jpa/docs/2.1.10.RELEASE/reference/html/#repository-query-keywords
	 */
	public List<Customer> findByUsernameLike(String username);
	
	
	/**
	 * spring data jpa命名规则
	 * https://blog.csdn.net/sbin456/article/details/53304148
	 * @param id
	 * @return
	 */
	
	public Customer findById(long id);
	
	/**
	 * Spring Data JPA命名规则
	 * Supported keywords inside method names
	 * https://docs.spring.io/spring-data/jpa/docs/2.1.10.RELEASE/reference/html/#jpa.query-methods.query-creation
	 * 
	 * 方法名中的字母为实体类中的属性，而非数据库中的字段
	 */
	public Customer findByUsernameLikeAndId(String username, long id);//参数的顺序需要和方法名中的顺序一致
	
	
	
	
}
