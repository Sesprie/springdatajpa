使用Spring Data JPA，需要整合Spring与Spring Data JPA，并且需要提供JPA的服务提供者hibernate，所以需要导入spring相关坐标，hibernate坐标，数据库驱动坐标等

过程：
1.导入依赖
2.配置spring的配置文件
3.编写dao接口，继承JpaRepository、JpaSpecificationExecutor
4.定义测试类调用接口


有时候莫名其妙的出现问题可能是由于包冲突引起的：
例如这里将hibernate的版本从5.0.7.Final改为5.4.1.Final就会出现问题

























SpringDataJpa第二天
	orm思想，hibernate，JPA的相关操作
	
* SpringDataJpa

第一 springDataJpa的概述

第二 springDataJpa的入门操作
	案例：客户的基本CRUD
	i.搭建环境
		创建工程导入坐标
		配置spring的配置文件（配置spring Data jpa的整合）
		编写实体类（Customer），使用jpa注解配置映射关系
	ii.编写一个符合springDataJpa的dao层接口
		* 只需要编写dao层接口，不需要编写dao层接口的实现类
		* dao层接口规范
			1.需要继承两个接口（JpaRepository，JpaSpecificationExecutor）
			2.需要提供响应的泛型
	
	* 
		findOne（id） ：根据id查询
		save(customer):保存或者更新（依据：传递的实体类对象中，是否包含id属性）
		delete（id） ：根据id删除
		findAll() : 查询全部

第三 springDataJpa的运行过程和原理剖析
	1.通过JdkDynamicAopProxy的invoke方法创建了一个动态代理对象
	2.SimpleJpaRepository当中封装了JPA的操作（借助JPA的api完成数据库的CRUD）
	3.通过hibernate完成数据库操作（封装了jdbc）


第四 复杂查询
	i.借助接口中的定义好的方法完成查询
		findOne(id):根据id查询
	ii.jpql的查询方式
		jpql ： jpa query language  （jpq查询语言）
		特点：语法或关键字和sql语句类似
			查询的是类和类中的属性
			
		* 需要将JPQL语句配置到接口方法上
			1.特有的查询：需要在dao接口上配置方法
			2.在新添加的方法上，使用注解的形式配置jpql查询语句
			3.注解 ： @Query

	iii.sql语句的查询
			1.特有的查询：需要在dao接口上配置方法
			2.在新添加的方法上，使用注解的形式配置sql查询语句
			3.注解 ： @Query
				value ：jpql语句 | sql语句
				nativeQuery ：false（使用jpql查询） | true（使用本地查询：sql查询）
					是否使用本地查询
					
	iiii.方法名称规则查询
		
		
		
		
		
		
		
		
		
		
		
		
		
		

