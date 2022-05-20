package br.com.theasier.searchflight.util;


/**
 * Métodos úteis para se trabalhar com Strings.
 *
 * @author Eduardo Costa
 */
public class StringUtils {
	
	/** 
	 * Transforma uma String em camel case em formato legível por humanos, separando palavras
	 * por espaços.
	 */
	public static String humanFormat(String oldString) {
		if (oldString == null) {
			return null;
		}
		if (oldString.length() == 0) {
			return "";
		}

		char[] toCharArray = oldString.substring(1).toCharArray();
		StringBuilder builder = new StringBuilder();
		builder.append(String.valueOf(oldString.charAt(0)).toUpperCase());
		for (char c : toCharArray) {
			if(Character.isUpperCase(c)){
				builder.append(" ");
			}
			builder.append(c);
		}
		return builder.toString();
	}
	
	

}
