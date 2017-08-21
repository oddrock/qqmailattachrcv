package com.oddrock.mail.qqmailattachrcv;
import com.oddrock.common.prop.PropertiesReader;

public class Prop {
	private static final PropertiesReader PR = new PropertiesReader();
	static{
		load();
	}
	
	private static void load(){
		PR.addFilePath("qqmailattachrcv.properties");
		PR.loadProperties();
	}
	
	public static String get(String key){
		return PR.getValue(key);
	}
	
	public static int getInt(String key){
		return PR.getIntValue(key);
	}
	
	public static boolean getBool(String key){
		return PR.getBooleanValue(key);
	}
	
	public static String get(String key, String defaultValue) {
		return PR.getValue(key, defaultValue);
	}
}