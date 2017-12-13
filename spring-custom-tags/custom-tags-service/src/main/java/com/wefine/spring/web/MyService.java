package com.wefine.spring.web;

import java.util.Map;

public class MyService {
	private String serviceName;
	private MyDAO defaultDao;
	private Map<String, MyDAO> daoRegistry;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public MyDAO getDefaultDao() {
		return defaultDao;
	}

	public void setDefaultDao(MyDAO defaultDao) {
		this.defaultDao = defaultDao;
	}

	public Map<String, MyDAO> getDaoRegistry() {
		return daoRegistry;
	}

	public void setDaoRegistry(Map<String, MyDAO> daoRegistry) {
		this.daoRegistry = daoRegistry;
	}

}
