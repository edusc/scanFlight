package br.com.theasier.searchflight.config;

import java.util.ResourceBundle;

import br.com.theasier.searchflight.util.ValidatorUtil;

/**
 * Recupera as definições das extrações
 * 
 * @author Eduardo Costa
 * 
 * */
public class ConfigSearch {
	
	static ResourceBundle bundle = getConfig("br.com.theasier.searchflight.config.config");
	
	private static ResourceBundle getConfig(String bundle) {
		return ResourceBundle.getBundle(bundle);
	}
	
	public static String[] getActiveSearchs() {
		String searchs = bundle.getString("active_searchs");
		if (ValidatorUtil.isNotEmpty(searchs)) {
			return searchs.split(",");
		}
		return null;
	}
	
	public static String getConfigClient() {
		return "br.com.theasier.searchFlight.config."+bundle.getString("config_cliente");
	}
	
	public static String getUrl() {
		return bundle.getString("url");
	}
	
	public static String getUser() {
		return bundle.getString("url");
	}
	
	public static String getPass() {
		return bundle.getString("url");
	}
	
	public static String getDriver() {
		return bundle.getString("driver");
	}

}
