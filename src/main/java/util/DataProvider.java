package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataProvider {

	private Properties masterdata=null;
	private Map<String,String>dataMap=new HashMap<String,String>();
	private Map<String,String>cardDetail=new HashMap<String,String>();
	
	
	public  DataProvider() {
		
		masterdata=new Properties();
		String  FileLoc=System.getProperty("user.dir") + "/data.properties";
		try {
			System.out.println(FileLoc);
			File f=new File(FileLoc);
			FileInputStream fis=new FileInputStream(f);
			masterdata.load(fis);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
		
		for(String key:masterdata.stringPropertyNames()) {
	String value=masterdata.getProperty(key).trim();
	dataMap.put(key, value);
	
		}
	}
	
	public Map<String,String> getDataMap(){
		
		return dataMap;
	}
}
