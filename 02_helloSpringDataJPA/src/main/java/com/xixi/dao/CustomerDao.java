package com.xixi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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

}
