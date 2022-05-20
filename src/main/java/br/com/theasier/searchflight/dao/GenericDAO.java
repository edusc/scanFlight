package br.com.theasier.searchflight.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import br.com.theasier.searchflight.config.ConfigSearch;

/***
 * DAO genérico da aplicação
 * 
 * @author Eduardo Costa
 **/
public class GenericDAO {
	
	private Session session;
	
	public static GenericDAO singleton;
	
	static Connection connDB;
	
	static JdbcTemplate jdbcTemplateDB;
	
	
	public static GenericDAO getInstance() {
		return null;
	}
	
	private static Connection getConnection(Connection con, String driver, String url, String user, String pass) {
		try {
			Class.forName(driver);
			if ( con == null ) 
				con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}	
	
	
	public static JdbcTemplate getJDBCTemplateDB() {
		if (jdbcTemplateDB == null) {
			jdbcTemplateDB = new JdbcTemplate(new SingleConnectionDataSource(getConnection(connDB, ConfigSearch.getDriver(), 
					ConfigSearch.getUrl(), ConfigSearch.getUser(), ConfigSearch.getPass()), false));
			return jdbcTemplateDB;
		}
		return jdbcTemplateDB;
	}


}
