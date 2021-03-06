package org.weatherdetector.thread;

import org.weatherdetector.cache.CacheInfo;
import org.weatherdetector.cache.WeatherModel;

public class HDWeather extends Thread {
	private String url;
	private CacheInfo cache;
	
	public HDWeather() {
		// TODO Auto-generated constructor stub
	}
	
	public HDWeather(String url,CacheInfo cache) {
		this.url = url;
		this.cache = cache;
	}
	
	@Override
	public void run() {
		while(true) {
			while(true) {
				try{
					//获取响应
					String response = "get response from " + url;
					//将结果保存到缓存中
					cache.cache(url, new WeatherModel(response));
					//更新文件
					System.out.println("write weatherModel.response to D_LOCAL_URL");
					Thread.sleep(100);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
