package service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import model.Flight;

public class CachingService {
	
	private static ConcurrentHashMap<String, List<Flight>> cache = new ConcurrentHashMap<String,List<Flight>>();
	
	public List<Flight> lookUp(String source,String destination,String flight_date){
		System.out.println("inside look up");
		String key = source+destination+flight_date;
	    synchronized(cache) {
	    	List<Flight> returnValue = cache.get(key);
	        if (returnValue != null) {
	            return returnValue;
	        }	
	        return null;
	    }
	}
	
	public void addToCache( String source,String destination,String flight_date,List<Flight> flightList ){
		System.out.println("inside add to cache");
		String key = source+destination+flight_date;
		if(cache.size()>2000){
			System.out.println("Inside add to cache");
            Object[] keys = cache.keySet().toArray();
            cache.remove(keys[0]);
        }
		cache.put(key, flightList);
	}
	
	public void updateCache( String source,String destination,String flight_date,List<Flight> flight ){
		System.out.println("inside update cache");
		String key = source+destination+flight_date;		
		if(cache.containsKey(key)){
			cache.replace(key, flight);
		}
	}
	
}
