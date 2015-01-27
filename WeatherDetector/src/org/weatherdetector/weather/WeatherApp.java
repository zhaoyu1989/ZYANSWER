package org.weatherdetector.weather;

import org.springframework.remoting.rmi.RmiServiceExporter;
import org.weatherdetector.cache.CacheInfo;
import org.weatherdetector.rmi.Service;
import org.weatherdetector.rmi.ServiceImpl;
import org.weatherdetector.thread.BJWeather;
import org.weatherdetector.thread.CenterWeather;
import org.weatherdetector.thread.HDWeather;

public class WeatherApp {
	public static CacheInfo cache;
	public static void main(String[] args) {
		try{
			
			cache = CacheInfo.getInstance();
			// 启动线程 分别请求三个url
			new CenterWeather("A_URL", cache).start();
			new BJWeather("B_URL", cache).start();
			new HDWeather("C_URL", cache).start();
			
			// 启动对外接口rmi或者webservice接口,设置用户最大等待时间ms
			RmiServiceExporter exporter = new RmiServiceExporter();
			exporter.setService(new ServiceImpl());
			exporter.setServiceName("Service");
			exporter.setServiceInterface(Service.class);
			exporter.setRegistryPort(2198);
			exporter.afterPropertiesSet();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
