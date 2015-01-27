package org.weatherdetector.thread;

import org.weatherdetector.cache.CacheInfo;
import org.weatherdetector.cache.WeatherModel;



public class BJWeather extends Thread {
	private String url;
	private CacheInfo cache;
	
	public BJWeather() {
	}
	
	public BJWeather(String url,CacheInfo cache) {
		this.url = url;
		this.cache = cache;
	}
	@Override
	public void run() {
		while(true) {
			while(true) {
				try{
					//��ȡ��Ӧ
					String response = "get response from " + url;
					//��������浽������
					cache.cache(url, new WeatherModel(response));
					//�����ļ�
					System.out.println("write weatherModel.response to D_LOCAL_URL");
					Thread.sleep(100);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
