package org.weatherdetector.cache;

import java.util.Date;
import java.util.HashMap;

public class CacheInfo {
	public static HashMap<String, WeatherModel> map = new HashMap<String,WeatherModel>();

	private static CacheInfo cache;

	private CacheInfo() {
	}

	public static CacheInfo getInstance() {
		if (cache == null) {
			cache = new CacheInfo();
		}

		return cache;
	}
	
	public synchronized void cache(String key,WeatherModel weather) {
		//���»�������
		map.put(key, weather);
	}
	
	public static String getWeatherInfo(long waitTime) {
		// �����û����
		String result;
		// ��ǰ����ʱ��
		Date date = new Date();
		if (map.get("A_URL") != null
				&& map.get("A_URL").getResponseTime().getTime()
						- date.getTime() <= waitTime) {
			return map.get("A_URL").getResponse();
		} else if (map.get("B_URL") != null
				&& map.get("B_URL").getResponseTime().getTime()
						- date.getTime() <= waitTime) {
			return map.get("B_URL").getResponse();
		} else if (map.get("C_URL") != null
				&& map.get("C_URL").getResponseTime().getTime()
						- date.getTime() <= waitTime) {
			return map.get("C_URL").getResponse();
		} else {
			return "read from file";
		}

	}
}
