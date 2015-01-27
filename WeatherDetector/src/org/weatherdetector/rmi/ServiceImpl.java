package org.weatherdetector.rmi;

import org.weatherdetector.cache.CacheInfo;

public class ServiceImpl implements Service {

	@Override
	public String service(long time) {
		return CacheInfo.getWeatherInfo(time);
	}
	
}
