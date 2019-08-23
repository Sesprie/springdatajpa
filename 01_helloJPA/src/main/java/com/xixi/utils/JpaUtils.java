package com.xixi.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static EntityManagerFactory factory;//此对象的创建会消耗大量资源，创建一次即可，此对象是线程安全的，多线程访问没有问题
	
	static {
		factory = Persistence.createEntityManagerFactory("myJPA");//类加载时创建一次即可
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	
}
