package org.weatherdetector.client;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.weatherdetector.rmi.Service;


public class ClientMain {
	public static void main(String[] args) {
		RmiProxyFactoryBean bf = new RmiProxyFactoryBean();
		bf.setServiceUrl("rmi://127.0.0.1:2198/Service");
		bf.setServiceInterface(Service.class);
		bf.afterPropertiesSet();
		Service obj = (Service) bf.getObject();
		String str = obj.service(3000);
		System.out.println(str);
	}
}
